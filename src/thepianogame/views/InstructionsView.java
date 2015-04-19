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
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import thepianogame.controller.MainController.CONTROL_MODE;

public class InstructionsView extends JDialog {
    
    public InstructionsView(CONTROL_MODE controlMode) {
        initComponents();
        addInstructionsToDialog();
        this.controlMode = controlMode;
    }
    
    public final void initComponents() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(650, 600));
        setLocation(new Point(120, 100));
        setAlwaysOnTop(true);
        pack();
        setModal(true);
        
        instructionsContainer = new JTabbedPane();
        add(instructionsContainer, BorderLayout.CENTER);
    }
    
    public final void addInstructionsToDialog() {
        ArrayList<String> instructions = getInstructions();
        back = new JButton("Back");
        next = new JButton("Next");
        finish = new JButton("Finish");
        JPanel buttons = new JPanel();
        try {
        for (int i=0;i<instructions.size();i++) {
            JLabel instruction = new JLabel();
            instruction.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream(instructions.get(i)))));
            instruction.setHorizontalAlignment(SwingConstants.CENTER);
            JPanel container = new JPanel();
            container.setLayout(new BorderLayout());
            container.add(instruction, BorderLayout.CENTER);
            int tabIndex = i + 1;
            
            instructionsContainer.addTab(tabIndex + "", null, container, null);
        }
        
        buttons.setLayout(new GridLayout(1, 2));
        buttons.add(back);
        buttons.add(next);
        back.setEnabled(false);
        
        add(buttons, BorderLayout.SOUTH);
        
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = instructionsContainer.getSelectedIndex();
                JTabbedPane ic = instructionsContainer;
                if(index == ic.getTabCount() - 2) {
                     next.setText("Finish");
                     ic.setSelectedIndex(index + 1);
                } 
                else if (index == ic.getTabCount() - 1) {
                    setVisible(false);
                }
                else {
                    back.setEnabled(true);
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
                    back.setEnabled(false);
                } else {
                    ic.setSelectedIndex(index - 1);
                }  
            }
        });
    }
    catch (IOException e) {
        e.printStackTrace();
    }
    }
    
    public ArrayList<String> getInstructions() {
        ArrayList<String> instructions = new ArrayList();
        
        String i1 = "/thepianogame/resources/pressPlay.png";
        String i2 = "/thepianogame/resources/startGame.png";
        String i3 = "/thepianogame/resources/correct.png";
        String i4 = "/thepianogame/resources/incorrect.png";
        String i5 = "/thepianogame/resources/pauseGame.png";
        String i6 = "/thepianogame/resources/tempo.png";
        String i7 = "/thepianogame/resources/majorChords.png";
        String i8 = "/thepianogame/resources/minorChords.png";
        String i9 = "/thepianogame/resources/diminishedChords.png";
       
        instructions.add(i1);
        instructions.add(i2);
        instructions.add(i3);
        instructions.add(i4);
        instructions.add(i5);
        instructions.add(i6);
        instructions.add(i7);
        instructions.add(i8);
        instructions.add(i9);
        
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
    private JButton finish;
}
