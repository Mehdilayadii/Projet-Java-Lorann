package model.elements.Static;

import model.Types;
import model.elements.Elements;

/**
 * <h1>The Class Static.</h1>
 *
 * @author Group 13
 * @version 2.0
 */
public class Static extends Elements {

				/**** CONSTRUCTOR ****/
	
	/**
	 * Initiate a static element.
	 * 
	 * @param stringStyle the stringStyle (example : "L1" corresponds to the player)
	 * @param type The type 
	 */
    public Static(String stringStyle, Types type) {
        super(stringStyle,type);
    }

}
