package controller;

import java.awt.*;

import controller.GameManagement.AIDeplacement;
import controller.GameManagement.EventsManager;
import model.IModel;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Groupe 13
 * @version 2.0
 */

public class ControllerFacade implements IController {

					/**** ATTRIBUTE ****/
    /** The view. */
    private final IView  view;
    /** The model. */
    private final IModel model;
    
    /** time in ms between refresh */
    private static final int speed = 120;
    /** game loop */
    private boolean game_loop = true;
    
    				/**** CONSTRUCTOR ****/
    /**
     * Instantiates a new controller facade.
     * @param view
     * 		the view
     * @param model
     * 		the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;

    }
    
    				/**** METHODS ****/

    /**
     * Main function: mainloop of the game
     * Handle events:
     * @see controller.GameManagement.EventsManager#setSpell_is_alive()
     * - Set the spell alive
     * @see controller.GameManagement.EventsManager#setPlayer_move()
     * - Set player's move
     * @see  controller.GameManagement.EventsManager#getPlayer_move()
     * - Get player's move
     * @see model.IModel#animate(int directionX, int directionY)
     * - Animate element
     * @see controller.GameManagement.EventsManager#setPlayer_facing_during_casting()
     * - Set player facing
     * @see controller.GameManagement.EventsManager.checkPlayerGetSpell()
     * - Check if the player pick up the spell
     * @see controller.GameManagement.EventsManager#createSpell()
     * - Create spell
     * @see controller.GameManagement.EventsManager#moveSpell()
     * - Move the spell
     * @see controller.GameManagement.EventsManager#checkMobGetSpell()
     * - Check if a enemy pick up the spell
     * @see controller.GameManagement.EventsManager#movePlayer()
     * - Change the player location from the user inputs
     * @see  view.IView#setImageMap(Image[][] map)
     * - Set image from the image map
     * @see  view.IView#showElements()
     * - Show elements
     */
    public void play() {

        /* Handle events */
        EventsManager manager = new EventsManager(model,view);

        // MAIN LOOP //
        try {
                while (game_loop) {

                    /* Set a pause (in millisecond), equivalent to the game speed (or FPS) : with 120 ms we have like 10 FPS */
                    Thread.sleep(speed);

                    /* Check if player already launch a spell */
                    manager.setSpell_is_alive();
                    /* Get the input of the user (Direction vector) */
                    manager.setPlayer_move();

                    /* Manage animation of the player and spell (if exist) */
                    model.animate(manager.getPlayer_move().x, manager.getPlayer_move().y);

                    /* Get the player looking direction */
                    manager.setPlayer_facing_during_casting();

                    
                    /* Check if the player get back his spell */
                    manager.checkPlayerGetSpell();

                    /* Move the enemies */
                    model.moveEnemies(AIDeplacement.moveAI(model));
                    game_loop = manager.checkMobGetPlayer();
                    /* Check if a mob go on a spell */
                    manager.checkMobGetSpell();

                    /* Create the spell (if player casting) */
                    manager.createSpell();
                    /* Move the spell (if exist) */
                    manager.moveSpell();

                    /* Check if the spell hit something dynamic (player or enemies) */
                    manager.checkMobGetSpell();
                    manager.checkPlayerGetSpell();
                    
                    /* Move the player and stop the game if he move in a mob/wall/exit door */
                    game_loop = manager.movePlayer();

                    /* Refresh the view */
                    view.setImageMap(getImageMap());
                    view.showElements();
                }         
        } catch(InterruptedException e)
        { e.printStackTrace(); }
       
    }
    
    /**
     * Instantiate Image and return array with the map
     * @see IModel#getSpriteFromMap(int, int)
     * - Get Sprite from the map
     * @see model.IModel#getMapSize()
     * - Get map size
     * @return imageMap
     */
    private Image[][] getImageMap() {
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
