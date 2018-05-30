package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomJFrame extends JFrame implements KeyListener {

    boolean up_pressed = false;
    boolean down_pressed = false;
    boolean right_pressed = false;
    boolean left_pressed = false;

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
    
    @Override
    public void keyPressed(KeyEvent key) {
        // TODO Auto-generated method stub
        int keyCode = key.getKeyCode();

                    // DETECTE LES TOUCHES PRESSES
            switch (keyCode)
            {
                case KeyEvent.VK_UP: // UP
                    up_pressed = true;
                    break;
                case KeyEvent.VK_DOWN: // DOWN
                    down_pressed = true;
                    break;
                case KeyEvent.VK_RIGHT: // RIGHT
                    right_pressed = true;
                    break;
                case KeyEvent.VK_LEFT: // LEFT
                    left_pressed = true;
                    break;
            }

                    // AFFICHE LA DIRECTION //
            
            // UP //
            if (up_pressed == true) {
                //diagonal droite
                if ((right_pressed == true) && (left_pressed == false)) {
                    System.out.println("Diagonal UP-RIGHT");
                }

                //diagonal gauche
                else if ((left_pressed == true) && (right_pressed == false)) {
                    System.out.println("Diagonal UP-LEFT");
                }
                //up
                else {
                    System.out.println("UP");
                }
            }

            // DOWN //
                //diagonal droite
            if (down_pressed == true) {
                if ((right_pressed == true) && (left_pressed == false)) {
                    System.out.println("Diagonal DOWN-RIGHT");
                }
                //diagonal gauche
                else if ((left_pressed == true) && (right_pressed == false)) {
                    System.out.println("Diagonal DOWN-LEFT");
                }
                //down
                else {
                    System.out.println("DOWN");
                }
            }

            // RIGHT //
            if (right_pressed == true) {
                if ((up_pressed == false) && (down_pressed == false)) {
                    System.out.println("RIGHT");
                }
            }

            // LEFT //
            if (left_pressed == true) {
                if ((up_pressed == false) && (down_pressed == false)) {
                    System.out.println("LEFT");
                }
            } 
    }
    
    @Override
    public void keyReleased(KeyEvent key) {
        // TODO Auto-generated method stub
        int keyCode = key.getKeyCode();

                    // DETECTE LES TOUCHES PRESSES
            switch (keyCode)
            {
                case KeyEvent.VK_UP: // UP
                    up_pressed = false;
                    break;
                case KeyEvent.VK_DOWN: // DOWN
                    down_pressed = false;
                    break;
                case KeyEvent.VK_RIGHT: // RIGHT
                    right_pressed = false;
                    break;
                case KeyEvent.VK_LEFT: // LEFT
                    left_pressed = false;
                    break;
            }
    }

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
