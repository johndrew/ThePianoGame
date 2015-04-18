/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.models;

import thepianogame.views.GameScreenView;
import thepianogame.views.PianoView;

/**
 *
 * @author marinastoebner
 */
public class Player {
    
    public int score;
    public int lives;
    
    public Player(int score, int lives) {
        this.score = score; 
        this.lives = lives;
    }
    
    public String getScore(){
        return String.valueOf(this.score);
    }
    
    // adds 10 points to the player's score when they correctly play a chord
    public void increaseScore() {
        score +=10;
    }
    
    // removes a life from the player
    public void loseLife(){
        lives -= 1;
    }
    

    
}
