/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import thepianogame.controller.MainController.CONTROL_MODE;

public class InstructionsView extends JDialog {
    
    public InstructionsView(CONTROL_MODE controlMode) {
        initComponents();
        addInstructionsToDialog();
        this.controlMode = controlMode;
    }
    
    public final void initComponents() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 500));
        setLocation(new Point(100, 200));
        pack();
        setModal(true);
        
        instructionsContainer = new JTabbedPane();
        add(instructionsContainer, BorderLayout.CENTER);
    }
    
    public final void addInstructionsToDialog() {
        ArrayList<JTextArea> instructions = getInstructions();
        back = new JButton("Back");
        next = new JButton("Next");
        JPanel buttons = new JPanel();
        
        for (int i=0;i<instructions.size();i++) {
            JTextArea instruction = instructions.get(i);
            JPanel container = new JPanel();
            container.setLayout(new BorderLayout());
            container.add(instruction, BorderLayout.CENTER);
            int tabIndex = i + 1;
            
            instructionsContainer.addTab(tabIndex + "", null, container, null);
        }
        
        buttons.setLayout(new GridLayout(1, 2));
        buttons.add(back);
        buttons.add(next);
        
        add(buttons, BorderLayout.SOUTH);
        
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = instructionsContainer.getSelectedIndex();
                JTabbedPane ic = instructionsContainer;
                if(index == ic.getTabCount() - 1) {
                    ic.setSelectedIndex(0);  
                } else {
                    ic.setSelectedIndex(index + 1);
                }  
            }
        });
        
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int index = instructionsContainer.getSelectedIndex();
                JTabbedPane ic = instructionsContainer;
                if(index == 0) {
                    ic.setSelectedIndex(ic.getTabCount()-1);  
                } else {
                    ic.setSelectedIndex(index - 1);
                }  
            }
        });
    }
    
    public ArrayList<JTextArea> getInstructions() {
        ArrayList<JTextArea> instructions = new ArrayList<JTextArea>();
        JTextArea i1 = new JTextArea("You control a car driving down a road.");
        JTextArea i2 = new JTextArea("Objects with a chord label will move down "
                + "the road\n towards the car. An exclamation point will "
                + "indicate\n when one is coming.");
        JTextArea i3 = new JTextArea("Your objective is to collect these "
                + "objects by moving\n the car into the correct lane.");
        JTextArea i4 = new JTextArea("To move the car into a lane, play the "
                + "chord highlighted on the piano visualization on the "
                + "corresponding side of the piano (e.g. to move left, play "
                + "the chord on the\n left side of the piano)");
        JTextArea i5 = new JTextArea("If you don't play the correct chord in "
                + "time, the chord\n will turn red which means that you can't "
                + "get it\n anymore.");
        JTextArea i6 = new JTextArea("You will be able to adjust the spped "
                + "of the game, the difficulty level, and the key of the "
                + "chords. To make\n adjustments like these, first pause the "
                + "game by\n pressing the space bar.");
        
        JTextArea comp_key_i = new JTextArea("Since you are using a MIDI keyboard, "
                + "you can play the piano by using the computer keys. The keys "
                + "available\n for you to play will be labeled on the piano "
                + "on the\n screen once you start the game.");
        
        setFont(i1);
        setFont(i2);
        setFont(i3);
        setFont(i4);
        setFont(i5);
        setFont(i6);
        setFont(comp_key_i);
        
        i1.setLineWrap(true);
        i2.setLineWrap(true);
        i3.setLineWrap(true);
        i4.setLineWrap(true);
        i5.setLineWrap(true);
        i6.setLineWrap(true);
        comp_key_i.setLineWrap(true);
        
        i1.setBackground(null);
        i2.setBackground(null);
        i3.setBackground(null);
        i4.setBackground(null);
        i5.setBackground(null);
        i6.setBackground(null);
        comp_key_i.setBackground(null);
        
        instructions.add(i1);
        instructions.add(i2);
        instructions.add(i3);
        instructions.add(i4);
        
        // Remove this after prototype is turned in
        instructions.add(comp_key_i);
        
        instructions.add(i5);
        instructions.add(i6);
        
        return instructions;
    }
    
    public void setFont(JTextArea label) {
        Font oldFont = label.getFont();
        Font newFont = new Font(oldFont.getName(), Font.PLAIN, 18);
        
        label.setFont(newFont);
    }
    
    private JTabbedPane instructionsContainer;
    private CONTROL_MODE controlMode;
    private JButton next;
    private JButton back;
}
