/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.models;

/**
 *
 * @author graham
 */
public class Scale {
    
    int[] steps;
    String[] chords;
    
    public Scale(int[] steps, String[] chords) {
        this.steps = steps;
        this.chords = chords;
    }
    
}
