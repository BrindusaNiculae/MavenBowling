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
public class Roll {

    private int value;

    Roll() {
        value = -1;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
