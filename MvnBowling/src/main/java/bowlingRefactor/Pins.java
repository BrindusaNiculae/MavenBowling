/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowlingRefactor;

import java.util.Scanner;

/**
 *
 * @author Brindu
 */
public class Pins {
    int value = -2;

    public void hasPins(String filename, Scanner s, Boolean b) {
        b = s.hasNextInt();
    }

    public void knockDown(String filename, Scanner s) {
        this.value = s.nextInt();
    }
    
    public void getValue(int value){
        value = this.value;
    }
}
