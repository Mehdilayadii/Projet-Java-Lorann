package controller;

import java.awt.*;

import java.io.IOException;
import java.sql.SQLException;

import controller.GameManagement.AIDeplacement;
import controller.GameManagement.Events;
import controller.GameManagement.EventsManager;
import model.IModel;
import model.Types;
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
    
    private static final int speed = 120;
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
     * Handle events :
     * @see EventsManager
     * @see AIDeplacement
     */
    //
    public void play(){

        /*Handle events*/
        EventsManager manager = new EventsManager(model,view);

        // GAME LOOP //
        try {
                while (game_loop) {

                    /*Set a pause (in millisecond), equivalent to the game speed (or FPS) : with 120 ms we have like 10 FPS*/
                    Thread.sleep(speed);

                    if (model.isThereEnemy(model.getPlayerLocation().x,model.getPlayerLocation().y)) {
                        game_loop = false;
                    }

                    /*Check if player already launch a spell*/
                    manager.setSpell_is_alive();
                    /*Get the input of the user (Direction vector)*/
                    manager.setPlayer_move();

                    /*Manage animation of the player and spell (if exist)*/
                    model.animate(manager.getPlayer_move().x, manager.getPlayer_move().y);

                    /*Get the player looking direction*/
                    manager.setPlayer_facing_during_casting();

                    /*Move the player and stop the game if he move in a mob/wall/exit door*/
                    game_loop = manager.movePlayer();
                    /*Check if the player get back his spell*/
                    manager.checkPlayerGetSpell();

                    /*Move the enemies*/
                    model.moveEnemies(AIDeplacement.moveAI(model));
                    game_loop = manager.checkMobGetPlayer();
                    /*Check if a mob go on a spell*/
                    manager.checkMobGetSpell();

                    /*Create the spell (if player casting)*/
                    manager.createSpell();
                    /*Move the spell (if exist)*/
                    manager.moveSpell();

                    /*Check if the spell hit something dynamic (player or enemies)*/
                    manager.checkMobGetSpell();
                    manager.checkPlayerGetSpell();

                    /*Refresh the view*/
                    view.setImageMap(getImageMap());
                    view.showElements();
                }         
        } catch(InterruptedException e)
        { e.printStackTrace(); }
       
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
