package com.mycompany.app;

import bowlingRefactor.FinalScore;
import bowlingRefactor.Player;
import java.io.FileNotFoundException;

/**
 * Hello world!
 *
 */
public class App {
  
    public static void main(String[] args) throws FileNotFoundException {

        for (int i = 1; i <= 17; i++) {
            //String filename = "game" + (i) + ".txt";
            String filename = "game3.txt";
            Player p = new Player(filename);
            p.play();
            FinalScore f = new FinalScore();
            int x = 0;
            f.getFinalScore(x);
        }
    }
}
