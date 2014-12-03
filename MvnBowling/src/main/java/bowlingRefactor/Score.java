/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowlingRefactor;

import com.sun.org.apache.xpath.internal.operations.Equals;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 *
 * @author Brindu
 */
public class Score {

    private int nrOfPerfectFrames;
    private int finalScore;

    private final HashMap<Integer, String> finalScoreOutput = new HashMap<Integer, String>() {
        {
            put(12, "printPerfectGame");
            put(11, "printGame");
            put(10, "printGame");
            put(9, "printGame");
            put(8, "printGame");
            put(7, "printGame");
            put(6, "printGame");
            put(5, "printGame");
            put(4, "printGame");
            put(3, "printGame");
            put(2, "printGame");
            put(1, "printGame");
            put(0, "printGame");
        }
    };

    Score() {
        nrOfPerfectFrames = 0;
        finalScore = 0;
    }

    public Score(int i) {
        finalScore = i;
    }

    public void setPerfect() {
        nrOfPerfectFrames++;
    }

    public void calculate(int value) {
        finalScore += value;
    }

    public void getFinalScore() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String outputMethod = finalScoreOutput.get(this.nrOfPerfectFrames);
        Method method = this.getClass().getMethod(outputMethod, null);
        method.invoke(this, null);
    }

    public void printPerfectGame() {
        System.out.println("You played a perfect game, the score is 300");
    }

    public void printGame() {
        System.out.println("The score: " + this.finalScore);
    }

    public Score testScore() {
        return this;
    }

}
