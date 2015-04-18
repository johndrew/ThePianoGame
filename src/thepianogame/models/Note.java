/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.models;

public class Note {

    private int value;
    private String name;

    public Note(int value) {
        this.value = value;
        switch (value % 12) {
            case 0:
                this.name = "C";
                break;
            case 1:
                this.name = "C#";
                break;
            case 2:
                this.name = "D";
                break;
            case 3:
                this.name = "D#";
                break;
            case 4:
                this.name = "E";
                break;
            case 5:
                this.name = "F";
                break;
            case 6:
                this.name = "F#";
                break;
            case 7:
                this.name = "G";
                break;
            case 8:
                this.name = "G#";
                break;
            case 9:
                this.name = "A";
                break;
            case 10:
                this.name = "A#";
                break;
            case 11:
                this.name = "B";
                break;
        }
    }

    public int getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }
}
