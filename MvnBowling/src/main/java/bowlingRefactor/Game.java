/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowlingRefactor;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Brindu
 */
public class Game {

    private Roll roll1, roll2, nextRoll;
    private Frames frame;
    private Score score;
    private String filename;
    private Scanner scanner;
    private boolean readR1;
    private boolean readR2;

    Game(String filename) throws FileNotFoundException {
        roll1 = new Roll();
        roll2 = new Roll();
        nextRoll = new Roll();
        frame = new Frames();
        score = new Score();
        scanner = new Scanner(new File(filename));
        readR1 = true;
        readR2 = true;
    }
    private final HashMap<Boolean, String> readFileMethods = new HashMap<Boolean, String>() {
        {
            put(true, "readForTrue");
            put(false, "readForFalse");
        }
    };

    private final HashMap<Boolean, String> readValueMethodsTrue = new HashMap<Boolean, String>() {
        {
            put(true, "setValueFromFile");
            put(false, "doNothing");
        }
    };

    private final HashMap<Boolean, String> readValueMethodsFalse = new HashMap<Boolean, String>() {
        {
            put(true, "setValueNeg");
            put(false, "doNothing");
        }
    };

    private final HashMap<Boolean, String> whileReplacer = new HashMap<Boolean, String>() {
        {
            put(true, "goOn");
            put(false, "doNothing");
        }
    };

    public void doNothing() {
    }

    public void doNothing(Roll roll, boolean b) {
    }

    public void startGame() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String methodName = whileReplacer.get(scanner.hasNext());
        Method method = this.getClass().getMethod(methodName, null);
        method.invoke(this, null);
    }

    public void goOn() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        readRoll(roll1, readR1);
        readRoll(roll2, readR2);
        roll2.playFrame(this);
        startGame();
    }

    public void playOn() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        roll1.computeNext(roll2, this);
        updateScore();
    }

    public Score getFinalScore() {
        return score;
    }

    private void readRoll(Roll roll, boolean readable) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String methodName = readFileMethods.get(scanner.hasNext());
        Method method = this.getClass().getMethod(methodName, Roll.class, boolean.class);
        method.invoke(this, roll, readable);
    }

    public void readForTrue(Roll roll, boolean readable) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String methodName = readValueMethodsTrue.get(readable);
        Method method = this.getClass().getMethod(methodName, Roll.class, boolean.class);
        method.invoke(this, roll, readable);
    }

    public void readForFalse(Roll roll, boolean readable) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String methodName = readValueMethodsFalse.get(readable);
        Method method = this.getClass().getMethod(methodName, Roll.class, boolean.class);
        method.invoke(this, roll, readable);
    }

    public void setValueFromFile(Roll roll, boolean readable) {
        roll.setValue(scanner.nextInt());
    }

    public void setValueNeg(Roll roll, boolean readable) {
        roll.setValue(-1);
    }

    public void computeForOpen() {
        roll1.calculate(roll2, new Roll(0), frame);
        setFlagsForOpen();
    }

    private void computeCommons() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        readRoll(nextRoll, true);
        nextRoll.setFrameExtraValue(frame);
        roll1.calculate(roll2, nextRoll, frame);
        frame.setExtraValue(0);
    }

    public void computeForSpare() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        computeCommons();
        updateForSpare();
        setFlagsForSpare();
    }

    public void computeForStrike() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        computeCommons();
        score.setPerfect();
        updateForStrike();
        setFlagsForStrike();
    }

    private void updateForSpare() {
        roll1.setNewValue(nextRoll);
        roll2.setValue(-1);
        nextRoll.setValue(0);
    }

    private void updateForStrike() {
        roll1.setNewValue(roll2);
        roll2.setNewValue(nextRoll);
        nextRoll.setValue(0);
    }

    private void setFlagsForOpen() {
        readR1 = true;
        readR2 = true;
    }

    private void setFlagsForSpare() {
        readR1 = false;
        readR2 = true;
    }

    private void setFlagsForStrike() {
        readR1 = false;
        readR2 = false;
    }

    private void updateScore() {
        frame.calculateScore(score);
    }
}
