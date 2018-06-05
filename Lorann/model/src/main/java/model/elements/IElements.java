package model.elements;

import model.Types;

import java.awt.*;

/**
 * <h1>The Class Elements.</h1>
 *
 * @author Group 13
 * @version 2.0
 */

public interface IElements {
	
	/** get style */
    String getStringStyle();
    /** get the sprite */
    Image getSprite();
    /** get the type */
    Types getType();
}
