package model.elements;

import model.Sprite;
import model.Types;

import java.awt.*;

/**
 * <h1>The Class Elements.</h1>
 *
 * @author Group 13
 * @version 2.0
 */

public class Elements implements IElements{

    protected String stringStyle;
    protected Image sprite;

    protected Types type;

    				/**** CONSTRUCTOR ****/
    
    /**
     * Instantiate Elements.
     * 
     * @param stringStyle Object of type String (example : "L1" corresponds to the player)
     * @param type Object of type Types
     */
    public Elements(String stringStyle, Types type) {
        this.stringStyle = stringStyle;
        this.type = type;
        sprite = Sprite.getSpriteFromString(stringStyle);
    }

    				/**** GETTERS and SETTERS ****/
    
    /**
     * Get the string style.
     * 
     * @return an object of type String : the string style
     */
    public String getStringStyle() {
        return stringStyle;
    }

    /**
     * Get the sprite.
     * 
     * @return an object of type Image : the sprite
     */
    public Image getSprite() {
        return sprite;
    }

    /**
     * Get the type.
     * 
     * @return an object of type Types : the type
     */
    public Types getType() {
        return this.type;
    }
}
