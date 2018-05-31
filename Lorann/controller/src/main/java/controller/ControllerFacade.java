package controller;

import java.awt.*;

import java.sql.SQLException;
import java.util.List;

import model.Example;
import model.IModel;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController {

    /** The view. */
    private final IView  view;

    /** The model. */
    private final IModel model;
    
    private static final int speed = 150;
    private boolean game_loop = true;

    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;

        try {
        this.Initialization(); 
        }catch(SQLException e) {
                e.printStackTrace();
        }
    }
    

    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }

    /**
     * Initialization :
     * Load all sprites and start the JDBC connection
     * */
    public void Initialization() throws SQLException {
     
        //Connection to database "lorann" 
        model.connectToDB();   
        }

    /**
     * Main function, launch the game.
     */
    //
    public void play(){
        Point player_deplacement_point = new Point(0,0);
        boolean player_casting_spell = false;
        try {
              while (game_loop) {
                    //Refresh screen//
                    model.animate();
                    Thread.sleep(speed);
                    // Spell //
                    player_casting_spell = view.return_casting_player();
                    if (player_casting_spell == true) {
                        System.out.println("Casting");
                    }
                    //deplacement//

                    player_deplacement_point = view.return_deplacement_player();

                    if (Move.playerCanReach(model,player_deplacement_point.x,player_deplacement_point.y)) {
                        model.movePlayer(player_deplacement_point.x,player_deplacement_point.y);
                    }
                    model.moveEnemies(AIDeplacement.moveAI(model));

                    view.showElements();
                            }         
        } catch(InterruptedException e) { e.printStackTrace();
                }
       
    }

    public Image[][] getImageMap() {

        int mapX = model.getMapSize().width;
        int mapY = model.getMapSize().height;

        Image[][] imageMap = new Image[mapX][mapY];

        for(int x=0; x < mapX; x++) {
            for (int y=0; y < mapY; y++) {
                imageMap[x][y] = model.getSpriteFromMap(x,y);
            }
        }
        return imageMap;
    }
}
