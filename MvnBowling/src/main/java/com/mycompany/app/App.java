package com.mycompany.app;

import bowlingRefactor.Player;
import bowlingRefactor.ScoreHandler;

import java.io.FileNotFoundException;

/**
 * Hello world!
 *
 */
public class App {



    public static void main(String[] args) throws FileNotFoundException {

        for (int i = 1; i <= 17; i++) {
            String filename = "game" + (i) + ".txt";
            Player player = new Player(filename);
            player.play();

            player.publishScoreTo(new StandardOutputFor(i));
        }
    }

    //~~~~~~~ Remember: Tell don't ask ~~~~~~

    private static class StandardOutputFor implements ScoreHandler {
        private final int nrFisier;

        public StandardOutputFor(int nrFisier) {
            this.nrFisier = nrFisier;
        }

        @Override
        public void publish(int score) {
            System.out.println("Scor final pt fisierul " + nrFisier
                    + " :" + score);
        }
    }
}
