package model;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Group 13
 * @version 2.0
 */
public interface IModel {

    /*Map Management --------------------------------------*/
    Image       getSpriteFromMap(int x,int y);
    Dimension   getMapSize();

    /*Database --------------------------------------------*/
    void        connectToDB();

    /*Player ----------------------------------------------*/
    /*Movement management*/
    void        movePlayer(int moveX, int moveY);
    Point       getPlayerLocation();

    /*Enemies ---------------------------------------------*/
    /*Movement management*/
    void        moveEnemies(List<Point> enemiesMove);
    List<Point> getEnemiesLocation();
    /*kill*/
    void        killEnemy(int x, int y);

    /*Spell -----------------------------------------------*/
    /*Create and delete*/
    void        deleteSpell();

    /*Movement management*/
    void        moveSpell(int moveX, int moveY);
    Point       getSpellLocation();

    /*Check if exist*/
    boolean     spellAlive();

    /*Others -----------------------------------------------*/
    void        animate(int directionX, int directionY);
    Types       getType(int x, int y);

    void createElement(int x, int y,Types type);
    boolean isThereEnemy(int x,int y);
}
