/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowlingRefactor;

import java.awt.Frame;
import java.util.Scanner;

/**
 *
 * @author Brindu
 */
public class Roll {

    private Pins pins;
    private int value;
    
    Roll(){
        value = -1;
        pins = new Pins();
    }

    public void getValue(String filename,Scanner s, int value){
        Boolean b = true;
        pins.hasPins(filename, s, b);
        
        if(b){
            pins.knockDown(filename, s);
            this.pins.getValue(this.value);
            value = this.value;
        } else {
            this.value = -1;
            value = this.value;
        }
    }
}
