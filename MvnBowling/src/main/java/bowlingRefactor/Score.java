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

    private int nrOfPerfectFrames;
    private int finalScore;

    Score() {
        nrOfPerfectFrames = 0;
        finalScore = 0;
    }

    public Score(int i) {
        finalScore = i;
    }

    public void setPerfect() {
        nrOfPerfectFrames++;
        // System.out.println("am ajuns aici: " + nrOfPerfectFrames);
    }

    public void calculate(int value) {
        finalScore += value;
    }

    public void getFinalScore() {
        if (nrOfPerfectFrames == 12) {
            System.out.println("FinalScore = 300");
        } else {
            System.out.println("FinalScore = " + this.finalScore);
        }
    }

    public int getScoreForTest() {
        return finalScore;
    }

}
