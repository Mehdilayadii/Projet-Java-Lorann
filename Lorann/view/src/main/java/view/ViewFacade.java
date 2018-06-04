package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Groupe 13
 * @version 2.0
 */
public class ViewFacade implements IView {

					/**** ATTRIBUTE ****/
	/** The window */
    private final CustomJFrame window;
    /** Array with the map */
    private Image[][] map;
    /** The score */
    int score = 0;

    				/**** CONSTRUCTOR ****/
    public ViewFacade() {
        window = new CustomJFrame();
        new JFrame();  
    }

    				/**** GETTERS and SETTERS ****/
    /**
     * Set the map
     * @param map
     * 		Array of the map
     */
    public void setImageMap(Image[][] map) {
        this.map = map;
       
    }
    
    /**
     * Set the score
     * @param score
     * 		the score
     */
    public void setScore(int score) {
        this.score = score;
  
    }
    
    /**
     * Get the score
     * @return score the score
     */
    public int getScore() {
        return score;
    }
    
    				/**** METHODS ****/
     
    /**
     * Create window with message
     * @param message
     * 		String with the message
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
        window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
    }
    
    /**
     * Instantiate new Jpanel to Print elements on the screen (map + score) 
     * Refresh the window
     */
    public void showElements() {
        window.add(new CustomJPanel(map,score));
        window.revalidate();
    }
    
    /**
     * @return Point (X,Y) which is user order input 
     * @see view.CustomJFrame#return_deplacement_player()
     * - Get the player deplacement
     */
    public Point return_deplacement_player() {
    	return window.return_deplacement_player();
    }
    
    /**
     * @return boolean to check if player is casting spell 
     * @see view.CustomJFrame#return_casting_player()
     * - Get true if a player is casting a spell
     */
    public boolean return_casting_player() {
    	return window.return_casting_player();
    }
}
