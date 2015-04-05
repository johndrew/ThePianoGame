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
import java.util.ArrayList;
import javax.swing.JFrame;
import static thepianogame.controller.MainController.CONTROL_MODE.COMPUTER_KEYBOARD;
import static thepianogame.controller.MainController.CONTROL_MODE.MIDI_KEYBOARD;
import thepianogame.models.Game;
import thepianogame.views.GameScreenView;
import thepianogame.views.PianoView;
import thepianogame.views.TitleScreenView;

public final class MainController extends JFrame implements ActionListener, 
        KeyListener {
    
    public enum CONTROL_MODE {MIDI_KEYBOARD, COMPUTER_KEYBOARD};
    private final CONTROL_MODE current_mode;
    
    public MainController() {
        initUI();
        
        addKeyListener(this);
        setFocusable(true);
        
        // Sets the game control mode
        current_mode = isMIDIKeyboardConnected() ? MIDI_KEYBOARD : COMPUTER_KEYBOARD;
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
    
    public boolean isMIDIKeyboardConnected() {
        /*
            Will check if a MIDI keyboard is connected to the computer
            by USB. If yes, then true is returned.
        */
        return false;
    }
    
    public CONTROL_MODE getCurrentMode() {
        /*
            Returns the current_mode. Mode is defined by the CONTROL_MODE enum
        */
        return current_mode;
    }
    
    public void startGame() {
        /*
            Switches to the game screen.
            Hides the title screen, but does not remove it
        */
        this.add(gameScreen);
        
        titleScreen.setVisible(false);
        gameScreen.setVisible(true);
        Game g = new Game();
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
//        System.out.println("Action Performed");
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        System.out.println("Key Typed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        /*
            Assigns computer keys to certain actions
        */
        int keyCode = e.getKeyCode();
        
        if (current_mode == COMPUTER_KEYBOARD) {
            
            /*
                Assigns actions for the computer keyboard.
            
                The computer keyboard consists of a single octave (12 keys of F
                through E, plus 7 extra keys that represent F through B 
                on the piano.
            
                Here is a visual representation of the layout:
                
                        W E R   Y U   O P [
                       A S D F G H J K L ; '
            
                The last three are a semi-colon, a square open bracket, and
                an apostrophe in case there is any confusion.
            */
        
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
                        System.out.println("A key pressed.");
                        gameScreen.computerKeyPressed(KeyEvent.VK_A);
                        break;
                    case KeyEvent.VK_W:
                        // F#3 or Gb3
                        System.out.println("W key pressed.");
                        gameScreen.computerKeyPressed(KeyEvent.VK_W);
                        break;
                    case KeyEvent.VK_S:
                        // G3
                        System.out.println("S key pressed.");
                        gameScreen.computerKeyPressed(KeyEvent.VK_S);
                        break;
                    case KeyEvent.VK_E:
                        // G#3 or Ab3
                        System.out.println("E key pressed.");
                        gameScreen.computerKeyPressed(KeyEvent.VK_E);
                        break;
                    case KeyEvent.VK_D:
                        // A3
                        System.out.println("D key pressed.");
                        gameScreen.computerKeyPressed(KeyEvent.VK_D);
                        break;
                    case KeyEvent.VK_R:
                        // A#3 or Bb3
                        System.out.println("R key pressed.");
                        gameScreen.computerKeyPressed(KeyEvent.VK_R);
                        break;
                    case KeyEvent.VK_F:
                        // B3
                        System.out.println("F key pressed.");
                        gameScreen.computerKeyPressed(KeyEvent.VK_F);
                        break;
                    case KeyEvent.VK_G:
                        // Middle C or C4
                        System.out.println("G key pressed.");
                        gameScreen.computerKeyPressed(KeyEvent.VK_G);
                        break;
                    case KeyEvent.VK_Y:
                        // C#4 or Db4
                        System.out.println("Y key pressed.");
                        gameScreen.computerKeyPressed(KeyEvent.VK_Y);
                        break;
                    case KeyEvent.VK_H:
                        // D4
                        System.out.println("H key pressed.");
                        gameScreen.computerKeyPressed(KeyEvent.VK_H);
                        break;
                    case KeyEvent.VK_U:
                        // D#4 or Eb4
                        System.out.println("U key pressed.");
                        gameScreen.computerKeyPressed(KeyEvent.VK_U);
                        break;
                    case KeyEvent.VK_J:
                        // E4
                        System.out.println("J key pressed.");
                        gameScreen.computerKeyPressed(KeyEvent.VK_J);
                        break;
                    case KeyEvent.VK_K:
                        // F4
                        System.out.println("K key pressed.");
                        gameScreen.computerKeyPressed(KeyEvent.VK_K);
                        break;
                    case KeyEvent.VK_O:
                        // F#4 or Gb4
                        System.out.println("O key pressed.");
                        gameScreen.computerKeyPressed(KeyEvent.VK_O);
                        break;
                    case KeyEvent.VK_L:
                        // G4
                        System.out.println("L key pressed.");
                        gameScreen.computerKeyPressed(KeyEvent.VK_L);
                        break;
                    case KeyEvent.VK_P:
                        // G#4 or Ab4
                        System.out.println("P key pressed.");
                        gameScreen.computerKeyPressed(KeyEvent.VK_P);
                        break;
                    case KeyEvent.VK_SEMICOLON:
                        // A4
                        System.out.println("; key pressed.");
                        gameScreen.computerKeyPressed(KeyEvent.VK_SEMICOLON);
                        break;
                    case KeyEvent.VK_OPEN_BRACKET:
                        // A#4 or Bb4
                        System.out.println("[ key pressed.");
                        gameScreen.computerKeyPressed(KeyEvent.VK_OPEN_BRACKET);
                        break;
                    case KeyEvent.VK_QUOTE:
                        // B4
                        System.out.println("' key pressed.");
                        gameScreen.computerKeyPressed(KeyEvent.VK_QUOTE);
                        break;
                    default:
                        System.out.println("Other key");
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
