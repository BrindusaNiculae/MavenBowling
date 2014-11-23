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
public class FinalScore {
    
    private int value;
    
    public FinalScore(){
        value = 0;
    }
    
    public void setValue(int value){
        this.value = value;
    }
    
    public void getFinalScore(int value){
        //System.out.println("The final score is: " + this.value);
        value = this.value;
    }
    
}
