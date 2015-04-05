/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CarView extends JPanel {
    
    public CarView() {
        
        BufferedImage img = null;
        try {
            String path = "/thepianogame/resources/car.png";
            img = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException ex) {
            Logger.getLogger(CarView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JLabel icon = new JLabel(new ImageIcon(img));
        add(icon);
        
        initComponents();
    }
    
    public void initComponents() {
    
    }
    
    @Override
    public final void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 200, 200, null);
    }
    
    private BufferedImage img;
}
