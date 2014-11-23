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
public class PartialScore {

    private int value;
    private boolean isStrike;

    PartialScore() {
        value = 0;
        isStrike = false;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void addValue(int auxScore) {
        auxScore += this.value;
    }

    public void setStrike(boolean b) {
        this.isStrike = b;
    }

    public void getStrike(boolean b) {
        b = this.isStrike;
    }

    public void getValue(int value) {
        value = this.value;
    }

}
