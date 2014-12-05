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
    private Roll roll1, roll2, nextRoll1, nextRoll2;
    private Frames frame;
    private PartialScore partialScore;
    private Score score;
    private String filename;
    private Scanner scanner;
    private boolean readR1;
    private boolean readR2;

    Game(String filename) throws FileNotFoundException {
        pins = new Pins();
        roll1 = new Roll();
        roll2 = new Roll();
        nextRoll1 = new Roll();
        nextRoll2 = new Roll();
        partialScore = new PartialScore();
        score = new Score();
        scanner = new Scanner(new File(filename));
        readR1 = true;
        readR2 = true;
    }

    public void startGame() {
        while (pins.hasPins(filename, scanner)) {
            readRoll(roll1, readR1);
            readRoll(roll2, readR2);
            if (roll2.getValue() >= 0) {
                decideFrameType();
                computeNext();
                updateScore();
            }
        }
    }

    public Score getFinalScore() {
        return score;
    }

    private void readRoll(Roll roll, boolean readable) {
        if (pins.hasPins(filename, scanner) && readable) {
            roll.setValue(pins.knockDown(filename, scanner));
        } else if (readable) {
            roll.setValue(-1);
        }
    }

    private void decideFrameType() {
        if (roll1.getValue() + roll2.getValue() < 10) {
            frame = new Open();
        } else {
            frame = new StrikeOrSpare();
        }
    }

    private void computeNext() {
        if (frame.getFrameType().equals("OPEN")) {
            computeForOpen();
        } else if (frame.getFrameType().equals("STRIKE||SPARE")) {
            readRoll(nextRoll1, true);
            frame.setExtraValue(nextRoll1.getValue());
            if (roll2.getValue() != 0 && roll1.getValue() + roll2.getValue() == 10) {
                computeForSpare();
            } else {
                computeForStrike();
            }
        }
    }

    private void computeForOpen() {
        frame.calculate(roll1.getValue(), roll2.getValue());
        setFlagsForOpen();
    }

    private void computeForSpare() {
        frame.calculate(roll1.getValue(), roll2.getValue());
        updateValuesForSpare();
        setFlagsForSpare();
    }

    private void computeForStrike() {        
        score.setPerfect();
        frame.calculate(roll1.getValue(), roll2.getValue());
        updateValuesForStrike();
        setFlagsForStrike();
    }

    private void updateValuesForSpare() {
        roll1.setValue(nextRoll1.getValue());
        roll2.setValue(-1);
        nextRoll1.setValue(-1);
    }

    private void updateValuesForStrike() {
        roll1.setValue(roll2.getValue());
        roll2.setValue(nextRoll1.getValue());
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
        partialScore.setValue(frame.getValue());
        score.calculate(partialScore.getValue());
    }

    public void publishScore(ScoreHandler scoreHandler) {
        score.publishTo(scoreHandler);
    }
}
