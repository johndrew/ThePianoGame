/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.views;

import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import thepianogame.controller.MainController.CONTROL_MODE;
import static thepianogame.controller.MainController.CONTROL_MODE.MIDI_KEYBOARD;
import thepianogame.models.Piano;

public class PianoView extends JScrollPane {
    
    private CONTROL_MODE current_mode;
    
    public PianoView() {
        initComponents();
    }
    
    public PianoView(CONTROL_MODE current_mode) {
        this.current_mode = current_mode;
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        JLayeredPane layer = new JLayeredPane();
        layer.setSize(685, 92);
        int keyIndex = 0, i;
        int totalKeys, totalWhiteKeys;
        
        // Change the amount of keys in the piano visualization based on
        // if the MIDI keyboard is being used, or if the computer keyboard is
        if (current_mode == MIDI_KEYBOARD) {
            totalKeys = 53;
            totalWhiteKeys = 31;
        }
        else {
            totalKeys = 21;
            totalWhiteKeys = 11;
        }
        
        keys = new JPanel[totalKeys];

        if (current_mode == MIDI_KEYBOARD) {
            for(i=0;i<totalWhiteKeys;i++){
                keys[keyIndex] = createWhiteKey(i);
                layer.add(keys[keyIndex], 0, -1);
                keyIndex+=1;
                if(i%7!=2 && i%7!=6){
                    keys[keyIndex] = createBlackKey(i);
                    layer.add(keys[keyIndex], 1, -1);
                    keyIndex+=1;
                }
            }
        }
        else {
            for(i=0;i<totalWhiteKeys;i++) {
                keys[keyIndex] = createWhiteKey(i);
                layer.add(keys[keyIndex], 0, -1);
                keyIndex+=1;
                if(i%7!=3 && i%7!=6){
                    keys[keyIndex] = createBlackKey(i);
                    layer.add(keys[keyIndex], 1, -1);
                    keyIndex+=1;
                }
            }
        }
        
        this.setViewportView(layer);
        setSize(685, 92); 
        
    }
    
    // creates the piano's white keys
    private JPanel createWhiteKey(int i){
        JPanel whiteKey = new JPanel();
        whiteKey.setBorder(javax.swing.BorderFactory.createBevelBorder(
                javax.swing.border.BevelBorder.RAISED));
        whiteKey.setBackground(Color.WHITE);
        whiteKey.setLocation(i*22,0);
        whiteKey.setSize(22, 88);
        return whiteKey;
    }

    // creates the piano's black keys
    private JPanel createBlackKey(int i){
        JPanel blackKey = new JPanel();
        blackKey.setBackground(Color.BLACK);
        blackKey.setLocation(15 + i*22,0);
        blackKey.setSize(15, 64);
        return blackKey;
    }
    
    // takes in a set of key indexes mapping to the location of the keys on
    // the virtual keyboard and turns them green
    public void turnKeysGreen(int[] keyIndexes, JPanel[] keys){
        /*
            Highlights specific keys green. 
        
            The specific keys are the ones that have the indexes in the list
            keyIndexes.
        
            Used when the user correctly presses keys to get a chord object.
        */
        for(int i=0; i<keyIndexes.length; i++){
            keys[keyIndexes[i]].setBackground(Color.green);
        }
    }
    
    // takes in a set of key indexes mapping to the location of the keys on
    // the virtual keyboard and turns them red
    public void turnKeysRed(int[] keyIndexes, JPanel[] keys){
        /*
            Highlights specific keys red. 
        
            The specific keys are the ones that have the indexes in the list
            keyIndexes.
        
            Used when the user incorrectly presses keys to get a chord object.
        */
        for(int i=0; i<keyIndexes.length; i++){
            keys[keyIndexes[i]].setBackground(Color.red);
        }
    } 
    
    public void turnKeysDifferentColor(int[] keyIndexes, JPanel[] keys, 
            Color color) {
        /*
            Highlights specific keys the provided color. 
        
            The specific keys are the ones that have the indexes in the list
            keyIndexes.
        
            Used when the user either correctly or incorrectly presses keys 
            to get a chord object.
        */
        for(int i=0; i<keyIndexes.length; i++){
            keys[keyIndexes[i]].setBackground(color);
        }
    }
    
    public void turnKeyDifferentColor(int keyIndex, JPanel[] keys, 
            Color color ) {
        /*
            Turns a single key, denoted by the provided index, a 
            different color.
        
            Used when the user presses any key on the midi or computer
            keyboard controllers. Provides feedback to the user about
            keyboard inputs.
        */
        keys[keyIndex].setBackground(color);
    }
    
    private Piano model;
    public JPanel[] keys;
    public int[] leftC = {12, 16, 19};
    public int[] leftCInverted = {16, 19, 24};
    
    
    
}
