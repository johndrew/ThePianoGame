/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame;

import java.awt.Dimension;
import javax.swing.JFrame;
import thepianogame.models.Game;
import thepianogame.views.StartScreen;

/**
 *
 * @author taylorstheking4
 */
public class ThePianoGame extends JFrame {
    
    public ThePianoGame() {
        initComponents();
    }

    public void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        StartScreen startScreen = new StartScreen();
        this.add(startScreen);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThePianoGame app = new ThePianoGame();
                app.setPreferredSize(new Dimension(800, 700));
                app.pack();
                app.setVisible(true);
            }
        });
    }
    
}
