/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.models;

import java.util.UUID;

public class ChordObject {

    public String name;
    public Chord chord;
    public double position; // ranges from 0 - 1 (0 is the top of the screen,
                            // 1 is whatever part of the screen hurts the player.
                            // makes it easier to draw on screens of any size
    public boolean onRightSide;
    public String id = UUID.randomUUID().toString();

    public ChordObject(Chord chord, boolean onRightSide) {
        this.name = chord.getName();
        this.chord = chord;
        this.position = 0;
        this.onRightSide = onRightSide;
    }
    
    public boolean getLanePosition() {
        return this.onRightSide;
    }
}
