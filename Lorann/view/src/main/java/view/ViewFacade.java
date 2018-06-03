package view;

import javax.swing.*;

import controller.IController;

import java.awt.*;
import java.awt.event.WindowEvent;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 */
public class ViewFacade implements IView {

    private final CustomJFrame window;

    private Image[][] map;
    int score = 0;

    /**
     * CONSTRUCTOR
     * Instantiates a new view facade.
     */
    public ViewFacade() {
        window = new CustomJFrame();
        for (int x=0; x<=1; x++) {
           new JFrame();
        }
    }

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
        window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
    }

    /**** GETTERS and SETTERS ****/
    public void setImageMap(Image[][] map) {
        this.map = map;
    }

    /**** METHODS ****/

    public void showElements() {
        window.add(new CustomJPanel(map,score));
        window.revalidate();
    }
    
    //Return UserInputDeplacement
    public Point return_deplacement_player() {
    	return window.return_deplacement_player();
    }
    
    // Return UserInputCastingSpell
    public boolean return_casting_player() {
    	return window.return_casting_player();
    }

    /*Set the score*/
    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }
}
