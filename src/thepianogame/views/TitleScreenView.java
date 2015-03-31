/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.views;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import thepianogame.controller.MainController;

public class TitleScreenView extends JPanel {
    
    private MainController controller;
    
    public TitleScreenView(MainController controller) {
        this.controller = controller;
        
        title = new JLabel("The Piano Game");
        instructionsDialog = makeInstructionsDialog();
        
        title.setFont (title.getFont ().deriveFont (64.0f));
        this.setLayout(new BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));
        this.add(title);
        this.add(makeButtons());
        
        instructionsDialog.setVisible(false);
    }
    
    public JPanel makeButtons() {
        JPanel buttons = new JPanel();
        JButton start = new JButton("Start");
        JButton instructions = new JButton("Instructions");
        JButton quit = new JButton("Quit");
        
        // create action listeners
        instructions.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                instructionsDialog.setVisible(true);
            }
        
        });
        
        start.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                controller.startGame();
            }
        });
        
//        buttons.setPreferredSize(new Dimension(200, 200));
        buttons.setLayout(new GridLayout(3, 1));
        
        buttons.add(start);
        buttons.add(instructions);
        buttons.add(quit);
        
        return buttons;
    }
    
    public JDialog makeInstructionsDialog() {
        JDialog dialog = new JDialog();
        JLabel instruction1 = new JLabel("This is an instruction");
        
        dialog.add(instruction1);
        dialog.setPreferredSize(new Dimension(500, 500));
        dialog.setLocation(new Point(100, 200));
        dialog.pack();
        dialog.setModal(false);
        
        return dialog;
    }
    
    private JDialog instructionsDialog;
    private JLabel title;
}
