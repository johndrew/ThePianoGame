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
    
    public ChordObjectView(String name, boolean isOnRightSide) {
        setPreferredSize(new Dimension(100, 100));
        setBackground(Color.white);
        this.isOnRightSide = isOnRightSide;
        this.name = name;
        
        initComponents();
    }
    
    // This method breaks our MVC framework
    public final void initComponents() {
//        String n = formatName(name);
        JLabel chordLabel = new JLabel(name);
//        JLabel chordLabel = new JLabel("F");  //change this
        chordLabel.setFont(new Font(chordLabel.getFont().getName(), 
                Font.PLAIN, 15));
        
        add(chordLabel);
    }
    
//    public String formatName(String name) {
//        String result = "";
//        
//        if (name.contains("#")) {
//            
//        }
//        
//        if (name.contains("diminished")) {
//            return name.getChars(0, WIDTH, dst, ALLBITS);
//        } else {
//            return name;
//        }
//    }
    
    public void setObjectBounds(Dimension roadSize) {
        int leftX = (roadSize.width/2) - 150;
        int leftY = -100;
        int rightX = (roadSize.width/2) + 100;
        int rightY = 0;
        
        if (isOnRightSide) {
            setBounds(rightX, rightY, 200, 200);
        } else {
            setBounds(leftX, leftY, 100, 100);
        }
    }
    
    public void moveChordView(int amountToMove) {
        setBounds(getX(), getY() + amountToMove, getWidth(), getHeight());
    }
    
    public void setModel(ChordObject chord) {
        model = chord;
    }
    
//    @Override
//    public final void paintComponent(Graphics g) {
//        super.paintComponent(g);
//    }
    
    private boolean isOnRightSide;
    private String name;
    private ChordObject model;
}
