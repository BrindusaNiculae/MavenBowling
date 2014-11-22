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
public abstract class Frames {

    protected int value;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void calculate(int value1, int value2) {
        /*In functie de tipul frame-ului, value ca avea o valoare care depinde
         -         de value1 si value2
         -         */
        this.setValue(0);
    }

    public void setExtraValue(int value) {
    }

}
