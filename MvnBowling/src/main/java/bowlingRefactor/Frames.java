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
public class Frames {

    private int value;
    private int extraValue;

    public Frames() {
        this.value = 0;
        this.extraValue = 0;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setExtraValue(int value) {
        this.extraValue = value;
    }

    public void calculateScore(Score score) {
        score.calculate(this.value);
    }

}
