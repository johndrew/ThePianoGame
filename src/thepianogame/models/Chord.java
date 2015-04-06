/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.models;

import java.util.ArrayList;
import java.util.Random;

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
    
    public String getName() {
        /*
         Returns a list of the notes in this chord
         */
        return this.name;
    }

    /*
     */
    public static Chord getRandomChord(int key, Scale scale/*, sevenths*/) {
        Random r = new Random();
        int root = r.nextInt(7);
        int third = root + 2;
        int fifth = root + 4;
        ArrayList<Note> _notes = new ArrayList<Note>();

        // if statements handle chord notes that go beyond the first 
        // octave of the scale
        _notes.add(new Note(key + scale.steps[root]));
        if (third > 6) {
            _notes.add(new Note(key + scale.steps[third % 7] + 12));
        } else {
            _notes.add(new Note(key + scale.steps[third]));
        }
        if (fifth > 6) {
            _notes.add(new Note(key + scale.steps[fifth % 7] + 12));
        } else {
            _notes.add(new Note(key + scale.steps[fifth]));
        }
        /*
         int octave = random(-2, 2);
         for (Note n : this.notes) {
         n += octave;

         }
         */
        return new Chord(scale.chords[root] + " " + (root + 1), _notes);
    }   
    
    public void printChord() {
        String out = name;
        for (Note n : notes) {
            out += (" " + n.getValue());
        }
        System.out.println(out);
    }
}
