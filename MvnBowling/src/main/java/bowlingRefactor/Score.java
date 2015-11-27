/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowlingRefactor;

/**
 *
 * @author Brindu
 */
public class Score {
    private int finalScore;

    Score() {
        finalScore = 0;
    }

    public void add(int value) {
        finalScore += value;
    }

    public void publishTo(ScoreHandler scoreHandler) {
        scoreHandler.publish(finalScore);
    }
}
