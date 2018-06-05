package view;

import java.awt.*;

/**
 * <h1>The Interface IView.</h1>
 *
 * @author Group 13
 * @version 2.0
 */

public interface IView {

	/** refresh the window */
    void showElements();
    /** print message on screen */
    void displayMessage(String message);
    /** get player location */
    Point return_deplacement_player();
    /** check if player is casting spell */
    boolean return_casting_player();

    /** set score */
    void setScore(int score);
    /** get score */
    int getScore();
    /** set the array of image */
    void setImageMap(Image[][] map);
    /** update (observable */
	void update();
}
