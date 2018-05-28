package view;

import javax.swing.*;

public class CustomJFrame extends JFrame {

    /**
     * CONSTRUCTOR
     */
    public CustomJFrame() {

        /*Style*/
        this.setTitle("Lorann Game");
        this.setSize(640, 416);
        /*Position*/
        this.setLocationRelativeTo(null);
        /*Behavior*/
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

}
