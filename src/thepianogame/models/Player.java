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
        return "0";
    }
    
    public void loseLife(){
        lives -= 1;
    }
    
    public void reset() {
        score = 0;
        lives = 3;
    }
}
