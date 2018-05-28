package view;

import javax.swing.*;
import java.awt.*;

public class CustomJPanel extends JPanel {

    private Image map;

    /**
     * CONSTRUCTOR
     */
    public CustomJPanel(Image map) {
        this.map = map;
    }

    /**
     * METHODS
     */
    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);

        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 13; y++) {
                g.drawImage(map,x*32,y*32,32,32,this);
            }
        }
    }
}
