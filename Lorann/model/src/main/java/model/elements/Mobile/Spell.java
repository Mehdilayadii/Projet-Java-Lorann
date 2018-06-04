package model.elements.Mobile;

import model.elements.ElementsList;
import model.Types;

import java.awt.*;

public class Spell extends Mobile{

	/** the direction*/
    private Point direction;
    
    /** the animate number*/
    int animationNumber = 8;

    /**** CONSTRUCTOR ****/
    
    /**
     * Initiate a spell
     * @param stringStyle the string style (example : "L1" corresponds to the player)
     * @param x X coordinate
     * @param y Y coordinate
     * @param direction the direction
     */
    public Spell(String stringStyle, int x, int y, Point direction) {
        super(stringStyle,Types.SPELL,x,y);
        this.direction = direction;
    }

    /**** GETTERS and SETTERS ****/
    
    /**
     * Get the direction
     * @return the direction
     */
    public Point getDirection() {
        return direction;
    }
    
    /**
     * Set the direction
     * @param direction the direction
     */
    public void setDirection(Point direction) {
        this.direction = direction;
    }

    /**** METHODS ****/
    
    /**
     * Animate a sprite
     * @see model.elements.ElementsList#getImage()
     * - Get the image
     * @see model.elements.ElementsList#getCharacter()
     * - Get the character
     */
    public void animate() {
        if (animationNumber < 12){
            this.sprite = ElementsList.values()[animationNumber].getImage();
            this.stringStyle = ElementsList.values()[animationNumber].getCharacter();
            animationNumber++;

        }
        else {
            this.sprite = ElementsList.values()[animationNumber].getImage();
            this.stringStyle = ElementsList.values()[animationNumber].getCharacter();
            animationNumber = 8;
        }
    }
}
