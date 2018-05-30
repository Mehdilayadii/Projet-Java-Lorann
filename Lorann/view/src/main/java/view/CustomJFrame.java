package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class CustomJFrame extends JFrame implements KeyListener {

    int move_x = 0;
    int move_y = 0; 
    Point deplacement_player = new Point(0,0);

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
         }
         System.out.println(deplacement_player);
    }

    public Point return_deplacement_player() {
        return deplacement_player; 
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
     switch (keyCode)
     {
         case KeyEvent.VK_UP: // UP
             deplacement_player.y = 0;
             break;
         case KeyEvent.VK_DOWN: // DOWN
             deplacement_player.y = 0;
             break;
         case KeyEvent.VK_RIGHT: // RIGHT
             deplacement_player.x = 0;
             break;
         case KeyEvent.VK_LEFT: // LEFT
             deplacement_player.x = 0;
             break;
     }

    }
    
    @Override
    public void keyTyped(KeyEvent key) {
        // TODO Auto-generated method stub


    }
}
