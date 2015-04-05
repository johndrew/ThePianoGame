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
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.Timer;
import static thepianogame.controller.MainController.CONTROL_MODE.COMPUTER_KEYBOARD;
import static thepianogame.controller.MainController.CONTROL_MODE.MIDI_KEYBOARD;
import thepianogame.models.Game;
import thepianogame.views.GameScreenView;
import thepianogame.views.TitleScreenView;

public final class MainController extends JFrame implements ActionListener,
        KeyListener {

    public enum CONTROL_MODE {

        MIDI_KEYBOARD, COMPUTER_KEYBOARD
    };
    private final CONTROL_MODE current_mode;
    private Timer timer;
    public Game g;
    private boolean shouldUpdateGame;
    private boolean moveCarLeft = false;
    private boolean moveCarRight = false;

    public MainController() {
        initUI();

        addKeyListener(this);
        setFocusable(true);

        // Sets the game control mode
//        current_mode = isMIDIKeyboardConnected() ? MIDI_KEYBOARD
//                : COMPUTER_KEYBOARD;
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
        
        carLeftBoundary = 63;
        carRightBoundary = 321;
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
        startNewGame();
    }
    
    public void startNewGame() {
        shouldUpdateGame = true;
        g = new Game();
        timer = new Timer((int) (1000 / 60), this);
        timer.start();
    }
    
    public void endGame() {
        /*
            Stops the timer and any other things involved in a Game instance
        */
        timer.stop();
    }
    
    public void newGame() {
        endGame();
        startNewGame();
    }

    public void backToMenu() {
        /*
            Shows the TitleScreenView and hides the GameScreenView
        
            Ends the current game.
         */
        gameScreen.setVisible(false);
        titleScreen.setVisible(true);
        endGame();
    }

    public void closeProgram() {
        System.exit(0);
    }

    /*
     Used for responding to menu clicks
     */
    public void actionPerformed(ActionEvent e) {
        if (shouldUpdateGame) {
            g.setTempo(gameScreen.getTempo() , 60);
            g.run();
        }
        
        if (!gameScreen.isPauseMenuVisible() 
                && !gameScreen.isEndGameMenuVisible()) {
            // adjust this number to control the movement speed of dashes on the
            // road. It should adjust based on the difficulty setting.
            gameScreen.moveDashes(4);
        }
        
        if (moveCarLeft) {
            int carX = gameScreen.getCarXCoordinate();
            if (carX != carLeftBoundary) {
                // if you change this number below, you must also change
                // the carLeftBoundary because the boundary needs to be
                // a multiple of the number below
                gameScreen.moveCarLeft(3);
            } else {
                moveCarLeft = false;
            }
        } else if (moveCarRight) {
            int carX = gameScreen.getCarXCoordinate();
            if (carX != carRightBoundary) {
                // if you change this number below, you must also change
                // the carRightBoundary because the boundary needs to be
                // a multiple of the number below
                gameScreen.moveCarRight(3);
            } else {
                moveCarRight = false;
            }
        }
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

                    if (gameScreen.isVisible()
                            && !gameScreen.isPauseMenuVisible()) {
                        gameScreen.showPauseMenu();
                        shouldUpdateGame = false;
                    } else if (gameScreen.isVisible()
                            && gameScreen.isPauseMenuVisible()) {
                        gameScreen.hidePauseMenu();
                        shouldUpdateGame = true;
                    }

                    break;
                case KeyEvent.VK_A:
                    // F3
                    System.out.println("A key pressed.");
                    gameScreen.computerKeyPressed(KeyEvent.VK_A);
//                    moveCarLeft = true;
                    break;
                case KeyEvent.VK_W:
                    // F#3 or Gb3
                    System.out.println("W key pressed.");
                    gameScreen.computerKeyPressed(KeyEvent.VK_W);
//                    moveCarRight = true;
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
        } else if (current_mode == MIDI_KEYBOARD) {
            switch (keyCode) {
                case KeyEvent.VK_SPACE:
                    System.out.println("Space bar pressed.");
                    if (gameScreen.isVisible()
                            && !gameScreen.isPauseMenuVisible()) {
                        gameScreen.showPauseMenu();
                    } else if (gameScreen.isVisible()
                            && gameScreen.isPauseMenuVisible()) {
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
                case KeyEvent.VK_A:
                    // F3
                    System.out.println("A key released.");
//                    keyPressedMap.put(keyCode, true);
                    gameScreen.computerKeyReleased(KeyEvent.VK_A);
                    break;
                case KeyEvent.VK_W:
                    // F#3 or Gb3
                    System.out.println("W key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_W);
                    break;
                case KeyEvent.VK_S:
                    // G3
                    System.out.println("S key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_S);
                    break;
                case KeyEvent.VK_E:
                    // G#3 or Ab3
                    System.out.println("E key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_E);
                    break;
                case KeyEvent.VK_D:
                    // A3
                    System.out.println("D key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_D);
                    break;
                case KeyEvent.VK_R:
                    // A#3 or Bb3
                    System.out.println("R key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_R);
                    break;
                case KeyEvent.VK_F:
                    // B3
                    System.out.println("F key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_F);
                    break;
                case KeyEvent.VK_G:
                    // Middle C or C4
                    System.out.println("G key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_G);
                    break;
                case KeyEvent.VK_Y:
                    // C#4 or Db4
                    System.out.println("Y key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_Y);
                    break;
                case KeyEvent.VK_H:
                    // D4
                    System.out.println("H key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_H);
                    break;
                case KeyEvent.VK_U:
                    // D#4 or Eb4
                    System.out.println("U key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_U);
                    break;
                case KeyEvent.VK_J:
                    // E4
                    System.out.println("J key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_J);
                    break;
                case KeyEvent.VK_K:
                    // F4
                    System.out.println("K key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_K);
                    break;
                case KeyEvent.VK_O:
                    // F#4 or Gb4
                    System.out.println("O key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_O);
                    break;
                case KeyEvent.VK_L:
                    // G4
                    System.out.println("L key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_L);
                    break;
                case KeyEvent.VK_P:
                    // G#4 or Ab4
                    System.out.println("P key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_P);
                    break;
                case KeyEvent.VK_SEMICOLON:
                    // A4
                    System.out.println("; key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_SEMICOLON);
                    break;
                case KeyEvent.VK_OPEN_BRACKET:
                    // A#4 or Bb4
                    System.out.println("[ key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_OPEN_BRACKET);
                    break;
                case KeyEvent.VK_QUOTE:
                    // B4
                    System.out.println("' key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_QUOTE);
                    break;
                default:
                    System.out.println("Other key released.");
                    break;
            }
        } 
    }
    
    public ArrayList<Integer> makeComputerKeyEventsList() {
        /*
            Creates a list of the keyEvents for the computer that will be used
            to control the game in COMPUTER_KEYBOARD mode.
        */
        ArrayList<Integer> events = new ArrayList<Integer>();
        
        events.add(KeyEvent.VK_A); // F
        events.add(KeyEvent.VK_W); // F#
        events.add(KeyEvent.VK_S); // G
        events.add(KeyEvent.VK_E); // G#
        events.add(KeyEvent.VK_D); // A
        events.add(KeyEvent.VK_R); // A#
        events.add(KeyEvent.VK_F); // B
        events.add(KeyEvent.VK_G); // Middle C
        events.add(KeyEvent.VK_Y); // C#
        events.add(KeyEvent.VK_H); // D
        events.add(KeyEvent.VK_U); // D#
        events.add(KeyEvent.VK_J); // E
        events.add(KeyEvent.VK_K); // F
        events.add(KeyEvent.VK_O); // F#
        events.add(KeyEvent.VK_L); // G
        events.add(KeyEvent.VK_P); // G#
        events.add(KeyEvent.VK_SEMICOLON); // A
        events.add(KeyEvent.VK_OPEN_BRACKET); // A#
        events.add(KeyEvent.VK_QUOTE); // B
        
        return events;
    }
    
    public void makeKeyPressedMap() {
        ArrayList<Integer> events = makeComputerKeyEventsList();
        keyPressedMap = new HashMap<Integer,Boolean>();
        
        for (int i=0;i<events.size();i++) {
            keyPressedMap.put(events.get(i), false);
        }
    }

    /*
     Private variables. DO NOT MODIFY.
     */
    private TitleScreenView titleScreen;
    private GameScreenView gameScreen;
    private HashMap<Integer,Boolean> keyPressedMap;
    private int carLeftBoundary;
    private int carRightBoundary;
}
