/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowlingRefactor;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author Brindu
 */
public class Player {

    private final Game game;

    public Player(String filename) throws FileNotFoundException {
        game = new Game(filename);
    }

    public void play() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        game.startGame();
    }

    public void getScore() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        game.getFinalScore().getFinalScore();
    }

    public Score getScoreForTest() {
        return game.getFinalScore().testScore();
    }
}
