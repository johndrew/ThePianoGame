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
import static thepianogame.controller.MainController.control_mode.COMPUTER_KEYBOARD;
import static thepianogame.controller.MainController.control_mode.MIDI_KEYBOARD;
import thepianogame.views.GameScreenView;
import thepianogame.views.TitleScreenView;

public class MainController extends JFrame implements ActionListener, 
        KeyListener {
    
    public enum control_mode {MIDI_KEYBOARD, COMPUTER_KEYBOARD};
    private control_mode current_mode;
    
    public MainController() {
        initUI();
        
        addKeyListener(this);
        setFocusable(true);
        
        // For our prototype, we are only implementing computer keyboard control
        // So, here we set the default mode to COMPUTER_KEYBOARD
        current_mode = COMPUTER_KEYBOARD;
    }
    
    /*
        Setup the GUI and ActionListeners
    */
    public final void initUI() {
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
    
    public void backToMenu() {
        /*
            Shows the TitleScreenView and hides the GameScreenView
        */
        gameScreen.setVisible(false);
        titleScreen.setVisible(true);
    }
    
    public void closeProgram() {
        System.exit(0);
    }
    
    /*
        Used for responding to menu clicks
    */
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action Performed");
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        System.out.println("Key Typed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        
        if (current_mode == COMPUTER_KEYBOARD) {
        
            switch (keyCode) {
                    case KeyEvent.VK_SPACE:
                        System.out.println("Space bar pressed.");
                        if (gameScreen.isVisible() && 
                                !gameScreen.isPauseMenuVisible()) {
                            gameScreen.showPauseMenu();
                        }
                        else if (gameScreen.isVisible() &&
                                gameScreen.isPauseMenuVisible()) {
                            gameScreen.hidePauseMenu();
                        }
                        break;   
                    case KeyEvent.VK_A:
                        // F3
                        System.out.println("A");
                        break;
                    case KeyEvent.VK_W:
                        // F#3 or Gb3
                        System.out.println("W");
                        break;
                    case KeyEvent.VK_S:
                        // G3
                        System.out.println("S");
                        break;
                    case KeyEvent.VK_E:
                        // G#3 or Ab3
                        System.out.println("E");
                        break;
                    case KeyEvent.VK_D:
                        // A3
                        System.out.println("D");
                        break;
                    case KeyEvent.VK_R:
                        // A#3 or Bb3
                        System.out.println("R");
                        break;
                    case KeyEvent.VK_F:
                        // B3
                        System.out.println("F");
                        break;
                    case KeyEvent.VK_G:
                        // Middle C or C4
                        System.out.println("G key pressed.");
                        break;
                    case KeyEvent.VK_Y:
                        // C#4 or Db4
                        System.out.println("Y");
                        break;
                    case KeyEvent.VK_H:
                        // D4
                        System.out.println("H");
                        break;
                    case KeyEvent.VK_U:
                        // D#4 or Eb4
                        System.out.println("U");
                        break;
                    case KeyEvent.VK_J:
                        // E4
                        System.out.println("J");
                        break;
                    case KeyEvent.VK_K:
                        // F4
                        System.out.println("K");
                        break;
                    case KeyEvent.VK_O:
                        // F#4 or Gb4
                        System.out.println("O");
                        break;
                    case KeyEvent.VK_L:
                        // G4
                        System.out.println("L");
                        break;
                    case KeyEvent.VK_P:
                        // G#4 or Ab4
                        System.out.println("P");
                        break;
                    case KeyEvent.VK_SEMICOLON:
                        // A4
                        System.out.println(";");
                        break;
                    case KeyEvent.VK_OPEN_BRACKET:
                        // A#4 or Bb4
                        System.out.println("[");
                        break;
                    case KeyEvent.VK_QUOTE:
                        // B4
                        System.out.println("'");
                        break;
                    default:
                        System.out.println("Other");
                        break;
            }
        }
        
        else if (current_mode == MIDI_KEYBOARD) {
            switch (keyCode) {
                    case KeyEvent.VK_SPACE:
                        System.out.println("Space bar pressed.");
                        if (gameScreen.isVisible() && 
                                !gameScreen.isPauseMenuVisible()) {
                            gameScreen.showPauseMenu();
                        }
                        else if (gameScreen.isVisible() &&
                                gameScreen.isPauseMenuVisible()) {
                            gameScreen.hidePauseMenu();
                        }
                        break; 
                    default:
                        System.out.println("Other");
                        break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        System.out.println("Key Released");
    }
    
    /*
        Private variables. DO NOT MODIFY.
    */
    private TitleScreenView titleScreen;
    private GameScreenView gameScreen;
}
