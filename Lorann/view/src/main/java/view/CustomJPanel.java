package view;

import javax.swing.*;
import java.awt.*;

public class CustomJPanel extends JPanel {

    private Image map[][];

    /**
     * CONSTRUCTOR
     */
    public CustomJPanel(Image map[][]) {
        this.map = map;
    }

    /**
     * METHODS
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        System.out.print("Paint component of JPanel");

        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[0].length; y++) {
                g.drawImage(map[x][y],x*32,y*32,32,32,null);
            }
        }
    }
}
