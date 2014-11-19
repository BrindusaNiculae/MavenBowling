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
public class Spare extends Frames {

    private int extraValue;

    public void setExtraValue(int value) {
        extraValue = value;
    }

    @Override
    public void calculate(int value1, int value2) {
        value = value1 + value2 + extraValue;
        this.setValue(value);
    }

}
