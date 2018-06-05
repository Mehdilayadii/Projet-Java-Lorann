package view;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * <h1>The Class CustomJPanel create score and the map </h1>
 *
 * @author Group 13
 * @version 2.0
 */

public class CustomJPanel extends JPanel {
	
					/**** ATTRIBUTE ****/
	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;
	/** Array of the map */
    private Image map[][];
    /** The score */
    private String score;
    
    				/**** CONSTRUCTOR ****/
     /**
     * Initiate the Panel
     * @param map the map
     * @param score the score
     */
    public CustomJPanel(Image map[][], int score) {
        this.map = map;
        this.score = "SCORE : "+(new DecimalFormat("00000").format(score));
        this.setBackground(Color.BLACK);
    }


    			/**** GETTERS and SETTERS ****/
    
    /**
     * Get the score
     * @return score the score
     */
    public String getScore() {
        return score;
    }

    /**
     * Set score = string "Score : " + the value
     * @param score
     * 			player's score
     */
    public void setScore(String score) {
        this.score = "SCORE : "+score;
    }

    				/**** METHODS ****/
    
    /**
     * Standard graphic from swing
     * 
     * @param g Object of type Graphics
     * @see Graphics
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
