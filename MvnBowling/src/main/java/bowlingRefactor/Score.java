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
    private int finalScore;


    Score() {
        finalScore = 0;
    }

    public Score(int i) {
        finalScore = i;
    }

    public void calculate(int value) {
        finalScore += value;
    }

    public void getFinalScore() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        System.out.println("The score: " + this.finalScore);

    }
}
