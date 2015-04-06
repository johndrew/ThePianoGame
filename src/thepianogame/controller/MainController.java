/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.controller;

import java.awt.Dimension;
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
import thepianogame.models.ChordObject;
import thepianogame.models.Game;
import thepianogame.views.ChordObjectView;
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

        // Sets the game control mode. Uncomment this after the prototype is 
        // turned in
//        current_mode = isMIDIKeyboardConnected() ? MIDI_KEYBOARD
//                : COMPUTER_KEYBOARD;
        current_mode = COMPUTER_KEYBOARD;
        makeKeyPressedMap();
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
        /*
         Creates a new game instance.
        
         Starts a new timer.
         */
        shouldUpdateGame = true;
        g = new Game(this, gameScreen);
        timer = new Timer((int) (1000 / 60), this);
        timer.start();
    }

    public void endGame() {
        /*
         Stops the timer and any other things involved in a Game instance
         */
        shouldUpdateGame = false;
        gameScreen.showEndGameMenu();
    }

    public void newGame() {
        /*
         Ends an old game and starts a new one.
        
         This is typically called when the user decides to either
         restart or play again.
         */
        endGame();
        restartGame();
        
    }
    
    public void restartGame() {
        shouldUpdateGame = true;
        g = new Game(this, gameScreen);
        gameScreen.restartGame();
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
    
    public GameScreenView getGameScreen() {
        return this.gameScreen;
    }
    
    public ChordObjectView makeChordView(ChordObject chord) {
        return gameScreen.makeChordView(chord);
    }
    
    public void incrementChordViews(double positionIncrement) {
        gameScreen.incrementChordViews(positionIncrement);
    }
    
    public void removeChordFromView(ChordObject chord) {
        gameScreen.removeChordFromView(chord);
    }
    
    public Dimension getRoadSize() {
        return gameScreen.getRoadSize();
    }
    
    public void decrementLives() {
        gameScreen.removeLife();
    }
    
    public void increaseScore() {
        gameScreen.increaseScore();
    }
    
    public void moveCarLeft() {
        moveCarLeft = true;
    }
    
    public void moveCarRight() {
        moveCarRight = true;
    }
    
    /*
     Used for responding to menu clicks
     */
    public void actionPerformed(ActionEvent e) {
        if (shouldUpdateGame) {
            int key = 0;
            switch (gameScreen.getKey()) {
                case "F":
                    key = 53;
                    break;
                case "F#":
                    key = 54;
                    break;
                case "G":
                    key = 55;
                    break;
                case "G#":
                    key = 56;
                    break;
                case "A":
                    key = 57;
                    break;
                case "A#":
                    key = 58;
                    break;
                case "B":
                    key = 59;
                    break;
                case "C":
                    key = 60;
                    break;
                case "C#":
                    key = 61;
                    break;
                case "D":
                    key = 62;
                    break;
                case "D#":
                    key = 63;
                    break;
                case "E":
                    key = 64;
                    break;
                default:
                    key = 63;
                    break;
            }
            g.setLoopInfo(gameScreen.getTempo(), 60, key, gameScreen.getScale());
            g.run(keyPressedMap);
        }

        if (!gameScreen.isPauseMenuVisible()
                && !gameScreen.isEndGameMenuVisible()) {
            // adjust this number to control the movement speed of dashes on the
            // road. It should adjust based on the difficulty setting.
            gameScreen.moveDashes(gameScreen.getTempo() / 20);
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
                    keyPressedMap.put(53, true);
//                    moveCarLeft = true;
                    break;
                case KeyEvent.VK_W:
                    // F#3 or Gb3
                    System.out.println("W key pressed.");
                    gameScreen.computerKeyPressed(KeyEvent.VK_W);
                    keyPressedMap.put(54, true);
//                    moveCarRight = true;
                    break;
                case KeyEvent.VK_S:
                    // G3
                    System.out.println("S key pressed.");
                    gameScreen.computerKeyPressed(KeyEvent.VK_S);
                    keyPressedMap.put(55, true);
                    break;
                case KeyEvent.VK_E:
                    // G#3 or Ab3
                    System.out.println("E key pressed.");
                    gameScreen.computerKeyPressed(KeyEvent.VK_E);
                    keyPressedMap.put(56, true);
                    break;
                case KeyEvent.VK_D:
                    // A3
                    System.out.println("D key pressed.");
                    gameScreen.computerKeyPressed(KeyEvent.VK_D);
                    keyPressedMap.put(57, true);
                    break;
                case KeyEvent.VK_R:
                    // A#3 or Bb3
                    System.out.println("R key pressed.");
                    gameScreen.computerKeyPressed(KeyEvent.VK_R);
                    keyPressedMap.put(58, true);
                    break;
                case KeyEvent.VK_F:
                    // B3
                    System.out.println("F key pressed.");
                    gameScreen.computerKeyPressed(KeyEvent.VK_F);
                    keyPressedMap.put(59, true);
                    break;
                case KeyEvent.VK_G:
                    // Middle C or C4
                    System.out.println("G key pressed.");
                    gameScreen.computerKeyPressed(KeyEvent.VK_G);
                    keyPressedMap.put(60, true);
                    break;
                case KeyEvent.VK_Y:
                    // C#4 or Db4
                    System.out.println("Y key pressed.");
                    gameScreen.computerKeyPressed(KeyEvent.VK_Y);
                    keyPressedMap.put(61, true);
                    break;
                case KeyEvent.VK_H:
                    // D4
                    System.out.println("H key pressed.");
                    gameScreen.computerKeyPressed(KeyEvent.VK_H);
                    keyPressedMap.put(62, true);
                    break;
                case KeyEvent.VK_U:
                    // D#4 or Eb4
                    System.out.println("U key pressed.");
                    gameScreen.computerKeyPressed(KeyEvent.VK_U);
                    keyPressedMap.put(63, true);
                    break;
                case KeyEvent.VK_J:
                    // E4
                    System.out.println("J key pressed.");
                    gameScreen.computerKeyPressed(KeyEvent.VK_J);
                    keyPressedMap.put(64, true);
                    break;
                case KeyEvent.VK_K:
                    // F4
                    System.out.println("K key pressed.");
                    gameScreen.computerKeyPressed(KeyEvent.VK_K);
                    keyPressedMap.put(65, true);
                    break;
                case KeyEvent.VK_O:
                    // F#4 or Gb4
                    System.out.println("O key pressed.");
                    gameScreen.computerKeyPressed(KeyEvent.VK_O);
                    keyPressedMap.put(66, true);
                    break;
                case KeyEvent.VK_L:
                    // G4
                    System.out.println("L key pressed.");
                    gameScreen.computerKeyPressed(KeyEvent.VK_L);
                    keyPressedMap.put(67, true);
                    break;
                case KeyEvent.VK_P:
                    // G#4 or Ab4
                    System.out.println("P key pressed.");
                    gameScreen.computerKeyPressed(KeyEvent.VK_P);
                    keyPressedMap.put(68, true);
                    break;
                case KeyEvent.VK_SEMICOLON:
                    // A4
                    System.out.println("; key pressed.");
                    gameScreen.computerKeyPressed(KeyEvent.VK_SEMICOLON);
                    keyPressedMap.put(69, true);
                    break;
                case KeyEvent.VK_OPEN_BRACKET:
                    // A#4 or Bb4
                    System.out.println("[ key pressed.");
                    gameScreen.computerKeyPressed(KeyEvent.VK_OPEN_BRACKET);
                    keyPressedMap.put(70, true);
                    break;
                case KeyEvent.VK_QUOTE:
                    // B4
                    System.out.println("' key pressed.");
                    gameScreen.computerKeyPressed(KeyEvent.VK_QUOTE);
                    keyPressedMap.put(71, true);
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
                    keyPressedMap.put(53, false);
                    break;
                case KeyEvent.VK_W:
                    // F#3 or Gb3
                    System.out.println("W key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_W);
                    keyPressedMap.put(54, false);
                    break;
                case KeyEvent.VK_S:
                    // G3
                    System.out.println("S key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_S);
                    keyPressedMap.put(55, false);
                    break;
                case KeyEvent.VK_E:
                    // G#3 or Ab3
                    System.out.println("E key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_E);
                    keyPressedMap.put(56, false);
                    break;
                case KeyEvent.VK_D:
                    // A3
                    System.out.println("D key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_D);
                    keyPressedMap.put(57, false);
                    break;
                case KeyEvent.VK_R:
                    // A#3 or Bb3
                    System.out.println("R key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_R);
                    keyPressedMap.put(58, false);
                    break;
                case KeyEvent.VK_F:
                    // B3
                    System.out.println("F key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_F);
                    keyPressedMap.put(59, false);
                    break;
                case KeyEvent.VK_G:
                    // Middle C or C4
                    System.out.println("G key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_G);
                    keyPressedMap.put(60, false);
                    break;
                case KeyEvent.VK_Y:
                    // C#4 or Db4
                    System.out.println("Y key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_Y);
                    keyPressedMap.put(61, false);
                    break;
                case KeyEvent.VK_H:
                    // D4
                    System.out.println("H key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_H);
                    keyPressedMap.put(62, false);
                    break;
                case KeyEvent.VK_U:
                    // D#4 or Eb4
                    System.out.println("U key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_U);
                    keyPressedMap.put(63, false);
                    break;
                case KeyEvent.VK_J:
                    // E4
                    System.out.println("J key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_J);
                    keyPressedMap.put(64, false);
                    break;
                case KeyEvent.VK_K:
                    // F4
                    System.out.println("K key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_K);
                    keyPressedMap.put(65, false);
                    break;
                case KeyEvent.VK_O:
                    // F#4 or Gb4
                    System.out.println("O key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_O);
                    keyPressedMap.put(66, false);
                    break;
                case KeyEvent.VK_L:
                    // G4
                    System.out.println("L key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_L);
                    keyPressedMap.put(67, false);
                    break;
                case KeyEvent.VK_P:
                    // G#4 or Ab4
                    System.out.println("P key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_P);
                    keyPressedMap.put(68, false);
                    break;
                case KeyEvent.VK_SEMICOLON:
                    // A4
                    System.out.println("; key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_SEMICOLON);
                    keyPressedMap.put(69, false);
                    break;
                case KeyEvent.VK_OPEN_BRACKET:
                    // A#4 or Bb4
                    System.out.println("[ key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_OPEN_BRACKET);
                    keyPressedMap.put(70, false);
                    break;
                case KeyEvent.VK_QUOTE:
                    // B4
                    System.out.println("' key released.");
                    gameScreen.computerKeyReleased(KeyEvent.VK_QUOTE);
                    keyPressedMap.put(71, false);
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

        events.add(53); // F
        events.add(54); // F#
        events.add(55); // G
        events.add(56); // G#
        events.add(57); // A
        events.add(58); // A#
        events.add(59); // B
        events.add(60); // Middle C
        events.add(61); // C#
        events.add(62); // D
        events.add(63); // D#
        events.add(64); // E
        events.add(65); // F
        events.add(66); // F#
        events.add(67); // G
        events.add(68); // G#
        events.add(69); // A
        events.add(70); // A#
        events.add(71); // B

        return events;
    }

    public void makeKeyPressedMap() {
        /*
         Creates a hashmap of KeyEvents to boolean values
        
         Used to determine which keys are being pressed at a certain time.
         */
        ArrayList<Integer> events = makeComputerKeyEventsList();
        keyPressedMap = new HashMap<Integer, Boolean>();

        for (int i = 0; i < events.size(); i++) {
            keyPressedMap.put(events.get(i), false);
        }
    }

    /*
     Private variables. DO NOT MODIFY.
     */
    private TitleScreenView titleScreen;
    private GameScreenView gameScreen;
    private HashMap<Integer, Boolean> keyPressedMap;
    private int carLeftBoundary;
    private int carRightBoundary;
}
