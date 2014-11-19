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
    public boolean hasPins(String filename, Scanner s){
        return s.hasNextInt();
    }
    
    public int knockDown(String filename, Scanner s){
        return s.nextInt();
    }
}
