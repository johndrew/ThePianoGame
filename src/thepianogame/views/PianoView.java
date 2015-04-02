/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.views;

import java.awt.BorderLayout;
import java.awt.Color;
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
        JPanel[] keys = new JPanel[53];
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
    
    private JPanel createWhiteKey(int i){
        JPanel whiteKey = new JPanel();
        whiteKey.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        whiteKey.setBackground(Color.WHITE);
        whiteKey.setLocation(i*22,0);
        whiteKey.setSize(22, 88);
        return whiteKey;
    }

    private JPanel createBlackKey(int i){
        JPanel blackKey = new JPanel();
        blackKey.setBackground(Color.BLACK);
        blackKey.setLocation(15 + i*22,0);
        blackKey.setSize(15, 66);
        return blackKey;
    }
    
    private Piano model;
}
