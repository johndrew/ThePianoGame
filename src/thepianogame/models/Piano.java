/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.models;

import java.util.ArrayList;

public class Piano {
    
    private ArrayList<PianoKey> keys;
    
    public Piano(int totalKeys) {
        makeKeyObjects(totalKeys);
    }
    
    public void makeKeyObjects(int totalKeys) {
        /*
            Typical keyboard key counts are: {49, 61, 73, 76, 88}
            I believe javax.sound.midi.MidiDevice.getReceivers() can 
            retrieve the number of keys. This info will be needed to make
            the piano visualization.
        */
    }
}
