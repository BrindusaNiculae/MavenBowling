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
    public String filename;
    public Scanner scanner;
    private int frameNr;

    Game(String filename) throws FileNotFoundException {
        pins = new Pins();
        roll1 = new Roll();
        roll2 = new Roll();
        nextRoll1 = new Roll();
        nextRoll2 = new Roll();
        partialScore = new PartialScore();
        score = new Score();
        scanner = new Scanner(new File(filename));
        frameNr = 0;
    }

    public int startGame() {
        boolean readR1 = true;
        boolean readR2 = true;
        boolean readNR = true;
        while (pins.hasPins(filename, scanner)) {
            if (readR1) {
                roll1.setValue(pins.knockDown(filename, scanner));
            }
            if (pins.hasPins(filename, scanner) && readR2) {
                roll2.setValue(pins.knockDown(filename, scanner));
            } else if (readR2) {
                roll2.setValue(-1);
            }
            /*OPEN*/
            if (roll2.getValue() >= 0) {
                if (roll1.getValue() + roll2.getValue() < 10) {
                    frame = new Open();
                    frame.calculate(roll1.getValue(), roll2.getValue());
                    readR1 = true;
                    readR2 = true;
                    readNR = true;
                } /*SPARE*/ else if (roll2.getValue() != 0 && roll1.getValue() + roll2.getValue() == 10) {
                    frame = new Strike();
                    nextRoll1.setValue(pins.knockDown(filename, scanner));
                    frame.setExtraValue1(nextRoll1.getValue());
                    frame.calculate(roll1.getValue(), roll2.getValue());

                    roll1.setValue(nextRoll1.getValue());
                    roll2.setValue(-1);
                    nextRoll1.setValue(-1);
                    readR1 = false;
                    readR2 = true;
                    readNR = true;
                } /*STRIKE*/ else {
                    score.setPerfect();
                    frame = new Strike();
                    if (readNR && pins.hasPins(filename, scanner)) {
                        nextRoll1.setValue(pins.knockDown(filename, scanner));
                    }
                    frame.setExtraValue1(nextRoll1.getValue());
                    frame.calculate(roll1.getValue(), roll2.getValue());

                    roll1.setValue(roll2.getValue());
                    roll2.setValue(nextRoll1.getValue());
                    readR1 = false;
                    readR2 = false;

                }
                partialScore.setValue(frame.getValue());
                score.calculate(partialScore.getValue());

            }
        }
        return score.getScore();
    }

}
