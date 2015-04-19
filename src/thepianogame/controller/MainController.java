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
import thepianogame.models.Car;
import thepianogame.models.ChordObject;
import thepianogame.models.Game;
import thepianogame.models.Note;
import thepianogame.views.CarView;
import thepianogame.views.ChordObjectView;
import thepianogame.views.GameScreenView;
import thepianogame.views.InstructionsView;
import thepianogame.views.PianoView;
import thepianogame.views.RoadView;
import thepianogame.views.SettingsView;
import thepianogame.views.TitleScreenView;

public final class MainController extends JFrame implements ActionListener,
        KeyListener {

    public enum CONTROL_MODE {

        MIDI_KEYBOARD, COMPUTER_KEYBOARD
    };
    private final CONTROL_MODE current_mode;
    private Timer timer;
    public Game g;
    public boolean shouldUpdateGame;
    private boolean moveCarLeft = false;
    private boolean moveCarRight = false;
    private Dimension roadSize = new Dimension(420, 480);

    public MainController() {
        makeViews();
        makeModels();
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
    
    public final void makeViews() {
        // Two main views
        titleScreenView = new TitleScreenView(this);
        gameScreenView = new GameScreenView(this);
        
        // Views on the game screen
        roadView = new RoadView(roadSize);
        carView = new CarView();
        roadView.addCar(carView);
        pianoView = new PianoView(current_mode);
        settingsView = new SettingsView(this);
        
        // Views on the title screen
        instructionsView = new InstructionsView(current_mode);
        
        // set views in their main views
        gameScreenView.setRoadView(roadView);
        gameScreenView.setRoadSize(roadSize);
        gameScreenView.setPiano(pianoView);
        gameScreenView.setSettingsView(settingsView);
        titleScreenView.setInstructionsView(instructionsView);
    }
    
    public final void makeModels() {
        carModel = new Car();
        
        // set models
        carView.setModel(carModel);
    }

    /*
     Setup the GUI and ActionListeners
     */
    public final void initUI() {
        /*
         Initializes the various views
         */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // start the game on the title screen
        this.add(titleScreenView);

        titleScreenView.setVisible(true);
        gameScreenView.setVisible(false);

        carLeftBoundary = 63;
        carRightBoundary = 321;
        }

    /*
        ACTION/EVENT LISTENERS
    */
    
    /*
     Used for responding to menu clicks
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (shouldUpdateGame) {
            int key = 0;
            switch (gameScreenView.getKey()) {
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
            g.run(keyPressedMap);
            g.setKey(key);
        }

        if (!gameScreenView.isPauseMenuVisible()
                && !gameScreenView.isEndGameMenuVisible()) {
            // adjust this number to control the movement speed of dashes on the
            // road. It should adjust based on the difficulty setting.
            gameScreenView.moveDashes(gameScreenView.getTempo() / 20);
        }

        if (moveCarLeft) {
//            int carX = gameScreenView.getCarXCoordinate();
            int carX = carView.getX();
            if (carX != carLeftBoundary) {
                // if you change this number below, you must also change
                // the carLeftBoundary because the boundary needs to be
                // a multiple of the number below
                carView.moveCarLeft(3);
            } else {
                moveCarLeft = false;
            }
        } else if (moveCarRight) {
//            int carX = gameScreenView.getCarXCoordinate();
            int carX = carView.getX();
            if (carX != carRightBoundary) {
                // if you change this number below, you must also change
                // the carRightBoundary because the boundary needs to be
                // a multiple of the number below
                carView.moveCarRight(3);
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

                    if (gameScreenView.isVisible()
                            && !gameScreenView.isPauseMenuVisible()) {
                        gameScreenView.showPauseMenu();
                        shouldUpdateGame = false;
                    } else if (gameScreenView.isVisible()
                            && gameScreenView.isPauseMenuVisible()) {
                        gameScreenView.hidePauseMenu();
                        shouldUpdateGame = true;
                    }

                    break;
                case KeyEvent.VK_A:
                    // F3
                    System.out.println("A key pressed.");
                    gameScreenView.computerKeyPressed(KeyEvent.VK_A);
                    keyPressedMap.put(53, true);
                    break;
                case KeyEvent.VK_W:
                    // F#3 or Gb3
                    System.out.println("W key pressed.");
                    gameScreenView.computerKeyPressed(KeyEvent.VK_W);
                    keyPressedMap.put(54, true);
                    break;
                case KeyEvent.VK_S:
                    // G3
                    System.out.println("S key pressed.");
                    gameScreenView.computerKeyPressed(KeyEvent.VK_S);
                    keyPressedMap.put(55, true);
                    break;
                case KeyEvent.VK_E:
                    // G#3 or Ab3
                    System.out.println("E key pressed.");
                    gameScreenView.computerKeyPressed(KeyEvent.VK_E);
                    keyPressedMap.put(56, true);
                    break;
                case KeyEvent.VK_D:
                    // A3
                    System.out.println("D key pressed.");
                    gameScreenView.computerKeyPressed(KeyEvent.VK_D);
                    keyPressedMap.put(57, true);
                    break;
                case KeyEvent.VK_R:
                    // A#3 or Bb3
                    System.out.println("R key pressed.");
                    gameScreenView.computerKeyPressed(KeyEvent.VK_R);
                    keyPressedMap.put(58, true);
                    break;
                case KeyEvent.VK_F:
                    // B3
                    System.out.println("F key pressed.");
                    gameScreenView.computerKeyPressed(KeyEvent.VK_F);
                    keyPressedMap.put(59, true);
                    break;
                case KeyEvent.VK_G:
                    // Middle C or C4
                    System.out.println("G key pressed.");
                    gameScreenView.computerKeyPressed(KeyEvent.VK_G);
                    keyPressedMap.put(60, true);
                    break;
                case KeyEvent.VK_Y:
                    // C#4 or Db4
                    System.out.println("Y key pressed.");
                    gameScreenView.computerKeyPressed(KeyEvent.VK_Y);
                    keyPressedMap.put(61, true);
                    break;
                case KeyEvent.VK_H:
                    // D4
                    System.out.println("H key pressed.");
                    gameScreenView.computerKeyPressed(KeyEvent.VK_H);
                    keyPressedMap.put(62, true);
                    break;
                case KeyEvent.VK_U:
                    // D#4 or Eb4
                    System.out.println("U key pressed.");
                    gameScreenView.computerKeyPressed(KeyEvent.VK_U);
                    keyPressedMap.put(63, true);
                    break;
                case KeyEvent.VK_J:
                    // E4
                    System.out.println("J key pressed.");
                    gameScreenView.computerKeyPressed(KeyEvent.VK_J);
                    keyPressedMap.put(64, true);
                    break;
                case KeyEvent.VK_K:
                    // F4
                    System.out.println("K key pressed.");
                    gameScreenView.computerKeyPressed(KeyEvent.VK_K);
                    keyPressedMap.put(65, true);
                    break;
                case KeyEvent.VK_O:
                    // F#4 or Gb4
                    System.out.println("O key pressed.");
                    gameScreenView.computerKeyPressed(KeyEvent.VK_O);
                    keyPressedMap.put(66, true);
                    break;
                case KeyEvent.VK_L:
                    // G4
                    System.out.println("L key pressed.");
                    gameScreenView.computerKeyPressed(KeyEvent.VK_L);
                    keyPressedMap.put(67, true);
                    break;
                case KeyEvent.VK_P:
                    // G#4 or Ab4
                    System.out.println("P key pressed.");
                    gameScreenView.computerKeyPressed(KeyEvent.VK_P);
                    keyPressedMap.put(68, true);
                    break;
                case KeyEvent.VK_SEMICOLON:
                    // A4
                    System.out.println("; key pressed.");
                    gameScreenView.computerKeyPressed(KeyEvent.VK_SEMICOLON);
                    keyPressedMap.put(69, true);
                    break;
                case KeyEvent.VK_OPEN_BRACKET:
                    // A#4 or Bb4
                    System.out.println("[ key pressed.");
                    gameScreenView.computerKeyPressed(KeyEvent.VK_OPEN_BRACKET);
                    keyPressedMap.put(70, true);
                    break;
                case KeyEvent.VK_QUOTE:
                    // B4
                    System.out.println("' key pressed.");
                    gameScreenView.computerKeyPressed(KeyEvent.VK_QUOTE);
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
                    if (gameScreenView.isVisible()
                            && !gameScreenView.isPauseMenuVisible()) {
                        gameScreenView.showPauseMenu();
                    } else if (gameScreenView.isVisible()
                            && gameScreenView.isPauseMenuVisible()) {
                        gameScreenView.hidePauseMenu();
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
                    gameScreenView.computerKeyReleased(KeyEvent.VK_A);
                    keyPressedMap.put(53, false);
                    break;
                case KeyEvent.VK_W:
                    // F#3 or Gb3
                    System.out.println("W key released.");
                    gameScreenView.computerKeyReleased(KeyEvent.VK_W);
                    keyPressedMap.put(54, false);
                    break;
                case KeyEvent.VK_S:
                    // G3
                    System.out.println("S key released.");
                    gameScreenView.computerKeyReleased(KeyEvent.VK_S);
                    keyPressedMap.put(55, false);
                    break;
                case KeyEvent.VK_E:
                    // G#3 or Ab3
                    System.out.println("E key released.");
                    gameScreenView.computerKeyReleased(KeyEvent.VK_E);
                    keyPressedMap.put(56, false);
                    break;
                case KeyEvent.VK_D:
                    // A3
                    System.out.println("D key released.");
                    gameScreenView.computerKeyReleased(KeyEvent.VK_D);
                    keyPressedMap.put(57, false);
                    break;
                case KeyEvent.VK_R:
                    // A#3 or Bb3
                    System.out.println("R key released.");
                    gameScreenView.computerKeyReleased(KeyEvent.VK_R);
                    keyPressedMap.put(58, false);
                    break;
                case KeyEvent.VK_F:
                    // B3
                    System.out.println("F key released.");
                    gameScreenView.computerKeyReleased(KeyEvent.VK_F);
                    keyPressedMap.put(59, false);
                    break;
                case KeyEvent.VK_G:
                    // Middle C or C4
                    System.out.println("G key released.");
                    gameScreenView.computerKeyReleased(KeyEvent.VK_G);
                    keyPressedMap.put(60, false);
                    break;
                case KeyEvent.VK_Y:
                    // C#4 or Db4
                    System.out.println("Y key released.");
                    gameScreenView.computerKeyReleased(KeyEvent.VK_Y);
                    keyPressedMap.put(61, false);
                    break;
                case KeyEvent.VK_H:
                    // D4
                    System.out.println("H key released.");
                    gameScreenView.computerKeyReleased(KeyEvent.VK_H);
                    keyPressedMap.put(62, false);
                    break;
                case KeyEvent.VK_U:
                    // D#4 or Eb4
                    System.out.println("U key released.");
                    gameScreenView.computerKeyReleased(KeyEvent.VK_U);
                    keyPressedMap.put(63, false);
                    break;
                case KeyEvent.VK_J:
                    // E4
                    System.out.println("J key released.");
                    gameScreenView.computerKeyReleased(KeyEvent.VK_J);
                    keyPressedMap.put(64, false);
                    break;
                case KeyEvent.VK_K:
                    // F4
                    System.out.println("K key released.");
                    gameScreenView.computerKeyReleased(KeyEvent.VK_K);
                    keyPressedMap.put(65, false);
                    break;
                case KeyEvent.VK_O:
                    // F#4 or Gb4
                    System.out.println("O key released.");
                    gameScreenView.computerKeyReleased(KeyEvent.VK_O);
                    keyPressedMap.put(66, false);
                    break;
                case KeyEvent.VK_L:
                    // G4
                    System.out.println("L key released.");
                    gameScreenView.computerKeyReleased(KeyEvent.VK_L);
                    keyPressedMap.put(67, false);
                    break;
                case KeyEvent.VK_P:
                    // G#4 or Ab4
                    System.out.println("P key released.");
                    gameScreenView.computerKeyReleased(KeyEvent.VK_P);
                    keyPressedMap.put(68, false);
                    break;
                case KeyEvent.VK_SEMICOLON:
                    // A4
                    System.out.println("; key released.");
                    gameScreenView.computerKeyReleased(KeyEvent.VK_SEMICOLON);
                    keyPressedMap.put(69, false);
                    break;
                case KeyEvent.VK_OPEN_BRACKET:
                    // A#4 or Bb4
                    System.out.println("[ key released.");
                    gameScreenView.computerKeyReleased(KeyEvent.VK_OPEN_BRACKET);
                    keyPressedMap.put(70, false);
                    break;
                case KeyEvent.VK_QUOTE:
                    // B4
                    System.out.println("' key released.");
                    gameScreenView.computerKeyReleased(KeyEvent.VK_QUOTE);
                    keyPressedMap.put(71, false);
                    break;
                default:
                    System.out.println("Other key released.");
                    break;
            }
        }
    }

    /*
        GAME CONTROL METHODS
    */

    public void startGame() {
        /*
         Switches to the game screen.
         Hides the title screen, but does not remove it
         */
        this.add(gameScreenView);

        titleScreenView.setVisible(false);
        gameScreenView.setVisible(true);
        startNewGame();
    }

    public void startNewGame() {
        /*
         Creates a new game instance.
        
         Starts a new timer.
         */
        shouldUpdateGame = true;
        g = new Game(this, gameScreenView);
        g.setCarModel(carModel);
        if (timer == null) {
            timer = new Timer((int) (1000 / 60), this);
        }
        timer.start();
    }

    public void endGame() {
        /*
         Stops the timer and any other things involved in a Game instance
         */
        shouldUpdateGame = false;
        gameScreenView.showEndGameMenu();
    }

    public void restartGame() {
        /*
         Ends an old game and starts a new one.
        
         This is typically called when the user decides to either
         restart or play again.
         */
        newGame();
    }
    
    public void newGame() {
        shouldUpdateGame = true;
        g = new Game(this, gameScreenView);
        gameScreenView.restartGame();
    }

    public void backToMenu() {
        /*
         Shows the TitleScreenView and hides the GameScreenView
        
         Ends the current game.
         */
        
        gameScreenView.setVisible(false);
        titleScreenView.setVisible(true);
        shouldUpdateGame = false;
        timer.stop();
        remove(gameScreenView);
        remove(titleScreenView);
        makeViews();
        makeModels();
        initUI();
    }

    public void closeProgram() {
        System.exit(0);
    }
    
    public void incrementChordViews(double positionIncrement) {
        gameScreenView.incrementChordViews(positionIncrement);
    }
    
    public void removeChordFromView(ChordObject chord) {
        gameScreenView.removeChordFromView(chord);
    }
    
    public void decrementLives() {
        gameScreenView.removeLife();
    }
    
    public void increaseScore() {
        gameScreenView.increaseScore();
    }
    
    public void moveCarLeft() {
        moveCarLeft = true;
    }
    
    public void moveCarRight() {
        moveCarRight = true;
    }
    
    public void changeKeysGreen(ArrayList<Note> notes) {
        /*
            Highlights the keys green on the pianoview that the user should play 
        */
        HashMap<Integer, Integer> map = makeMIDIKeyToComputerKeyMap();
        
        for (Note note : notes) {
            pianoView.turnKeyGreen(map.get(note.getValue()));
        }
    }
    
    public void changeKeysBackToOriginalColor(ArrayList<Note> notes) {
        /*
            Turns the keys back to their original color (either white or black)
        */
        HashMap<Integer, Integer> map = makeMIDIKeyToComputerKeyMap();
        ArrayList<Integer> events = makeComputerKeyEventsList();
        
        for (Note note : notes) {
            pianoView.turnKeyBackToOriginalColor(map.get(note.getValue()));
        }
    }
    
    /*
        MAKE METHODS
    */

    public ChordObjectView makeChordView(ChordObject chord) {
        return gameScreenView.makeChordView(chord);
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
    
    public HashMap<Integer, Integer> makeMIDIKeyToComputerKeyMap() {
        ArrayList<Integer> events = makeComputerKeyEventsList();
        ArrayList<Integer> keyCodes = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        keyCodes.add(KeyEvent.VK_A);
        keyCodes.add(KeyEvent.VK_W);
        keyCodes.add(KeyEvent.VK_S);
        keyCodes.add(KeyEvent.VK_E);
        keyCodes.add(KeyEvent.VK_D);
        keyCodes.add(KeyEvent.VK_R);
        keyCodes.add(KeyEvent.VK_F);
        keyCodes.add(KeyEvent.VK_G);
        keyCodes.add(KeyEvent.VK_Y);
        keyCodes.add(KeyEvent.VK_H);
        keyCodes.add(KeyEvent.VK_U);
        keyCodes.add(KeyEvent.VK_J);
        keyCodes.add(KeyEvent.VK_K);
        keyCodes.add(KeyEvent.VK_O);
        keyCodes.add(KeyEvent.VK_L);
        keyCodes.add(KeyEvent.VK_P);
        keyCodes.add(KeyEvent.VK_SEMICOLON);
        keyCodes.add(KeyEvent.VK_OPEN_BRACKET);
        keyCodes.add(KeyEvent.VK_QUOTE);
        keyCodes.add(KeyEvent.VK_CLOSE_BRACKET);
        
        for (int i=0;i<events.size();i++) {
            map.put(events.get(i), keyCodes.get(i));
        }
        
        return map;
    }
    
    /*
        GETTERS
    */
    
    public Dimension getRoadSize() {
        return roadSize;
    }
    
    public GameScreenView getGameScreen() {
        return this.gameScreenView;
    }
    
    public Car getCarModel() {
        return this.carModel;
    }
    
    /*
        SETTERS
    */
    
    public void setCarView(CarView car) {
        carView = car;
    }

    /*
        OTHER METHODS
    */
    
    public boolean isMIDIKeyboardConnected() {
        /*
         Will check if a MIDI keyboard is connected to the computer
         by USB. If yes, then true is returned.
         */
        return false;
    }
    
    /*
     Private variables. DO NOT MODIFY.
     */
    private HashMap<Integer, Boolean> keyPressedMap;
    private int carLeftBoundary;
    private int carRightBoundary;
    
    // single instance views
    private TitleScreenView titleScreenView;
    private InstructionsView instructionsView;
    private GameScreenView gameScreenView;
    private RoadView roadView;
    private CarView carView;
    private PianoView pianoView;
    private SettingsView settingsView;
    
    // single instance models
    private Car carModel;
}
