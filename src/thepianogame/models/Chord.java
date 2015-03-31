/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.models;

import java.util.ArrayList;

public class Chord {
    
    private String name;
    private ArrayList<Note> notes;
    
    //TODO: figure out some way to set notes as root, third, fifth, etc.
    public Chord(String name, ArrayList<Note> notes) {
        this.name = name;
        this.notes = notes;
    }
    
    public ArrayList<Note> getNotes() {
        /*
            Returns a list of the notes in this chord
        */
        return this.notes;
    }
}
