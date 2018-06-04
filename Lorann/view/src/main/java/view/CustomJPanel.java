package view;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class CustomJPanel extends JPanel {

	// ATTRIBUTE //
    private Image map[][];
    private String score;
    
    /**
     * CONSTRUCTOR
     */
    public CustomJPanel(Image map[][], int score) {
        this.map = map;
        this.score = "SCORE : "+(new DecimalFormat("00000").format(score));
        this.setBackground(Color.BLACK);
    }


    // GETTERS and SETTERS //
    
    /**
     * @return score
     */
    public String getScore() {
        return score;
    }

    /**
     * set score = string "Score : " + the value
     * @param String score
     */
    public void setScore(String score) {
        this.score = "SCORE : "+score;
    }

    // METHODS //
    
    /**
     * Standart graphic from swing
     * @see javax.swing.Graphics
     * @param Graphics g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[0].length; y++) {
                g.drawImage(map[x][y],x*32,y*32,32,32,null);
            }
        }
        Font fonte = new Font("Courier New",Font.BOLD,30);
        g.setFont(fonte);
        g.setColor(Color.WHITE);
        g.drawString(score,10,this.getHeight()-10);
    }
}
