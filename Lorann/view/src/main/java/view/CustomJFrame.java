package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomJFrame extends JFrame implements KeyListener {

    // Move //
    int move_x = 0;
    int move_y = 0; 
    Point deplacement_player = new Point(0,0);
    // spell //
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

    // Return player input in mainloop
    public Point return_deplacement_player() {
        return deplacement_player; 
    }

    public boolean return_casting_player() {
        return casting_spell; 
    }

    
    @Override
    public void keyPressed(KeyEvent key) {
        // TODO Auto-generated method stub
        this.changing_value_deplacement(key.getKeyCode());       
    }
    
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
    
    @Override
    public void keyTyped(KeyEvent key) {
        // TODO Auto-generated method stub
    }
}
