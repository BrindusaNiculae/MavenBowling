/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowlingRefactor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brindu
 */
public class Roll {

    private int value;
    private final HashMap<Integer, String> computeMethods = new HashMap<Integer, String>() {
        {
            put(0, "computeForOpen");
            put(1, "computeForOpen");
            put(2, "computeForOpen");
            put(3, "computeForOpen");
            put(4, "computeForOpen");
            put(5, "computeForOpen");
            put(6, "computeForOpen");
            put(7, "computeForOpen");
            put(8, "computeForOpen");
            put(9, "computeForOpen");
            put(10, "computeForSpare");
            put(11, "computeForStrike");
            put(12, "computeForStrike");
            put(13, "computeForStrike");
            put(14, "computeForStrike");
            put(15, "computeForStrike");
            put(16, "computeForStrike");
            put(17, "computeForStrike");
            put(18, "computeForStrike");
            put(19, "computeForStrike");
            put(20, "computeForStrike");
        }
    };

    private final HashMap<Integer, String> playOnMethod = new HashMap<Integer, String>() {
        {
            put(-1, "doNothing");
            put(0, "playOn");
            put(1, "playOn");
            put(2, "playOn");
            put(3, "playOn");
            put(4, "playOn");
            put(5, "playOn");
            put(6, "playOn");
            put(7, "playOn");
            put(8, "playOn");
            put(9, "playOn");
            put(10, "playOn");

        }
    };

    Roll() {
        value = -1;
    }

    Roll(int i) {
        value = 0;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void computeNext(Roll roll, Game game) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int frameValue = this.value + roll.value;
        String methodName = computeMethods.get(frameValue);

        Method method = game.getClass().getMethod(methodName, null);
        method.invoke(game, null);
    }

    public void setFrameExtraValue(Frames frame) {
        frame.setExtraValue(this.value);
    }

    public void calculate(Roll roll, Roll nextRoll, Frames frame) {
        frame.setValue(this.value + roll.value + nextRoll.value);
    }

    public void setNewValue(Roll roll) {
        this.setValue(roll.value);
    }

    public void playFrame(Game game) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String methodName = playOnMethod.get(this.value);
        Method method = game.getClass().getMethod(methodName, null);
        method.invoke(game, null);
    }
}
