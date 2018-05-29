package view;

import javax.swing.*;
import java.awt.*;

public class CustomJFrame extends JFrame {

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

    }

}
