/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import thepianogame.controller.MainController;
import thepianogame.models.Car;
import thepianogame.models.ChordObject;
import thepianogame.models.Game;
import thepianogame.models.Player;

public class GameScreenView extends JPanel {
    
    public GameScreenView(MainController controller) {
        this.controller = controller;
        lives = new ArrayList<>();
        gameModel = controller.g;
        chordViews = new ArrayList<>();
        
        initComponents();
    }
    
    public final void initComponents() {
        dialogPosition = new Point(250, 200);
        makeGameWindow();
        makePauseDialog();
        makeEndGameDialog();
        makeCountdownDialog();
        
        setLayout(new BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));
    }
    
    /*
        MAKE FUNCTIONS
    */
    
    public final void makeGameWindow() {
        /*
            Creates the window that will contain the road, car, chord objects,
            and options.
        */
        gameWindow = new JPanel();
        gameWindow.setLayout(new BorderLayout());
          
        JSeparator separator= new javax.swing.JSeparator();
        gameWindow.add(separator, BorderLayout.NORTH);
        
        player = new Player(0, 3);
        JLabel score = new JLabel();
        scoreNumber = new JLabel();
        scoreValue = player.score;
        
        score.setText("SCORE:");
        scoreNumber.setText(String.valueOf(scoreValue));
        
        score.setFont(score.getFont ().deriveFont (18.0f));
        scoreNumber.setFont(scoreNumber.getFont ().deriveFont (18.0f));
        
        scorePanel = new JPanel();
        Dimension scoreSize = new Dimension(200, 28);
        scorePanel.setPreferredSize(scoreSize);
        scorePanel.setLayout(new FlowLayout());
        scorePanel.add(score);
        scorePanel.add(scoreNumber);
      
        livesPanel = new JPanel();
        Dimension lifesSize = new Dimension(150, 50);
        livesPanel.setPreferredSize(lifesSize);
   
        // add a life for every life the player has
        for(int i = 0; i < player.lives; i++){livesPanel.add(newLife());}

        Dimension marginSize = new Dimension(200, 480);
        JPanel leftMargin = new JPanel();
        leftMargin.setPreferredSize(marginSize);
        leftMargin.setMaximumSize(marginSize);
        leftMargin.setMinimumSize(marginSize);
        
        rightMargin = new JPanel();
        rightMargin.setPreferredSize(marginSize);
        rightMargin.setMaximumSize(marginSize);
        rightMargin.setMinimumSize(marginSize);
        
        gameWindow.add(leftMargin, BorderLayout.WEST);
        gameWindow.add(rightMargin, BorderLayout.EAST);
        
        leftMargin.add(livesPanel);
        leftMargin.add(scorePanel);
        
        add(gameWindow);
        // Add a gap to separate the road from the piano
        add(Box.createRigidArea(new Dimension(0,5)));
    }
    
    public final void makePianoVisualization() {
        /*
            Creates the piano visualization
        */
        pianoViewContainer = new JPanel();
        Dimension pianoSize = new Dimension(684, 92);
        pianoViewContainer.setSize(pianoSize);
        pianoViewContainer.setPreferredSize(pianoSize);
        pianoViewContainer.setMaximumSize(pianoSize);
        pianoViewContainer.setMinimumSize(pianoSize);

        piano.setMinimumSize(pianoSize);
        pianoViewContainer.setLayout(new BorderLayout());
        pianoViewContainer.add(piano, BorderLayout.CENTER);
        add(pianoViewContainer);
    }
    
    public final void makePauseDialog() {
        pauseMenu = new JDialog();
        JPanel menuContainer = new JPanel();
        JLabel title = new JLabel("Paused Game", SwingConstants.CENTER);
        JButton resume = new JButton("Resume");
        JButton restart = new JButton("Restart");
        JButton endGame = new JButton("End Game");
        JPanel buttons = new JPanel();
        
        pauseMenu.setLayout(new BorderLayout());
        pauseMenu.add(menuContainer, BorderLayout.CENTER);
        menuContainer.setLayout(new BorderLayout());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 32));
        pauseMenu.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        
        menuContainer.add(title, BorderLayout.NORTH);
        
        buttons.setLayout(new GridLayout(3,1));
        buttons.add(resume);
        buttons.add(restart);
        buttons.add(endGame);
        menuContainer.add(buttons, BorderLayout.CENTER);
        
        resume.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                hidePauseMenu();
                controller.shouldUpdateGame = true;
            }
            
        });
        
        restart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.restartGame();
                piano.turnAllKeysBackToOriginalColor();
                hidePauseMenu();
            }
        });
        
        endGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showEndGameMenu();
            }
        });
        
        pauseMenu.setPreferredSize(new Dimension(400, 400));
        pauseMenu.setLocation(dialogPosition);
        pauseMenu.setVisible(false);
        pauseMenu.pack();
        pauseMenu.setModal(false);
        pauseMenu.setAlwaysOnTop(true);
    }
    
    public final void makeEndGameDialog() {
        /*
            Creates the JPanel that will appear when either the users selects
            "End Game" from the pause menu, or the user runs out of lives.
        
            This allows the user to either play again or exit to the main menu.
            Also displays the final score.
        */
        endGameMenu = new JDialog();
        JPanel container = new JPanel();
        JLabel title = new JLabel("Game Over", SwingConstants.CENTER);
        JButton playAgain = new JButton("Play Again");
        JButton backToMenu = new JButton("Back To Menu");
        endGameMenu.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        
        playAgain.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.newGame();
                piano.turnAllKeysBackToOriginalColor();
                hideEndGameMenu();
                gameWindow.setVisible(true);
            }
        });
        
        backToMenu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.backToMenu();
                hideEndGameMenu();
            }
        });
        
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
        
        endGameMenu.setLayout(new BorderLayout());
        endGameMenu.add(container, BorderLayout.CENTER);
        endGameMenu.add(title, BorderLayout.NORTH);
        container.setLayout(new GridLayout(2,1));
        container.add(playAgain);
        container.add(backToMenu);
        
        endGameMenu.setPreferredSize(new Dimension(400, 400));
        endGameMenu.setLocation(dialogPosition);
        endGameMenu.setVisible(false);
        endGameMenu.pack();
        endGameMenu.setModal(true);
        endGameMenu.setAlwaysOnTop(true);
        
    }
    
    public final void makeCountdownDialog() {
        countdownDialog = new JDialog();
        JButton start = new JButton("Start");
        countdownDialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        
        start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.startNewGame();
                countdownDialog.setVisible(false);
                settings.deactivate();
            }
        });
        
        countdownDialog.setLayout(new BorderLayout());
        countdownDialog.add(start, BorderLayout.CENTER);
        countdownDialog.setPreferredSize(new Dimension(100, 100));
        countdownDialog.setLocation(new Point(388, 300));
        countdownDialog.setVisible(false);
        countdownDialog.pack();
        countdownDialog.setModal(false);
        countdownDialog.setAlwaysOnTop(true);
    }
    
    public ChordObjectView makeChordView(ChordObject chord) {
        ChordObjectView chordView = new ChordObjectView(chord.chord.getName(), 
                chord.onRightSide, chord.id);
        
        chordViews.add(chordView);
        chordView.setObjectBounds(roadSize);
        road.add(chordView);
        road.revalidate();
        road.repaint();
        
        return chordView;
    }
    
    /*
        GETTERS
    */
    
    public Dimension getRoadSize() {
        return road.getRoadSize();
    }
    
    public int getTempo() {
        return settings.getTempo();
    }
    
    public String getKey() {
        return settings.getKey();
    }
    
    public String getScale() {
        return settings.getScale();
    }
    
    public RoadView getRoadView() {
        return this.road;
    }
    
    /*
        SETTERS
    */
    
    public void setGameModel(Game game) {
        this.gameModel = game;
    }
    
    public void setCarModel(Car carModel) {
        road.addCarModelToCarView(carModel);
    }
    
    public void setRoadView(RoadView road) {
        this.road = road;
        gameWindow.add(road, BorderLayout.CENTER);
    }
    
    public void setRoadSize(Dimension size) {
        this.roadSize = size;
    }
    
    public void setPiano(PianoView pianoView) {
        this.piano = pianoView;
        makePianoVisualization();
    }
    
    public void setSettingsView(SettingsView settings) {
        this.settings = settings;
        rightMargin.add(settings);
    }
    
    /*
        OTHER FUNCTIONS
    */
    
    public boolean isPauseMenuVisible() {
        return pauseMenu.isVisible();
    }
    
    public void showPauseMenu() {
        pauseMenu.setVisible(true);
        settings.activate();
    }
    
    public void hidePauseMenu() {
        pauseMenu.setVisible(false);
        settings.deactivate();
    }
    
    public boolean isEndGameMenuVisible() {
        return endGameMenu.isVisible();
    }
    
    public void showEndGameMenu() {
        pauseMenu.setVisible(false);
        endGameMenu.setVisible(true);
    }
    
    public void hideEndGameMenu() {
        /*
            Hides the endGameMenu
        */
        endGameMenu.setVisible(false);
    }
    
    public void computerKeyPressed(int keyEventCode) {
        piano.computerKeyPressed(keyEventCode);
    }
    
    public void computerKeyReleased(int keyEventCode) {
        piano.computerKeyReleased(keyEventCode);
    }
    
    public void moveDashes(int amountToMove) {
        road.moveDashes(amountToMove);
    }
    
    public boolean isCarOnRightSide() {
        return road.isCarOnRightSide();
    }
    
    public void incrementChordViews(double positionIncrement) {
        for (ChordObjectView chordView : chordViews) {
            chordView.moveChordView(positionIncrement, roadSize.height);
        }
    }
    
    public void removeChordFromView(ChordObject chord) {
        for (ChordObjectView chordView : chordViews) {
            if (chordView.id.equals(chord.id)) {
                chordView.hideChordView();
                chordView = null;
                break;
            }
        }
    }
    
    private JLabel newLife(){
        BufferedImage img = null;
        try {
            String path = "/thepianogame/resources/musicNote.png";
            img = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException ex) {
            Logger.getLogger(CarView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JLabel life = new JLabel(new ImageIcon(img));
        lives.add(life);
        
        return life;
    }
    
    public void removeLife() {
        lives.remove(0).setVisible(false);
        if (lives.isEmpty()) {
            controller.endGame();
        } 
    }
    
    public void increaseScore() {
        scoreValue += 10;
        scoreNumber.setText(String.valueOf(scoreValue));
        scoreNumber.revalidate();
        scoreNumber.repaint();
        scorePanel.revalidate();
        scorePanel.repaint();
    }
    
    public void restartGame() {
        while (!lives.isEmpty()) {
            lives.remove(0).setVisible(false);
        }
        for (int i=0;i<3;i++) {
            livesPanel.add(newLife());
        }
        road = new RoadView(roadSize);

        car = new CarView();
        road.addCar(car);
        controller.setCarView(car);

        gameWindow.add(road, BorderLayout.CENTER);
        removeChordViews();
        resetScore();
    }
    
    public void removeChordViews() {
        for (ChordObjectView view : chordViews) {
            view.setVisible(false);
        }
    }
    
    public void resetScore() {
        /*
            Resets the score display back to zero
        */
        scoreValue = 0;
        scoreNumber.setText(String.valueOf(scoreValue));
        scoreNumber.revalidate();
        scoreNumber.repaint();
        scorePanel.revalidate();
        scorePanel.repaint();
    }
    
    public void makeCountdownDialogVisible() {
        countdownDialog.setVisible(true);
    }
    
    public void makeCountdownDialogInvisible() {
        countdownDialog.setVisible(false);
    }
    
    /*
        Private variables. DO NOT MODIFY.
    */
    private MainController controller;
    private JPanel gameWindow;
    private JPanel pianoViewContainer;
    private JDialog pauseMenu;
    private JDialog endGameMenu;
    private RoadView road;
    private CarView car;
    private PianoView piano;
    private SettingsView settings;
    private Player player;
    private Game gameModel;
    private ArrayList<ChordObjectView> chordViews;
    private ArrayList<ChordObject> chordObjects;
    private Dimension roadSize;
    private ArrayList<JLabel> lives;
    private int scoreValue;
    private JPanel scorePanel;
    private JLabel scoreNumber;
    private JPanel livesPanel;
    private JPanel rightMargin;
    private Point dialogPosition;
    private JDialog countdownDialog;
}
