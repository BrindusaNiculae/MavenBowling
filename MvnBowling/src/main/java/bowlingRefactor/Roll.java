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

    Roll(int i) {
       value = 0;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void computeNext(Roll roll, Game game) {
        if (this.value + roll.value < 10) {
            game.computeForOpen();
        } else {
            if (roll.value != 0 && this.value + roll.value == 10) {
                game.computeForSpare();
            } else {
                game.computeForStrike();
            }
        }
    }

    public void setFrameExtraValue(Frames frame) {
        frame.setExtraValue(this.value);
    }

    public void calculate(Roll roll, Roll nextRoll, Frames frame) {
        frame.setValue(this.value + roll.value + nextRoll.value);
    }

    public void setNewValue(Roll roll) {
        this.setValue(roll.value);
    }

    public void playFrame(Game game) {
        if(this.value >= 0){
            game.playOn();
        }}
}
