/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.models;

import java.util.ArrayList;
import java.util.HashMap;
import thepianogame.controller.MainController;
import thepianogame.views.ChordObjectView;
import thepianogame.views.GameScreenView;

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

    static double fallRate = .01;
    static boolean rungame = true;

    public Game(MainController controller, GameScreenView gameScreen) {
        chords = new ArrayList<ChordObject>();
        key = 53;
        scale = major;
        score = 0;
        car = new Car();
        this.controller = controller;
        this.gameScreen = gameScreen;
        
        gameScreen.setCarModel(car);
    }

    public void setLoopInfo(int newTempo, double frameRate, int newKey, String newScale) {
        double beatsPerSecond = newTempo / 60.;
        double beatsPerFrame = beatsPerSecond / frameRate;
        fallRate = beatsPerFrame / 4; // chord falls on a per-bar instead of per-beat basis
        key = newKey;
        if (newScale.equals("Major")) {
            scale = major;
        } else {
            scale = minor;
        }
    }

    public void run(HashMap<Integer, Boolean> keymap) {

        // add new ChordObject if 
        if (chords.isEmpty()) {
//            // fix this so objects aren't always on the right side of the screen
//            chords.add(new ChordObject(Chord.getRandomChord(key, scale), true));
//            chords.get(0).chord.printChord();
            ChordObject chord = new ChordObject(Chord.getRandomChord(key, scale), 
                    !gameScreen.isCarOnRightSide());
            controller.makeChordView(chord);
            chords.add(chord);
            System.out.println("New chord: " + chords.get(0).name);
        }
        // advance all the current chords, hurt the player if a chord has
        // moved too far without being cleared
        for (int i = 0; i < chords.size();) {
            ChordObject chord = chords.get(i);
//            ChordObjectView chordView = new ChordObjectView(chord, controller);
            chord.position += fallRate;
            controller.incrementChordViews();
            if (chords.get(i).position >= 1) {
                lives--;
                chords.remove(i);
                car.onRightSide = !car.onRightSide;
            } else {
                i++;
            }
        }
        if (!chords.isEmpty()) {
            boolean goodNotes = true;
//            for (Note n : chords.get(0).chord.getNotes()) {
            ChordObject chord = chords.get(0);
            for (Note n : chord.chord.getNotes()) {
                if (keymap.containsKey(n.getValue()) && keymap.get(n.getValue())) {
                    System.out.println(n.getValue() + " is pressed!");
                } else {
                    goodNotes = false;
                    break;
                }
            }
            if (goodNotes) {
                System.out.println("GOOD CHORD!");
                controller.removeChordFromView(chord);
                score += 10;
                chords.remove(0);
                car.onRightSide = !car.onRightSide;
            }
        }

        if (lives <= 0) {
            // end the game
        }

    }
    
    private MainController controller;
    private final GameScreenView gameScreen;
}
