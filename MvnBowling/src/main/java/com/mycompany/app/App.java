package com.mycompany.app;

import bowlingRefactor.Player;
import java.io.FileNotFoundException;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws FileNotFoundException {

        for (int i = 1; i <= 17; i++) {
            String filename = "game" + (i) + ".txt";
            Player p = new Player(filename);
            p.play();
            int rezult = p.getScore();
            System.out.println("Scor final pt fisierul " + i
                    + " :" + rezult);
        }
    }
}
