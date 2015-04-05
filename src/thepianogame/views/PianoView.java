/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import thepianogame.controller.MainController.CONTROL_MODE;
import static thepianogame.controller.MainController.CONTROL_MODE.MIDI_KEYBOARD;
import thepianogame.models.Piano;
import thepianogame.views.PianoKeyView.PIANOKEY_TYPE;
import static thepianogame.views.PianoKeyView.PIANOKEY_TYPE.BLACK_KEY;
import static thepianogame.views.PianoKeyView.PIANOKEY_TYPE.WHITE_KEY;

public class PianoView extends JScrollPane {
    
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
        keys = new JPanel[53];

        if (current_mode == MIDI_KEYBOARD) {
            for(i=0;i<31;i++){
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
            ArrayList<Integer> keyEvents = makeComputerKeyEventsList();
            computerKeyEventMap = new HashMap<Integer,Integer>();
            
            for(i=0;i<31;i++) {
                keys[keyIndex] = createWhiteKey(i);
                layer.add(keys[keyIndex], 0, -1);
                if(keyIndex > 16 && keyIndex < 36){
                    computerKeyEventMap.put(keyEvents.get(keyIndex-17), keyIndex);
                }
                keyIndex+=1;
                
                // computer keyboard needs to start on an F and end on a B
                if(i%7!=2 && i%7!=6){
                    keys[keyIndex] = createBlackKey(i);
                    layer.add(keys[keyIndex], 1, -1);
                    if(keyIndex > 16 && keyIndex < 36){
                        computerKeyEventMap.put(keyEvents.get(keyIndex-17), keyIndex);
                    }
                    keyIndex+=1;
                }
                
            }
            
            labelWhiteKeys(keys);
            labelBlackKeys(keys);
        }
     
        this.setViewportView(layer);
        setSize(685, 92); 
        
    }
    
    // creates the piano's white keys
    private JPanel createWhiteKey(int i){
        JPanel whiteKey = new PianoKeyView(WHITE_KEY);
        whiteKey.setLayout(new BorderLayout());
        whiteKey.setBorder(javax.swing.BorderFactory.createBevelBorder(
                javax.swing.border.BevelBorder.RAISED));
        whiteKey.setBackground(Color.WHITE);
        whiteKey.setLocation(i*22,0);
        whiteKey.setSize(22, 88);
        return whiteKey;
    }

    // creates the piano's black keys
    private JPanel createBlackKey(int i){
        JPanel blackKey = new PianoKeyView(BLACK_KEY);
        blackKey.setLayout(new BorderLayout());
        blackKey.setBackground(Color.BLACK);
        blackKey.setLocation(15 + i*22,0);
        blackKey.setSize(15, 64);
        return blackKey;
    }
    
    // if the game is in computer mode, it labels the white keys with the 
    // associating letters on the keyboard
    private void labelWhiteKeys(JPanel[] keys){
        int[] whiteKeyIndexes = {0, 2, 4, 6, 7, 9, 11, 12, 14, 16, 18};
        String[] whiteComputerKeys = {"A", "S", "D", "F", "G","H", "J", "K", "L", 
            ";", "'"};
       
        
        for(int i = 0; i < whiteKeyIndexes.length; i++){
            JLabel label = new JLabel(whiteComputerKeys[i]);
            label.setHorizontalAlignment(JLabel.CENTER);
            keys[whiteKeyIndexes[i] + 17].add(label, BorderLayout.SOUTH);
        }
               
    }
    
    // if the game is in computer mode, it labels the black keys with the 
    // associating letters on the keyboard
    private void labelBlackKeys(JPanel[] keys) {
        int[] blackKeyIndexes = {1, 3, 5, 8, 10, 13, 15, 17};
        String[] blackComputerKeys = {"W", "E", "R", "Y", "U", "O", "P", "["};
        
        for(int i = 0; i < blackKeyIndexes.length; i++){
            JLabel label = new JLabel(blackComputerKeys[i]);
            label.setForeground(Color.white);
            label.setHorizontalAlignment(JLabel.CENTER);
            keys[blackKeyIndexes[i] + 17].add(label, BorderLayout.SOUTH);
        }
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

    public ArrayList<Integer> makeComputerKeyEventsList() {
        /*
            Creates a list of the keyEvents for the computer that will be used
            to control the game in COMPUTER_KEYBOARD mode.
        */
        ArrayList<Integer> events = new ArrayList<Integer>();
        
        events.add(KeyEvent.VK_A); // F
        events.add(KeyEvent.VK_W); // F#
        events.add(KeyEvent.VK_S); // G
        events.add(KeyEvent.VK_E); // G#
        events.add(KeyEvent.VK_D); // A
        events.add(KeyEvent.VK_R); // A#
        events.add(KeyEvent.VK_F); // B
        events.add(KeyEvent.VK_G); // Middle C
        events.add(KeyEvent.VK_Y); // C#
        events.add(KeyEvent.VK_H); // D
        events.add(KeyEvent.VK_U); // D#
        events.add(KeyEvent.VK_J); // E
        events.add(KeyEvent.VK_K); // F
        events.add(KeyEvent.VK_O); // F#
        events.add(KeyEvent.VK_L); // G
        events.add(KeyEvent.VK_P); // G#
        events.add(KeyEvent.VK_SEMICOLON); // A
        events.add(KeyEvent.VK_OPEN_BRACKET); // A#
        events.add(KeyEvent.VK_QUOTE); // B
        
        return events;
    }
    
    public void computerKeyPressed(int keyEventCode) {
        final Integer keyIndex = computerKeyEventMap.get(keyEventCode);
        
        turnKeyDifferentColor(keyIndex, keys, Color.blue);
    }
    
    public void computerKeyReleased(int keyEventCode) {
        final Integer keyIndex = computerKeyEventMap.get(keyEventCode);
        PianoKeyView key = (PianoKeyView)keys[keyIndex];
        PIANOKEY_TYPE originalColor = key.getType();
        
        if (originalColor == WHITE_KEY) {
            turnKeyDifferentColor(keyIndex, keys, Color.white);
        }
        else {
            turnKeyDifferentColor(keyIndex, keys, Color.black);
        }
    }
    
    public JPanel[] keys;
    
    private Piano model;
    private CONTROL_MODE current_mode;
    // Maps computer keyboard keys to their corresponding piano keys on the
    // visualization.
    private HashMap<Integer,Integer> computerKeyEventMap;
}
