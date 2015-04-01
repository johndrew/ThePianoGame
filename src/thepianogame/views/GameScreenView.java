/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import thepianogame.controller.MainController;
import thepianogame.models.Road;

public class GameScreenView extends JPanel {
    
    private MainController controller;
    
    public GameScreenView(MainController controller) {
        this.controller = controller;
        
        makeGameWindow();
        makePianoVisualization();
        makePauseDialog();
        
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
        road = new Road();
        gameWindow.add(b1, BorderLayout.WEST);
        gameWindow.add(b2, BorderLayout.EAST);
        gameWindow.add(road, BorderLayout.CENTER);
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
    
    public final void makePauseDialog() {
        pauseMenu = new JPanel();
        JLabel title = new JLabel("Paused Game");
        JButton resume = new JButton("Resume");
        JButton restart = new JButton("Restart");
        JButton endGame = new JButton("End Game");
        JPanel buttons = new JPanel();
        
        pauseMenu.setLayout(new BorderLayout());
        pauseMenu.add(title, BorderLayout.NORTH);
        buttons.setLayout(new BoxLayout(buttons, javax.swing.BoxLayout.PAGE_AXIS));
        buttons.add(resume);
        buttons.add(restart);
        buttons.add(endGame);
        pauseMenu.add(buttons, BorderLayout.CENTER);
        
        pauseMenu.setPreferredSize(new Dimension(400, 400));
        pauseMenu.setLocation(new Point(200, 200));
        pauseMenu.setVisible(false);
    }
    
    public boolean isPauseDialogVisible() {
        return pauseMenu.isVisible();
    }
    
    public void showPauseDialog() {
        gameWindow.add(pauseMenu, BorderLayout.CENTER);
        road.setVisible(false);
        pauseMenu.setVisible(true);
    }
    
    public void hidePauseDialog() {
        gameWindow.add(road, BorderLayout.CENTER);
        pauseMenu.setVisible(false);
        road.setVisible(true);
    }
    
    private JPanel gameWindow;
    private JPanel pianoVisualization;
    private JPanel pauseMenu;
    private Road road;
}
