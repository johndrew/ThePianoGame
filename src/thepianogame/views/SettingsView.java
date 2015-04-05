/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author marinastoebner
 */
public class SettingsView extends JPanel {
    
    private JComboBox tempos;
    
    public SettingsView() {
        initComponents();
    }
    
    public void initComponents(){
        JPanel levelPanel = new JPanel();
        levelPanel.setLayout(new BorderLayout());
        Dimension panelSize = new Dimension(190, 60);
        levelPanel.setPreferredSize(panelSize);
        
        JPanel tempoPanel = new JPanel();
        tempoPanel.setLayout(new BorderLayout());
        tempoPanel.setPreferredSize(panelSize);
        
        JPanel keyPanel = new JPanel();
        keyPanel.setLayout(new BorderLayout());
        keyPanel.setPreferredSize(panelSize);
        
        JLabel levelLabel = new javax.swing.JLabel();
        JComboBox levels = new javax.swing.JComboBox();
        JLabel tempoLabel = new javax.swing.JLabel();
        tempos = new javax.swing.JComboBox();
        JLabel keyLabel = new javax.swing.JLabel();
        JComboBox keys = new javax.swing.JComboBox();
        JComboBox majorOrMinor = new javax.swing.JComboBox();
        
        this.setLayout(new BorderLayout());
        
        levelLabel.setText("LEVEL:");

        levels.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Beginner", "Intermediate", "Expert" }));

        tempoLabel.setText("TEMPO:");

        tempos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "80", "100", "120", "140", "160", "180", "200", "220" }));

        keyLabel.setText("KEY:");

        keys.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "C", "C#/Db", "D", "D#/Eb", "E", "F", "F#/Gb", "G", "G#/Ab", "A", "A#/Bb", "B" }));

        majorOrMinor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Major", "Minor" }));
        
        levelPanel.add(levelLabel, BorderLayout.NORTH);
        levelPanel.add(levels);
        
        tempoPanel.add(tempoLabel, BorderLayout.NORTH);
        tempoPanel.add(tempos);
        
        keyPanel.add(keyLabel, BorderLayout.NORTH);
        keyPanel.add(keys, BorderLayout.WEST);
        keyPanel.add(majorOrMinor, BorderLayout.EAST);
        
        this.add(levelPanel, BorderLayout.NORTH);
        this.add(tempoPanel, BorderLayout.CENTER);
        this.add(keyPanel, BorderLayout.SOUTH);
    }   
    
    public int getTempo() {
        return Integer.parseInt((String) tempos.getSelectedItem());
    }
    
}
