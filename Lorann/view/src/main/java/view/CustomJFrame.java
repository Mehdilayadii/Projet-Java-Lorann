package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomJFrame extends JFrame implements KeyListener {

	// ATTRIBUTE //
    int move_x = 0;
    int move_y = 0; 
    Point deplacement_player = new Point(0,0);
    
    boolean casting_spell = false;

    /**
     * CONSTRUCTOR
     */
    public CustomJFrame() {

        /*Style*/
        this.setTitle("Lorann Game");
        this.setSize(660, 460);
        /*Position*/
        this.setLocationRelativeTo(null);
        /*Behavior*/
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
        
        addKeyListener(this);
        //Focus on Keyboard
        requestFocusInWindow();
    }
    
    // GETTERS and SETTERS //
    
    /**
     * @return player deplacement
     */
    public Point return_deplacement_player() {
        return deplacement_player; 
    }

    /**
     * @return if player is casting spell
     */
    public boolean return_casting_player() {
        return casting_spell; 
    }
    
    // METHODS //
    
    /**
     * Change value of deplacement_player depending on user input
     * Detect if player is casting spell (pressing space)
     * @param keycode of pressed touch
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
     * @param key pressed by player
     */
    @Override
    public void keyPressed(KeyEvent key) {
        // TODO Auto-generated method stub
        this.changing_value_deplacement(key.getKeyCode());       
    }
    
    /**
     * Event when a key is released:
     * -Change value of deplacement_player depending on user
     * -Detect if player stop casting spell (released space)
     * @see return_deplacement_player()
     * @param key released by player
     */
    @Override
    public void keyReleased(KeyEvent key) {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
    }
    
}
