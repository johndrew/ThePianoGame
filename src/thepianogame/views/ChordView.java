/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

/**
 *
 * @author marinastoebner
 */
public class ChordView extends JPanel{
    
    ChordView(){
        initComponents();
    }
    
    public void initComponents(){
        String[] cMajor = {"C", "Dm", "Em", "F", "G", "Am", "Bdim"};
        String[] cMinor = {"Cm", "Ddim", "D#", "Fm", "Gm", "G#"};
        String[] gMajor = {"G", "Am", "Bm", "C", "D", "Em", "F#dim"};
        String[] gMinor = {"Gm", "Adim", "A#", "Cm", "Dm", "D#", "F"};
        String[] dMajor = {"D", "Em", "F#m", "G", "A", "Bm", "C#dim"};
        String[] dMinor = {"Dm", "Edim", "F", "Gm", "Am", "A#", "C"};
        String[] aMajor = {"A", "Bm", "C#m", "D", "E", "F#m", "G#dim"};
        String[] aMinor = {"Am", "Bdim", "C", "Dm", "Em", "F", "G", "Am"};
        String[] eMajor = {"E", "F#m", "G#m", "A", "B", "C#m", "D#dim"};
        String[] eMinor = {"Em", "F#dim", "G#", "Am", "Bm", "C", "D"};
        String[] bMajor = {"B", "C#m", "D#m", "E", "F#", "G#m", "A#dim"};
        String[] bMinor = {"Bm", "C#dim", "D", "Em", "F#m", "G", "A"};
        
        String[] chordNames = {"C", "Cm", "C#", "C#dim", "D", "Dm", "D#", "Ddim", 
        "D#dim", "E", "Em", "Edim", "F", "Fm", "F#", "F#dim", "G", "Gm", "G#", 
        "G#dim", "A", "Am", "A#", "Adim", "A#dim", "B", "Bm", "Bdim"};

        chords = new HashMap();
        for(int i = 0; i < chordNames.length; i++){
            BufferedImage img = null;
            try {
                String path = "/thepianogame/resources/"+chordNames[i];
                img = ImageIO.read(getClass().getResourceAsStream(path));
            } catch (IOException ex) {
                Logger.getLogger(ChordView.class.getName()).log(Level.SEVERE, null, ex);
            }
            JLabel icon = new JLabel(new ImageIcon(img));
            chords.put(chordNames[i], icon);
        }
    }

    
    
    private Map<String, JLabel> chords;
}
