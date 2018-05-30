package view;

import javax.swing.*;
import java.awt.*;

public class CustomJPanel extends JPanel {

    private Image map[][];
    private String score = "SCORE : ";
    /**
     * CONSTRUCTOR
     */
    public CustomJPanel(Image map[][]) {
        this.map = map;
        this.setBackground(Color.BLACK);
    }

    /**
     * GETTERS and SETTERS
     */
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = "SCORE : "+score;
    }

    /**
     * METHODS
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[0].length; y++) {
                g.drawImage(map[x][y],x*32,y*32,32,32,null);
            }
        }
        Font fonte = new Font(" TimesRoman ",Font.BOLD,30);
        g.setFont(fonte);
        g.setColor(Color.WHITE);
        g.drawString(score,10,this.getHeight()-10);
    }
}
