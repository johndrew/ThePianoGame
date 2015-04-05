/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepianogame.views;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;
import thepianogame.models.Road;

public class RoadView extends JPanel {
    
    public RoadView() {
        initComponents();
    }
    
    public RoadView(Dimension roadSize) {
        this.roadSize = roadSize;
        
        initComponents();
        setPreferredSize(roadSize);
        setMaximumSize(roadSize);
        setMinimumSize(roadSize);
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(null);
        
        makeDashedCenterDivider(this);
    }
    
    public void makeDashedCenterDivider(JPanel road) {
        /*
            Draws the dashes on the road.
        */
        int numberOfDashes = 5;
        dashHeight = 58;
        int dashWidth = 20;
        gapSize = (dashHeight*2);
        int dashX = (this.roadSize.width/2) + dashWidth;
        int dashY = (dashHeight * -1) - gapSize;
        dashes = new ArrayList<Dash>();
        Dash dash;
        
        for (int i=0;i<numberOfDashes;i++) {
            dash = new Dash(dashWidth, dashHeight, dashX, dashY);
            add(dash);
            dashY += dashHeight + gapSize;
            
            dashes.add(dash);
        }
    }
    
    public void moveDashes(int amountToMove) {
        int roadHeight = this.roadSize.height;
        
        if (amountToMove < 0) {
            amountToMove *= -1;
        }
        
        for (Dash current : dashes) {
            int adjustment = current.y + amountToMove;
            
            // moves the dash to the top of the screen when it goes off
            // the bottom of the screen
            if (((current.y+amountToMove)-dashHeight) >= (roadHeight+dashHeight)) {
                int backToTop = (dashHeight*-2) - gapSize - 40;
                current.y = backToTop;
            } else {
                current.moveDash(current.x, adjustment);
                current.y = adjustment;
            }
        }
    }
    
    public void addCar(CarView car) {
        /*
            Adds the car to the roadview. Sets its initial absolute position.
        */
        add(car);
        this.car = car;
        car.setBounds(this.roadSize.width - 75, this.roadSize.height - 125, 
                100, 180);
    }
    
    public void moveCarLeft(int amountToMove) {
        /*
            Adjusts the x position of the car. Does nothing to the y position.
        */
        // ensures that no matter the input, the car will move left.
        if (amountToMove < 0) {
            amountToMove *= -1;
        }
        
        car.setBounds(car.getX() - amountToMove, car.getY(), 
                    car.getWidth(), car.getHeight());
    }
    
    public int getCarXPosition() {
        return car.getX();
    }
    
    public void moveCarRight(int amountToMove) {
        /*
            Adjusts the x position of the car. Does nothing to the y position.
        */
        // ensures that no matter the input, the car will move left.
        if (amountToMove < 0) {
            amountToMove *= -1;
        }
        car.setBounds(car.getX() + amountToMove, car.getY(), 
                car.getWidth(), car.getHeight());
    }
    
    public Dimension getRoadSize() {
        return this.roadSize;
    }
    
    private class Dash extends JPanel {
        
        public Dash(int width, int height, int x, int y) {
            this.width = width;
            this.height = height;
            this.x = x;
            this.y = y;
            
            initComponents();
        }
        
        public void initComponents() {
            setBorder(javax.swing.BorderFactory.createBevelBorder(
                    javax.swing.border.BevelBorder.RAISED));
            setBackground(Color.YELLOW);
            setPreferredSize(new Dimension(width, height));
            setBounds(x, y, width, height);
        }
        
        public void moveDash(int x, int y) {
            setBounds(x, y, width, height);
        }
        
        private int width;
        private int height;
        private int x;
        private int y;
    }
    
    private Road model;
    private Dimension roadSize;
    private CarView car;
    private ArrayList<Dash> dashes;
    private int gapSize;
    private int dashHeight;
}
