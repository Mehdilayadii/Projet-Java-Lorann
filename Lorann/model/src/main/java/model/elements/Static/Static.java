package model.elements.Static;

import model.Types;
import model.elements.Elements;

/**
 * The Class Static.
 *
 * @author Groupe 13
 * @version 2.0
 */
public class Static extends Elements {

    /**** CONSTRUCTOR ****/
	
	/**
	 * Initiate a static element
	 * @param stringStyle the stringStyle (example : "L1" corresponds to the player)
	 * @param type The type 
	 */
    public Static(String stringStyle, Types type) {
        super(stringStyle,type);
    }

}