/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import thepianogame.controller.MainController;

public class TitleScreenView extends JPanel {
    
    private MainController controller;
    
    public TitleScreenView(MainController controller) {
        this.controller = controller;
        
        title = new JLabel("The Piano Game");
        
        title.setFont (title.getFont ().deriveFont (64.0f));
        this.setLayout(new BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));
        this.add(title);
        this.add(makeButtons());
    }
    
    public final JPanel makeButtons() {
        /*
            Creates a JPanel to hold three buttons:
                - Start button
                - Instructions button
                - Quit button
        
            Sets their actions
        */
        JPanel buttons = new JPanel();
        JButton start = new JButton("PLAY");
        JButton instructions = new JButton("HOW TO PLAY");
        JButton quit = new JButton("QUIT");
        
        // create action listeners
        instructions.addActionListener(new ActionListener() {
     
            @Override
            public void actionPerformed(ActionEvent e) {
                instructionsDialog.setVisible(true);
            }
        
        });
        
        start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.startGame();
            }
        });
        
        quit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.closeProgram();
            }
            
        });
        
        buttons.setLayout(new GridLayout(3, 1));
        
        buttons.add(start);
        buttons.add(instructions);
        buttons.add(quit);
        
        return buttons;
    }
    
    public void setInstructionsView(InstructionsView view) {
        this.instructionsDialog = view;
        instructionsDialog.setVisible(false);
    }
    
    /*
        Private variables. DO NOT MODIFY.
    */
    private InstructionsView instructionsDialog;
    private JLabel title;
}
