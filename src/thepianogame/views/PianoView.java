/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.OverlayLayout;
import thepianogame.models.Piano;

public class PianoView extends JScrollPane {
 
    public PianoView() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        JLayeredPane layer = new JLayeredPane();
        layer.setSize(685, 92);
        keys = new JPanel[53];
        int keyIndex = 0, i;

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
        for(int i=0; i<keyIndexes.length; i++){
            keys[keyIndexes[i]].setBackground(Color.green);
        }
    }
    
    // takes in a set of key indexes mapping to the location of the keys on
    // the virtual keyboard and turns them red
    public void turnKeysRed(int[] keyIndexes, JPanel[] keys){
        for(int i=0; i<keyIndexes.length; i++){
            keys[keyIndexes[i]].setBackground(Color.red);
        }
    }
    
    private Piano model;
    public JPanel[] keys;
    public int[] leftC = {12, 16, 19};
    public int[] leftCInverted = {16, 19, 24};
    
    
    
}
