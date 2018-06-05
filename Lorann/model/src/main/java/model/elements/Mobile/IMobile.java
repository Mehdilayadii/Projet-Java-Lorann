package model.elements.Mobile;

import model.elements.IElements;

import java.awt.*;

/**
 * <h1>The Class Mobile.</h1>
 *
 * @author Group 13
 * @version 2.0
 */

public interface IMobile extends IElements {
	
	/** get the location */
    Point getLocation();
    /** set the location */
    void setLocation(int x, int y);
}
