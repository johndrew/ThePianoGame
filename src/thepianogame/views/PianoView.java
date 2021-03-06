/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
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
            
            labelWhiteKeys();
            labelBlackKeys();
            deactivateKeys();
        }
     
        setViewportView(layer);
        setSize(685, 92);
    }
    
    // creates the piano's white keys
    private JPanel createWhiteKey(int i){
        JPanel whiteKey = new PianoKeyView(WHITE_KEY);
        whiteKey.setLayout(new BorderLayout());
        whiteKey.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
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
    private void labelWhiteKeys(){
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
    private void labelBlackKeys() {
        int[] blackKeyIndexes = {1, 3, 5, 8, 10, 13, 15, 17};
        String[] blackComputerKeys = {"W", "E", "R", "Y", "U", "O", "P", "["};
        
        for(int i = 0; i < blackKeyIndexes.length; i++){
            JLabel label = new JLabel(blackComputerKeys[i]);
            label.setForeground(Color.white);
            label.setHorizontalAlignment(JLabel.CENTER);
            keys[blackKeyIndexes[i] + 17].add(label, BorderLayout.SOUTH);
        }
    }
    
    // turns inactive keys grey
    private void deactivateKeys() {
        for(int i = 0; i < keys.length; i++){
            if(i<17 || i>35){
                if(keys[i].getBackground() == Color.BLACK) {
                    keys[i].setBackground(Color.darkGray);
                }
                else{
                    keys[i].setBackground(Color.lightGray);
                    keys[i].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                }
            }
        }
    }
    
    public void turnKeyGreen(int keyEventCode) {
        final Integer keyIndex = computerKeyEventMap.get(keyEventCode);
        turnKeyDifferentColor(keyIndex, Color.green);
        changeKeyLabelColor(keyIndex, Color.black);
    }
    
    public void turnKeyDifferentColor(int keyIndex, Color color ) {
        /*
            Turns a single key, denoted by the provided index, a 
            different color.
        
            Used when the user presses any key on the midi or computer
            keyboard controllers. Provides feedback to the user about
            keyboard inputs.
        */
        keys[keyIndex].setBackground(color);
    }
    
    public void turnKeyBackToOriginalColor(int keyEventCode) {
        final Integer keyIndex = computerKeyEventMap.get(keyEventCode);
        PianoKeyView key = (PianoKeyView)keys[keyIndex];
        PIANOKEY_TYPE originalColor = key.getType();
        
        if (originalColor == WHITE_KEY) {
            turnKeyDifferentColor(keyIndex, Color.white);
        }
        else {
            turnKeyDifferentColor(keyIndex, Color.black);
            // when black keys are turned green, the label color turns black
            // this action reverts the label text color
            changeKeyLabelColor(keyIndex, Color.white);
        }
    }
    
    public void turnAllKeysBackToOriginalColor() {
        ArrayList<Integer> events = makeComputerKeyEventsList();
        
        for (int i=0;i<events.size();i++) {
            turnKeyBackToOriginalColor(events.get(i));
        }
    }
    
    public void changeKeyLabelColor(int keyIndex, Color color) {
        JPanel key = keys[keyIndex];
        BorderLayout layout = (BorderLayout)key.getLayout();
        JLabel keyLabel = (JLabel)layout.getLayoutComponent(BorderLayout.SOUTH);
        Font oldFont = keyLabel.getFont();
        
        keyLabel.setForeground(color);
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
        
        turnKeyDifferentColor(keyIndex, Color.blue);
    }
    
    public void computerKeyReleased(int keyEventCode) {
        turnKeyBackToOriginalColor(keyEventCode);
    }
    
    public JPanel[] getKeys() {
        return keys;
    }
    
    public JPanel[] keys;
    
    private Piano model;
    private CONTROL_MODE current_mode;
    // Maps computer keyboard keys to their corresponding piano keys on the
    // visualization.
    private HashMap<Integer,Integer> computerKeyEventMap;
}
