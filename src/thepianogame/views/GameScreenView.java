/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import thepianogame.controller.MainController;
//<<<<<<< Updated upstream
import thepianogame.models.Player;
//=======
//import thepianogame.controller.MainController.CONTROL_MODE;
//import static thepianogame.controller.MainController.CONTROL_MODE.MIDI_KEYBOARD;
//>>>>>>> Stashed changes
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
          
        JSeparator separator= new javax.swing.JSeparator();
        gameWindow.add(separator, BorderLayout.NORTH);
        
        JLabel score = new JLabel();
        JLabel scoreNumber = new JLabel();
        
        score.setText("SCORE:");
        scoreNumber.setText("0");
        
        score.setFont(score.getFont ().deriveFont (18.0f));
        scoreNumber.setFont(scoreNumber.getFont ().deriveFont (18.0f));
        
        JPanel scorePanel = new JPanel();
        Dimension scoreSize = new Dimension(200, 28);
        scorePanel.setPreferredSize(scoreSize);
        scorePanel.setLayout(new FlowLayout());
        scorePanel.add(score);
        scorePanel.add(scoreNumber);
        
        JLabel life1 = new JLabel();
        JLabel life2 = new JLabel();
        JLabel life3 = new JLabel();
        
        life1.setIcon(new javax.swing.ImageIcon("/Users/marinastoebner/Documents/Northeastern/NUSpring2015/Human Computer Interaction/PianoGameImages/musicNote.png")); // NOI18N
        life2.setIcon(new javax.swing.ImageIcon("/Users/marinastoebner/Documents/Northeastern/NUSpring2015/Human Computer Interaction/PianoGameImages/musicNote.png")); // NOI18N
        life3.setIcon(new javax.swing.ImageIcon("/Users/marinastoebner/Documents/Northeastern/NUSpring2015/Human Computer Interaction/PianoGameImages/musicNote.png")); // NOI18N

        JPanel lifesPanel = new JPanel();
        Dimension lifesSize = new Dimension(150, 50);
        lifesPanel.setPreferredSize(lifesSize);
        lifesPanel.add(life1);
        lifesPanel.add(life2);
        lifesPanel.add(life3);
        
        Dimension marginSize = new Dimension(200, 480);
        JPanel leftMargin = new JPanel();
        leftMargin.setPreferredSize(marginSize);
        leftMargin.setMaximumSize(marginSize);
        leftMargin.setMinimumSize(marginSize);
        
        JPanel rightMargin = new JPanel();
        rightMargin.setPreferredSize(marginSize);
        rightMargin.setMaximumSize(marginSize);
        rightMargin.setMinimumSize(marginSize);
        
        gameWindow.add(leftMargin, BorderLayout.WEST);
        gameWindow.add(rightMargin, BorderLayout.EAST);
        
        road = new RoadView();
        Dimension roadSize = new Dimension(420, 480);
        road.setPreferredSize(roadSize);
        road.setMaximumSize(roadSize);
        road.setMinimumSize(roadSize);
        
        gameWindow.add(road, BorderLayout.CENTER);
        
        settings = new SettingsView();
        rightMargin.add(settings);
        leftMargin.add(lifesPanel);
        leftMargin.add(scorePanel);
        
        
    }
    
    public final void makePianoVisualization() {
        /*
            Creates the piano visualization
        */
        pianoVisualization = new JPanel();
        Dimension pianoSize = new Dimension(684, 92);
        pianoVisualization.setSize(pianoSize);
        pianoVisualization.setPreferredSize(pianoSize);
        pianoVisualization.setMaximumSize(pianoSize);
        pianoVisualization.setMinimumSize(pianoSize);
        
        
        piano = new PianoView();
        
//        if (controller.getCurrentMode() == MIDI_KEYBOARD) {
//            piano = new PianoView();
//        }
//        else {
//            piano = new PianoView(controller.getCurrentMode());
//        }

        piano.setMinimumSize(pianoSize);
        pianoVisualization.setLayout(new BorderLayout());
        pianoVisualization.add(piano, BorderLayout.CENTER);
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
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.PAGE_AXIS));
        buttons.add(resume);
        buttons.add(restart);
        buttons.add(endGame);
        pauseMenu.add(buttons, BorderLayout.CENTER);
        
        resume.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                hidePauseMenu();
            }
            
        });
        
        endGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showEndGameMenu();
            }
        }) ;
        
        pauseMenu.setPreferredSize(new Dimension(400, 400));
        pauseMenu.setLocation(new Point(200, 200));
        pauseMenu.setVisible(false);
    }
    
    public boolean isPauseMenuVisible() {
        return pauseMenu.isVisible();
    }
    
    public void showPauseMenu() {
        /*
            Replaces the road view with the pause menu
        */
        gameWindow.add(pauseMenu, BorderLayout.CENTER);
        //road.setVisible(false);
        pauseMenu.setVisible(true);
    }
    
    public void hidePauseMenu() {
        /*
            Replaces the pause menu with the road view
        */
        gameWindow.add(road, BorderLayout.CENTER);
        pauseMenu.setVisible(false);
        //road.setVisible(true);
    }
    
    public void makeEndGameMenu() {
        /*
            Creates the JPanel that will appear when either the users selects
            "End Game" from the pause menu, or the user runs out of lives.
        
            This allows the user to either play again or exit to the main menu.
            Also displays the final score.
        */
        endGameMenu = new JPanel();
        JButton playAgain = new JButton("Play Again");
        JButton backToMenu = new JButton("Back To Menu");
        
        backToMenu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        endGameMenu.setLayout(new BoxLayout(endGameMenu, BoxLayout.PAGE_AXIS));
        endGameMenu.add(playAgain);
        endGameMenu.add(backToMenu);
        
        endGameMenu.setVisible(false);
        
        gameWindow.add(endGameMenu, BorderLayout.CENTER);
    }
    
    public void showEndGameMenu() {
        /*
            Replaces the pause menu with the endGameMenu
        */
//        gameWindow.add(endGameMenu, BorderLayout.CENTER);
        pauseMenu.setVisible(false);
        endGameMenu.setVisible(true);
    }
    
    public void hideEndGameMenu() {
        /*
            Hides the endGameMenu
        */
        endGameMenu.setVisible(false);
    }
    
    /*
        Private variables. DO NOT MODIFY.
    */
    private JPanel gameWindow;
    private JPanel pianoVisualization;
    private JPanel pauseMenu;
    private JPanel endGameMenu;
    private RoadView road;
    private PianoView piano;
    private SettingsView settings;
    private Player player;
}
