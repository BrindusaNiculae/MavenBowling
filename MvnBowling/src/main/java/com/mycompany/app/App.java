package com.mycompany.app;

import bowlingRefactor.Player;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws FileNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        for (int i = 1; i <= 17; i++) {
            String filename = "game" + (i) + ".txt";
            Player p = new Player(filename);
            p.play();
            p.getScore();
        }
    }
}
