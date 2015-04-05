/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import thepianogame.models.Road;

public class RoadView extends JPanel {
    
    public RoadView() {
        initComponents();
    }
    
    public RoadView(Dimension roadSize) {
        this.roadSize = roadSize;
        
        initComponents();
        setPreferredSize(roadSize);
        setMaximumSize(roadSize);
        setMinimumSize(roadSize);
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        setBackground(new java.awt.Color(0, 0, 0));
        
        makeDashedCenterDivider(this);
    }
    
    public void makeDashedCenterDivider(JPanel road) {
        /*
            Draws the dashes on the road.
        */
        int numberOfDashes = 8;
        int gapSize = 20;
//        int dashHeight = (road.getHeight() - (numberOfDashes+1 * gapSize)) 
//                / numberOfDashes;
        int dashHeight = 56 + (2/3);
        int dashWidth = 20;
        int dashX = (this.roadSize.width/2) - (dashWidth/2);
        int dashY = 0;
        Dash dash;
        
        // This JPanel will hold all of the dashes. This is needed to get
        // them in a vertical line
        JPanel dashContainer = new JPanel();
        dashContainer.setLayout(new BoxLayout(dashContainer, 
                BoxLayout.PAGE_AXIS));
        dashContainer.setBackground(new java.awt.Color(0, 0, 0));
        
        for (int i=0;i<numberOfDashes;i++) {
            dash = new Dash(dashWidth, dashHeight, dashX, dashY);
            dashY -= dashHeight + gapSize;
            
            dashContainer.add(dash);
            dashContainer.add(Box.createRigidArea(new Dimension(5, gapSize)));
//            dashes.add(dash);
        }
        
        road.add(dashContainer);
    }
    
    private class Dash extends JPanel {
        
        public Dash(int width, int height, int x, int y) {
            this.width = width;
            this.height = height;
            this.x = x;
            this.y = y;
            
            initComponents();
        }
        
        public void initComponents() {
            setBorder(javax.swing.BorderFactory.createBevelBorder(
                    javax.swing.border.BevelBorder.RAISED));
            setBackground(Color.YELLOW);
            setPreferredSize(new Dimension(width, height));
            setLocation(x, y);
        }
        
        public void moveDash(int x, int y) {
            setLocation(x, y);
        }
        
        private int width;
        private int height;
        private int x;
        private int y;
    }
    
    private Road model;
    private Dimension roadSize;
    private ArrayList<Dash> dashes;
}
