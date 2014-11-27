/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowlingRefactor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Brindu
 */
public class Game {

    private Pins pins;
    private Roll roll1, roll2, nextRoll;
    private Frames frame;
    private Score score;
    private String filename;
    private Scanner scanner;
    private boolean readR1;
    private boolean readR2;

    Game(String filename) throws FileNotFoundException {
        pins = new Pins();
        roll1 = new Roll();
        roll2 = new Roll();
        nextRoll = new Roll();
        frame = new Frames();
        score = new Score();
        scanner = new Scanner(new File(filename));
        readR1 = true;
        readR2 = true;
    }

    public void startGame() {
        while (pins.hasPins(filename, scanner)) {
            readRoll(roll1, readR1);
            readRoll(roll2, readR2);
            roll2.playFrame(this);
        }
    }

    public void playOn() {
        roll1.computeNext(roll2, this);
        updateScore();
    }

    public Score getFinalScore(){
       return score;
    }
    private void readRoll(Roll roll, boolean readable) {
        if (pins.hasPins(filename, scanner) && readable) {
            roll.setValue(pins.knockDown(filename, scanner));
        } else if (readable) {
            roll.setValue(-1);
        }
    }

    public void computeForOpen() {        
        roll1.calculate(roll2,new Roll(0), frame);
        setFlagsForOpen();
    }

    private void computeCommons() {
        readRoll(nextRoll, true);
        nextRoll.setFrameExtraValue(frame);
        roll1.calculate(roll2, nextRoll, frame);
        frame.setExtraValue(0);
    }

    public void computeForSpare() {
        computeCommons();
        updateForSpare();
        setFlagsForSpare();
    }

    public void computeForStrike() {
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
