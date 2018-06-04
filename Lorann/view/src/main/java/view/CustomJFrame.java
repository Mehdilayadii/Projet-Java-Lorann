package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * <h1>The Class CustomJFrame get key event. </h1>
 *
 * @author Groupe 13
 * @version 2.0
 */

public class CustomJFrame extends JFrame implements KeyListener {


					/**** ATTRIBUTE ****/
	/* serialVersionUID */
	private static final long serialVersionUID = 1L;
	/* player deplacement */
    int move_x = 0;
    int move_y = 0; 
    Point deplacement_player = new Point(0,0);
    /* player casting spell */
    boolean casting_spell = false;

    				/**** CONSTRUCTOR ****/
    public CustomJFrame() {

        /* Style */
        this.setTitle("Lorann Game");
        this.setSize(660, 460);
        /* Position */
        this.setLocationRelativeTo(null);
        /* Behavior */
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* make window visible */
        this.setVisible(true);
        
        /* add KetListener */
        addKeyListener(this);
        /* Focus on keyboard */
        requestFocusInWindow();
    }
    
    				/**** GETTERS and SETTERS ****/
    /**
     * get the player deplacement
     * @return deplacement_player
     */
    public Point return_deplacement_player() {
        return deplacement_player; 
    }

    /**
     * get if player is casting_spell
     * @return casting_spell
     */
    public boolean return_casting_player() {
        return casting_spell; 
    }
    
    				/**** METHODS ****/
    
    /**
     * Change value of deplacement_player depending on user input
     * Detect if player is casting spell (pressing space)
     * @param keyCode 
     * 			keycode of pressed touch
     */
    private void changing_value_deplacement(final int keyCode) {
        switch (keyCode)
        {
            case KeyEvent.VK_UP: // UP
                deplacement_player.y = 1;
                break;
            case KeyEvent.VK_DOWN: // DOWN
                deplacement_player.y = -1;
                break;
            case KeyEvent.VK_RIGHT: // RIGHT
                deplacement_player.x = 1;
                break;
            case KeyEvent.VK_LEFT: // LEFT
                deplacement_player.x = -1;
                break;
            case KeyEvent.VK_SPACE: // SPELL
                casting_spell = true;
                break;
        }
    }

    /**
     * Event when a key is pressed
     * @see changing_value_deplacement(int)
     * @param key
     * 			key pressed by player
     */
    @Override
    public void keyPressed(KeyEvent key) {
        this.changing_value_deplacement(key.getKeyCode());       
    }
    
    /**
     * Event when a key is released:
     * -Change value of deplacement_player depending on user
     * -Detect if player stop casting spell (released space)
     * @see return_deplacement_player()
     * @param key
     * 			key released by player
     */
    @Override
    public void keyReleased(KeyEvent key) {
        int keyCode = key.getKeyCode();
        Point player_deplacement_point = new Point(0,0);
        player_deplacement_point = return_deplacement_player();
        
        switch (keyCode)
        {
            case KeyEvent.VK_UP: // UP
                if (player_deplacement_point.y == 1) {
                    deplacement_player.y = 0;
                }
                 break;
            case KeyEvent.VK_DOWN: // DOWN
                if (player_deplacement_point.y == -1) {
                    deplacement_player.y = 0;
                }
                 break;
            case KeyEvent.VK_RIGHT: // RIGHT
                if (player_deplacement_point.x == 1) {
                    deplacement_player.x = 0;
             }
                break;
            case KeyEvent.VK_LEFT: // LEFT
                if (player_deplacement_point.x == -1) {
                    deplacement_player.x = 0;
                    break;
                }
            case KeyEvent.VK_SPACE: // SPELL
                casting_spell = false;
                break;
        }

    }
     
    /**
     * Event when a key is typed
     */
    @Override
    public void keyTyped(KeyEvent key) {
    }
    
}
