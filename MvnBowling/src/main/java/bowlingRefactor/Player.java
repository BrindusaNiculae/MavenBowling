/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowlingRefactor;

import java.io.FileNotFoundException;

/**
 *
 * @author Brindu
 */
public class Player {

    private Game game;

    public Player(String filename) throws FileNotFoundException {
        game = new Game(filename);
    }

    public int play() {
        return game.startGame();
    }
}
