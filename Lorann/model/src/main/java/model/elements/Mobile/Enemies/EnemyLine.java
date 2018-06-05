package model.elements.Mobile.Enemies;

import model.Types;
import model.elements.Mobile.Mobile;

import java.awt.*;

public class EnemyLine extends Mobile implements IEnemy{

    public static int number = 0;
    private static Point behavior = new Point(0,1);

    /**** CONSTRUCTOR ****/

    /**
     * Initiate a spell
     * @param stringStyle the string style (example : "L1" corresponds to the player)
     * @param x X coordinate
     * @param y Y coordinate
     */
    public EnemyLine(String stringStyle, int x, int y) {
        super(stringStyle,Types.ENEMY,x,y);
        number++;
    }

    /**** GETTER ****/
    /**
     * Get the behavior of the enemy.
     * @return behavior
     * 1,0 for diagonal
     * 0,1 for line
     * 1,1 for all
     */
    public Point getBehavior() {
        return behavior;
    }
}
