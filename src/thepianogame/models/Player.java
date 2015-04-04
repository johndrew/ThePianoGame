/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.models;

/**
 *
 * @author marinastoebner
 */
public class Player {
    
    public int score = 0;
    public int lives = 3;
    
    public String getScore(){
        return String.valueOf(score);
    }
    
    // adds 10 points to the player's score when they correctly play a chord
    public void increaseScore() {
        score +=10;
    }
    
    // removes a life from the player
    public void loseLife(){
        lives -= 1;
    }
    
    // resets the score to 0 and lives to 3
    public void resetPlayer() {
        score = 0;
        lives = 3;
    }
}
