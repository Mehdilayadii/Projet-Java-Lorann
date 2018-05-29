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

    void loadAllSprites();
    Image getSpriteFromString(String string);
    void connectToDB();
    List<Example> getLevelByID(int id);
}
