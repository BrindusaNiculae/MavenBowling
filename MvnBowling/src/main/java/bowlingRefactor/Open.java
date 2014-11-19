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
public class Open extends Frames {

    @Override
    public void calculate(int value1, int value2) {
       value = value1 + value2;
       this.setValue(value);
    }

}
