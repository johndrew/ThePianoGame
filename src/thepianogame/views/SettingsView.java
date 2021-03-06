/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import thepianogame.controller.MainController;

public class SettingsView extends JPanel {

    private JSlider tempos;
    private JComboBox keys;
    private JComboBox majorOrMinor;

    public SettingsView(MainController controller) {
        this.controller = controller;

        initComponents();
    }

    public final void initComponents() {
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
        tempos = new javax.swing.JSlider(JSlider.HORIZONTAL, 20, 180, 40);
        tempos.setEnabled(false);
        JLabel keyLabel = new javax.swing.JLabel();
        keys = new javax.swing.JComboBox();
        keys.setEnabled(false);
        majorOrMinor = new javax.swing.JComboBox();
        majorOrMinor.setEnabled(false);

        this.setLayout(new BorderLayout());

        levelLabel.setText("LEVEL:");

        // Add an intermediate and expert level after the prototype is turned in
        levels.setModel(new javax.swing.DefaultComboBoxModel(new String[]{
            "Beginner"}));
        levels.addPopupMenuListener(new PopupMenuListener() {

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                ctrl.requestFocus();
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
            }
        });

        tempoLabel.setText("TEMPO:");
        tempos.setMajorTickSpacing(40);
        tempos.setMinorTickSpacing(10);
        tempos.setPaintTicks(true);
        tempos.setPaintLabels(true);

        keyLabel.setText("KEY:");

        /*keys.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"C",
            "C#/Db", "D", "D#/Eb", "E", "F", "F#/Gb", "G", "G#/Ab", "A", "A#/Bb",
            "B"}));*/ // ADD THIS BACK IN ONCE WE HAVE FULL KEYBOARDS
        keys.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"F"}));
        keys.addPopupMenuListener(new PopupMenuListener() {

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                ctrl.requestFocus();
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
            }
        });

        majorOrMinor.setModel(new javax.swing.DefaultComboBoxModel(new String[]{
            "Major", "Minor"}));
        majorOrMinor.addPopupMenuListener(new PopupMenuListener() {

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                ctrl.requestFocus();
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
            }
        });
        
        tempos.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                ctrl.requestFocus();
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
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
        return tempos.getValue();
    }

    public String getKey() {
        return (String) keys.getSelectedItem();
    }
    

    public String getScale() {
        return (String) majorOrMinor.getSelectedItem();
    }
    
    public void activate() {
        tempos.setEnabled(true);
        keys.setEnabled(true);
        majorOrMinor.setEnabled(true);
    }
    
    public void deactivate() {
        tempos.setEnabled(false);
        keys.setEnabled(false);
        majorOrMinor.setEnabled(false);
    }

    private MainController controller;
}
