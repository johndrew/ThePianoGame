/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.models;

import java.util.ArrayList;

/**
 *
 * @author taylorstheking4
 */
public class Chord {
    
    private String name;
    private ArrayList<Note> notes;
    
    public Chord(String name, ArrayList<Note> notes) {
        this.name = name;
        this.notes = notes;
    }
    
    public ArrayList<Note> getNotes() {
        return this.notes;
    }
}
