/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.models;

public class PianoKey {
    
    public enum PIANOKEY_TYPE {WHITE_TYPE, BLACK_TYPE};
    private String name;
    private int octaveNumber;
    private PIANOKEY_TYPE type;
    
    public PianoKey(String name, int octaveNumber, PIANOKEY_TYPE type) {
        this.name = name;
        this.type = type;
        this.octaveNumber = octaveNumber;
    }
    
    public String getName() {
        return name;
    }
    
    public int getOctaveNumber() {
        return octaveNumber;
    }
}
