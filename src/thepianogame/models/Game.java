/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.models;

import java.util.ArrayList;

public class Game {

    static Scale major
            = new Scale(new int[]{0, 2, 4, 5, 7, 9, 11}, new String[]{"major",
                "minor", "minor", "major", "major", "minor", "diminished"});
    static Scale minor
            = new Scale(new int[]{0, 2, 3, 5, 7, 8, 10}, new String[]{"minor",
                "diminished", "major", "minor", "minor", "major", "major"});
    static final String[] keyNames
            = new String[]{"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A",
                "A#", "B"};
    static ArrayList<ChordObject> chords;
    static int key;
    static Scale scale;
    static int lives;
    static int score;
    static Car car;

    final static double fallRate = .01;
    static boolean rungame = true;

    public Game() {
        chords = new ArrayList<ChordObject>();
        key = 1;
        scale = minor;
        score = 0;
        car = new Car();
    }

    public void run() {

        // add new ChordObject if there aren't any
        if (chords.isEmpty()) {
            // fix this so objects aren't always on the right side of the screen
            chords.add(new ChordObject(Chord.getRandomChord(key, scale), true));
        }
            // advance all the current chords, hurt the player if a chord has
        // moved too far without being cleared
        for (int i = 0; i < chords.size();) {
            chords.get(i).position += fallRate;
            if (chords.get(i).position >= 1) {
                lives--;
                chords.remove(i);
                car.onRightSide = !car.onRightSide;
            } else {
                i++;
            }
        }
            // FIXME: CHECK IF CORRECT KEYS ARE PRESSED. do something like:
        // bool goodNotes = true;
        // for (note n : chords.get(0).getNotes()) {
        //      if (n isn't pressed) {
        //          goodNotes = false;
        //          break;
        //      }
        // }
        // if (goodNotes) {
        //      score += 10;
        //      chords.remove(i);
        //      car.onRightSide = !car.onRightSide;
        // }

        if (lives <= 0) {
            // end the game
        }

    }
}
