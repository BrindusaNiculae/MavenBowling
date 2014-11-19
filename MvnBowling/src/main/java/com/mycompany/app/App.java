package com.mycompany.app;

import java.io.FileNotFoundException;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws FileNotFoundException {
        int[] rolls;
        
        for (int i = 1; i <= 17; i++) {
            String filename = "game" + (i) + ".txt";
            Bowling ex2 = new Bowling();
            rolls = ex2.readFile(filename);
            ex2.setGameNr(i);
            int rezult = ex2.computeScoreFor(rolls);
            System.out.println("-Scorul final pt fisierul " + i
                    + " :" + rezult);
        }
    }
}
