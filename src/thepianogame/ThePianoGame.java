/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import thepianogame.controller.MainController;

public class ThePianoGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainController controller = new MainController();
                Dimension screenSize = new Dimension(900, 715);
                controller.setPreferredSize(screenSize);
                controller.setMaximumSize(screenSize);
                controller.setMinimumSize(screenSize);
                controller.pack();
                controller.setVisible(true);
            }
        });
        
        // set up fps timers
        final int TARGET_FPS = 60;
        final long DELAY = 1000/TARGET_FPS;
        long lastTime = System.currentTimeMillis();
        int frameNo = 0;
        
        while (true) {
            
            /** do time based updating here **/
            
            // frame rate limiting
            while (System.currentTimeMillis() <= lastTime + DELAY) {
                
            }
            lastTime = System.currentTimeMillis();
            System.out.println(frameNo++);
        }
    }

}
