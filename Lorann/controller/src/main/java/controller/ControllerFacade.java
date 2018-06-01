package controller;

import java.awt.*;

import java.sql.SQLException;

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

        // ATTRIBUTE //
        Point spell_position = new Point(0,0);
        Point player_facing_during_casting = new Point(0,0);
        Point player_move = new Point(0,0);
        boolean player_casting_spell = false;
        boolean spell_is_alive = false;

        Management management = new Management(model, view, player_move.x, player_move.y);

     // GAME LOOP //    
        try {
                while (game_loop) {

                    // Loop //
                    Thread.sleep(speed);
                    spell_is_alive = model.spellAlive();

                    // Get Player Facing //
                    player_move = view.return_deplacement_player(); // get player facing
                    // Animate Sprite //
                    model.animate(player_move.x, player_move.y);

                    if ((player_move.x != 0) || (player_move.y != 0)) { // player is moving
                        if (spell_is_alive == false) { // spell not exist
                            player_facing_during_casting.x = player_move.x; // set new facing (x)
                            player_facing_during_casting.y = player_move.y; // set new facing (y)
                        }
                    }    

                    // Moving //
                    management.setFuture(player_move.x, player_move.y);
                    if (management.isGameEnd() == true) { // Player die
                        game_loop = false;
                    }
                    else if (management.playerCanReach()) { // Moving player
                        model.movePlayer(player_move.x,player_move.y);
                    }

                    model.moveEnemies(AIDeplacement.moveAI(model)); // Moving demons

                    // Spell //                    
                    player_casting_spell = view.return_casting_player(); // is player casting ?
                    if ((player_casting_spell == true) && (spell_is_alive == false) && (management.spellCanReach() == true)) { // Player is able to cast spell
                        if ((player_facing_during_casting.x != 0) || (player_facing_during_casting.y != 0)) { // player have facing
                            model.createSpell(player_facing_during_casting.x, player_facing_during_casting.y); // Create spell
                        }
                    }
                    if (spell_is_alive == true) { // spell exist
                        management.setFuture_spell(player_facing_during_casting.x, player_facing_during_casting.y); // update spell location
                        if (management.spellCanReach() == true) {
                            System.out.println(management.spellCanReach());
                            model.moveSpell(player_facing_during_casting.x, player_facing_during_casting.y); // moving spell
                        
                        }
                        else if (management.spellCanReach() == false) { // there is wall
                            player_facing_during_casting.x = - player_facing_during_casting.x; // spell rebound (x)
                            player_facing_during_casting.y = - player_facing_during_casting.y; // spell rebound (y)
                        }
                    } 
                    
                    // Refresh Screen //
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
