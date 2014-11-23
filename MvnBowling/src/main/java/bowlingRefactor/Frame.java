/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowlingRefactor;

import java.util.Scanner;

/**
 *
 * @author Brindu
 */
public class Frame {

    private Roll roll1, roll2, nextRoll;
    private int value1, value2, extraValue;
    private boolean readR1, readR2;
    private String filename;
    private Scanner s;

    Frame(String filename, Scanner s) {
        roll1 = new Roll();
        roll2 = new Roll();
        nextRoll = new Roll();
        value1 = value2 = extraValue = -1;
        readR1 = true;
        readR2 = true;
        this.filename = filename;
        this.s = s;
    }

    public void calculatePartialScore(PartialScore ps) {
        readRoll(roll1, readR1, value1);
        readRoll(roll2, readR2, value2);
        if (value2 > 0) {
            computeNext(ps);
        }
    }

    private void readRoll(Roll roll, boolean readable, int value) {
        if (readable) {
            roll.getValue(filename, s, value);
        }
    }

    private void computeNext(PartialScore ps) {
        if (value1 + value2 < 10) {
            computeForOpen(ps);
        } else {
            readRoll(nextRoll, true, extraValue);
            if (value2 != 0 && value1 + value2 == 10) {
                computeForSpare(ps);
            } else {
                computeForStrike(ps);
            }
        }
    }

    private void computeForOpen(PartialScore ps) {
        ps.setValue(value1 + value2);
        setFlagsForOpen();
    }

    private void computeForSpare(PartialScore ps) {
        ps.setValue(value1 + value2 + extraValue);
        updateValuesForSpare();
        setFlagsForSpare();
    }

    private void computeForStrike(PartialScore ps) {
        ps.setStrike(true);
        ps.setValue(value1 + value2 + extraValue);
        updateValuesForStrike();
        setFlagsForStrike();
    }

    private void updateValuesForSpare() {
        value1 = extraValue;
        value2 = -1;
        extraValue = -1;
    }

    private void updateValuesForStrike() {
        value1 = value2;
        value2 = extraValue;
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

}
