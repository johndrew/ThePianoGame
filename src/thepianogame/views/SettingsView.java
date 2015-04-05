/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import thepianogame.controller.MainController;

public class SettingsView extends JPanel {
    
    private JComboBox tempos;
    
    public SettingsView(MainController controller) {
        this.controller = controller;
        
        initComponents();
    }
    
    public final void initComponents(){
        JPanel levelPanel = new JPanel();
        levelPanel.setLayout(new BorderLayout());
        Dimension panelSize = new Dimension(190, 60);
        levelPanel.setPreferredSize(panelSize);
        final MainController ctrl = controller;
        
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
        final JComboBox keys = new javax.swing.JComboBox();
        JComboBox majorOrMinor = new javax.swing.JComboBox();
        
        this.setLayout(new BorderLayout());
        
        levelLabel.setText("LEVEL:");

        // Add an expert level after the prototype is turned in
        levels.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Beginner", "Intermediate" }));
        levels.addPopupMenuListener(new PopupMenuListener() {

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {}

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                ctrl.requestFocus();
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {}
        });
        
        tempoLabel.setText("TEMPO:");

        tempos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "80", "100", "120", "140", "160", "180", "200", "220" }));
        tempos.addPopupMenuListener(new PopupMenuListener() {

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {}

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                ctrl.requestFocus();
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {}
        });
        
        keyLabel.setText("KEY:");

        keys.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "C", "C#/Db", "D", "D#/Eb", "E", "F", "F#/Gb", "G", "G#/Ab", "A", "A#/Bb", "B" }));
        keys.addPopupMenuListener(new PopupMenuListener() {

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {}

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                ctrl.requestFocus();
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {}
        });
        
        
        majorOrMinor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Major", "Minor" }));
        majorOrMinor.addPopupMenuListener(new PopupMenuListener() {

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {}

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                ctrl.requestFocus();
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {}
        });
        
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
    
    private MainController controller;
}
