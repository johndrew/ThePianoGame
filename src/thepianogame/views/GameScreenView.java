/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import thepianogame.controller.MainController;

public class GameScreenView extends JPanel {
    
    private MainController controller;
    
    public GameScreenView(MainController controller) {
        this.controller = controller;
        
        makeGameWindow();
        makePianoVisualization();
        
        setLayout(new BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));
        
        add(gameWindow);
        add(Box.createRigidArea(new Dimension(0,5)));
        add(pianoVisualization);
    }
    
    public final void makeGameWindow() {
        /*
            Creates the window that will contain the road, car, chord objects,
            and options.
        */
        gameWindow = new JPanel();
        gameWindow.setLayout(new BorderLayout());
        
        // TODO: Change these to JPanels
        JButton b1 = new JButton("Left Options");
        JButton b2 = new JButton("Right Options");
        JButton b3 = new JButton("Road");
        gameWindow.add(b1, BorderLayout.WEST);
        gameWindow.add(b2, BorderLayout.EAST);
        gameWindow.add(b3, BorderLayout.CENTER);
    }
    
    public final void makePianoVisualization() {
        /*
            Creates the piano visualization
        */
        pianoVisualization = new JPanel();
        pianoVisualization.setLayout(new BorderLayout());
        
        //TODO: Change this to the piano visualization (i assume this
        //      this will be a JPanel)
        pianoVisualization.add(new JButton("Piano"), BorderLayout.CENTER);
    }
    
    private JPanel gameWindow;
    private JPanel pianoVisualization;
}
