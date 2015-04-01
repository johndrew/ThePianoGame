/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.views;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import thepianogame.models.Road;

public class RoadView extends JPanel {
    
    public RoadView() {
        model = new Road();
        
        // TODO: Change these
        setLayout(new BorderLayout());
        add(new JLabel("Road"), BorderLayout.CENTER);
    }
    
    private Road model;
}
