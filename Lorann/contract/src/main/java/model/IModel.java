package model;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModel {

    Image getSpriteFromMap(int x,int y);
    Dimension getMapSize();

    void connectToDB();
    List<Example> getLevelByID(int id) throws SQLException;

    void animate();
    void movePlayer(int moveX, int moveY);
}
