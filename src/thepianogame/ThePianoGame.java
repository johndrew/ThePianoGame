/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame;

import java.awt.Dimension;
import thepianogame.controller.MainController;

public class ThePianoGame {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainController controller = new MainController();
                controller.setPreferredSize(new Dimension(800, 700));
                controller.pack();
                controller.setVisible(true);
            }
        });
    }
    
}
