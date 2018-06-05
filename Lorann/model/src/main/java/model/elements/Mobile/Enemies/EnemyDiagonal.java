package model.elements.Mobile.Enemies;

import model.Types;
import model.elements.Mobile.Mobile;

import java.awt.*;

public class EnemyDiagonal extends Mobile implements IEnemy{

    public static int number = 0;
    private static int behavior = 1;

    /**** CONSTRUCTOR ****/

    /**
     * Initiate a spell
     * @param stringStyle the string style (example : "L1" corresponds to the player)
     * @param x X coordinate
     * @param y Y coordinate
     */
    public EnemyDiagonal(String stringStyle, int x, int y) {
        super(stringStyle,Types.ENEMY,x,y);
        number++;
    }

    /**** GETTER ****/
    /**
     * Get the behavior of the enemy.
     * @return behavior
     * 1 for diagonal
     * 0 for line
     * -1 for all
     */
    public int getBehavior() {
        return behavior;
    }
}
