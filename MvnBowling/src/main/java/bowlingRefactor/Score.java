/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowlingRefactor;

import java.util.ArrayList;

/**
 *
 * @author Brindu
 */
public class Score {

    private ArrayList<PartialScore> partialScores;
    private int nrOfPerfectFrames;
    private FinalScore finalScore;

    Score() {
        partialScores = new ArrayList<PartialScore>(12);
        nrOfPerfectFrames = 0;
        finalScore = new FinalScore();
    }

    public void addPartialScore(PartialScore ps) {
        partialScores.add(ps);
    }

    public void getScoreFinalScore() {

        int auxScore = 0;
        for (PartialScore p : partialScores) {
            p.addValue(auxScore);
            boolean b = false;
            p.getStrike(b);
            if (b) {
                nrOfPerfectFrames++;
            }
        }
        if (nrOfPerfectFrames == 12) {
            finalScore.setValue(300);
        } else {
            finalScore.setValue(auxScore);
        }
    }

}
