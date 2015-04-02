/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import thepianogame.models.Road;

public class RoadView extends JPanel {
    
    public RoadView() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        JPanel road = new javax.swing.JPanel();
        this.setLayout(new BorderLayout());
        this.add(road, BorderLayout.CENTER);
        
        road.setBackground(new java.awt.Color(0, 0, 0));
    }
    
    private Road model;
}
