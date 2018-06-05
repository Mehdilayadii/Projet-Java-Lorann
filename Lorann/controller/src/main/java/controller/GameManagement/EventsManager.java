package controller.GameManagement;

import model.IModel;
import model.Types;
import view.IView;

import java.awt.*;


/**
 * <h1>The Class EventsManager manage event.</h1>
 *
 * @author Groupe 13
 * @version 2.0
 */


public class EventsManager {

                    /**** ATTRIBUTE ****/
	/** the model*/
    private IModel model;
    
    /** the view*/
    private IView view;
    
    /** the player's move*/
    private Point player_move;
    
    /** Events */
    public Events event;

    				/**** CONSTRUCTOR ****/
    
    /**
     * Initiate the Events Manager.
     * 
     * @param model the model
     * @param view the view
     */
    public EventsManager(IModel model, IView view) {
        this.model = model;
        this.view = view;

        this.player_move = new Point(0,0);

        this.event = new Events( model, view, player_move.x, player_move.y);
    }

    				/**** GETTERS and SETTERS ****/
  
    /**
     * Set the player movement from user inputs, it's also the player look direction.
     * 
     * @see view.IView#return_deplacement_player()
     * - Get the current deplacement
     * */
    public void setPlayer_move() {
        player_move = view.return_deplacement_player(); //
    }

    /**
     * Get the player movement.
     * 
     * @return Vector of the player movement
     */
    public Point getPlayer_move() {
        return player_move;
    }

    				/**** METHODS ****/

    /**
     * Change the player location from the user inputs.
     * Check if player finish (Die or Win) or if he can't reach the point.
     *
     * @return False if the player finish.
     *
     * @see Events#setFuture_player(int, int)
     * @see Events#playerCanReach()
     * @see Events#isGameEnd()
     */
    public boolean movePlayer() {
        event.setFuture_player(player_move.x, player_move.y);
        if (event.isGameEnd() == true) {
            return false;
        }
        else if (event.playerCanReach()) {
            model.movePlayer(player_move.x,player_move.y);
        }
        return true;
    }

    /**
     * Check if a enemy eat the player. If so make kill the good one and delete the spell.
     * 
     * @see IModel#deleteSpell()
     * @see IModel#killEnemy(int, int)
     * @return true if mob get a player
     */
    public boolean checkMobGetPlayer() {
        if (model.isThereEnemy(model.getPlayerLocation().x,model.getPlayerLocation().y)) {
            view.displayMessage("Game over !");
            return false;
        }
        return true;
    }
    
}
