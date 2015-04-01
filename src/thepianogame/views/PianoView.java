/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.views;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import thepianogame.models.Piano;

public class PianoView extends JPanel {
 
    public PianoView() {
//        model = new Piano();
        
        // TODO: Change this
        setLayout(new BorderLayout());
        JButton b1 = new JButton("piano");
        add(b1, BorderLayout.CENTER);
        b1.setEnabled(false);
    }
    
    private Piano model;
}
