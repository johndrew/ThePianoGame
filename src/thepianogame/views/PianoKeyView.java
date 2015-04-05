/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.views;

import javax.swing.JPanel;

public class PianoKeyView extends JPanel {
    
    public PianoKeyView(PIANOKEY_TYPE type) {
        this.type = type;
    }
    
    public enum PIANOKEY_TYPE {
        WHITE_KEY, 
        BLACK_KEY
    }
    
    public PIANOKEY_TYPE getType() {
        return this.type;
    }
    
    private PIANOKEY_TYPE type;
}
