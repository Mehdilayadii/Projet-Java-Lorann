package view;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * <h1>The Class CustomJPanel create score and the map </h1>
 *
 * @author Groupe 13
 * @version 2.0
 */

public class CustomJPanel extends JPanel {
	
					/**** ATTRIBUTE ****/
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/* array with de map */
    private Image map[][];
    /* the score */
    private String score;
    
    				/**** CONSTRUCTOR ****/
    public CustomJPanel(Image map[][], int score) {
        this.map = map;
        this.score = "SCORE : "+(new DecimalFormat("00000").format(score));
        this.setBackground(Color.BLACK);
    }


    			/**** GETTERS and SETTERS ****/
    
    /**
     * get the score
     * @return score
     */
    public String getScore() {
        return score;
    }

    /**
     * set score = string "Score : " + the value
     * @param String score
     * 			player's score
     */
    public void setScore(String score) {
        this.score = "SCORE : "+score;
    }

    				/**** METHODS ****/
    
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
                g.drawImage(map[x][y],x*32,y*32,32,32,null); // draw the map for each element in the array
            }
        }
        Font fonte = new Font("Courier New",Font.BOLD,30);
        g.setFont(fonte);
        g.setColor(Color.WHITE);
        g.drawString(score,10,this.getHeight()-10);
    }
}
