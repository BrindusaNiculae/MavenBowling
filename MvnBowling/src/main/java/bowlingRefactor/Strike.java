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
public class Strike extends Frames {

    private int extraValue1, extraValue2;

    public void setExtraValue1(int value) {
        extraValue1 = value;
    }

    public void setExtraValue2(int value) {
        extraValue2 = value;
    }

    @Override
    public void calculate(int value1, int value2) {
        value = value1 + value2 + extraValue1 + extraValue2;
        this.setValue(value);
    }
}
