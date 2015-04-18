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
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import thepianogame.models.ChordObject;

public class ChordObjectView extends JPanel {

    public String id;
    private double position;

    public ChordObjectView(String name, boolean isOnRightSide, String id) {
        setPreferredSize(new Dimension(100, 100));
        setBackground(Color.white);
        this.isOnRightSide = isOnRightSide;
        this.name = name;
        this.id = id;
        this.position = 0;

        initComponents();
    }

    public final void initComponents() {
        String n = formatName(name);
        JLabel chordLabel = new JLabel(n);
        chordLabel.setFont(new Font(chordLabel.getFont().getName(),
                Font.PLAIN, 32));

        add(chordLabel);
    }

    public String formatName(String name) {
        String result = "";

        if (name.contains("#")) {
            result = name.substring(0, 2);
        } else {
            result = name.substring(0, 1);
        }

        if (name.contains("diminished")) {
            result = result + "dim";
        } else if (name.contains("major")) {
            return result;
        } else if (name.contains("minor")) {
            result = result + "m";
        } else {
            return name;
        }
        /* these don't work like they should!
         result += '\n';
         result += model.chord.listOfNotes;
         */

        return result;
    }

    public void setObjectBounds(Dimension roadSize) {
        int leftX = (roadSize.width / 2) - 150;
        int leftY = -100;
        int rightX = (roadSize.width / 2) + 100;
        int rightY = -100;

        if (isOnRightSide) {
            setBounds(rightX, rightY, 100, 100);
        } else {
            setBounds(leftX, leftY, 100, 100);
        }
    }

    public void moveChordView(double positionIncrement, int roadheight) {
        position += positionIncrement;
        setBounds(getX(), (int) (-100 + (position * (100 + (roadheight / 2)))), getWidth(), getHeight());
    }

    public void setModel(ChordObject chord) {
        model = chord;
    }

    public void hideChordView() {
        setVisible(false);
    }

    public String getName() {
        return this.name;
    }

    // used when a chord can't be gotten
    public void changeBackgroundColor() {
        setBackground(Color.red);
    }

//    @Override
//    public final void paintComponent(Graphics g) {
//        super.paintComponent(g);
//    }
    private boolean isOnRightSide;
    private String name;
    private ChordObject model;
}
