package model.elements.Mobile;

import model.Types;
import model.elements.Elements;

import java.awt.*;


/**
 * <h1>The Class Mobile.</h1>
 *
 * @author Groupe 13
 * @version 2.0
 */
public class Mobile extends Elements{

    protected Point location;

    /**** CONSTRUCTOR ****/
    
     /**
     * Instantiate a mobile element
     * @param stringStyle the string style (example : "L1" corresponds to the player)
     * @param type Type of the mobile element
     * @param x X coordinate 
     * @param y Y coordinate
     */
    public Mobile(String stringStyle, Types type, int x, int y){
        super(stringStyle, type);


        if ((x < 0) || (y < 0)) {
            throw new IllegalArgumentException("Negative location error");
        }
        this.location = new Point(x,y);

    }

    /**** GETTERS and SETTERS ****/
    
    /**
     * Get the location
     * @return an object of type Point : the location
     */
    public Point getLocation() {
        return location;
    }

    
    /**
     * Set the location
     * @param x X coordinate
     * @param y Y coordinate
     */
    public void setLocation(int x, int y) {
        this.location.x = x;
        this.location.y = y;
    }
}
