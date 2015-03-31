/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import thepianogame.views.GameScreenView;
import thepianogame.views.TitleScreenView;

/**
 *
 * @author taylorstheking4
 */
public class MainController extends JFrame implements ActionListener, 
        KeyListener {
    
    public MainController() {
        initUI();
        
        addKeyListener(this);
    }
    
    /*
        Setup the GUI and ActionListeners
    */
    public void initUI() {
        /*
            Initializes the various views
        */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        titleScreen = new TitleScreenView(this);
        gameScreen = new GameScreenView(this);
        
        // start the game on the title screen
        this.add(titleScreen);
        
        titleScreen.setVisible(true);
        gameScreen.setVisible(false);
        
        
    }
    
    public void startGame() {
        /*
            Switches to the game screen.
            Hides the title screen, but does not remove it
        */
        this.add(gameScreen);
        
        titleScreen.setVisible(false);
        gameScreen.setVisible(true);
    }

    /*
        Used for responding to menu clicks
    */
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action Performed");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Key Typed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        int keyCode = e.getKeyCode();
//        
//        System.out.println("Key pressed");
//        
//        switch (keyCode) {
//                case KeyEvent.VK_SPACE:
//                    System.out.println("Space bar pressed");
//                    break;
//                default:
//                    System.out.println("Other");
//                    break;
//        }
        System.out.println("Key Pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key Released");
    }
    
    /*
        Private variables. DO NOT MODIFY.
    */
    private TitleScreenView titleScreen;
    private GameScreenView gameScreen;
}
