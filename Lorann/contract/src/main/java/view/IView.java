package view;

import java.awt.*;

/**
 * <h1>The Interface IView.</h1>
 *
 * @author Groupe 13
 * @version 2.0
 */
public interface IView {

    void showElements();
    void displayMessage(String message);
    Point return_deplacement_player();
    boolean return_casting_player();

    void setScore(int score);
    int getScore();
    void setImageMap(Image[][] map);
}
