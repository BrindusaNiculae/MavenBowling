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

    private Frame frame;
    private Score score;
    private String filename;
    private Scanner scanner;
    private PartialScore ps;

    Game(String filename) throws FileNotFoundException {
        score = new Score();
        this.filename = filename;
        scanner = new Scanner(new File(filename));
        frame = new Frame(this.filename, scanner);
    }

    public void playGame() {
        for (int i = 0; i < 9; i++) {
            processFrame();
        }
        verifyExtraRolls(ps);
    }

    private void processFrame() {
        ps = new PartialScore();
        frame.calculatePartialScore(ps);
        score.addPartialScore(ps);
    }

    private void verifyExtraRolls(PartialScore ps) {
        int value = 0;
        ps.getValue(value);
        if (value == 10) {
            processFrame();
        }
    }
}
