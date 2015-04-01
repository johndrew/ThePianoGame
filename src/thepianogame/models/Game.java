/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.models;

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

    public Game() {
        run();
    }

    public void run() {
        // main game loop
        while (true) {
            break;
        }
    }
}
