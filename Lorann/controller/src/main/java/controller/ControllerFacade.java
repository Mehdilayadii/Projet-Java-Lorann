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
     */
    //
    public void play(){

        // ATTRIBUTE //
        Point spell_position = new Point(0,0);
        Point player_facing_during_casting = new Point(0,0);
        Point spell_move = new Point(0,0);
        Point player_move = new Point(0,0);
        boolean player_casting_spell = false;
        boolean spell_is_alive = false;

        Events event = new Events(model, view,player_move.x, player_move.y);

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
                    event.setFuture_player(player_move.x, player_move.y);
                    if (event.isGameEnd() == true) { // Player die
                        game_loop = false;
                    }
                    else if (event.playerCanReach()) { // Moving player
                        model.movePlayer(player_move.x,player_move.y);
                    }

                    spell_is_alive = model.spellAlive();
                    if ((spell_is_alive == true) && (model.getSpellLocation().x == model.getPlayerLocation().x) && (model.getSpellLocation().y == model.getPlayerLocation().y)) {
                        model.deleteSpell();
                        model.createElement(model.getPlayerLocation().x,model.getPlayerLocation().y,Types.PLAYER);
                        spell_is_alive = false;
                    }
                    model.moveEnemies(AIDeplacement.moveAI(model)); // Moving demons
                    if ((spell_is_alive == true) && model.isThereEnemy(model.getSpellLocation().x,model.getSpellLocation().y)) {
                        model.killEnemy(model.getSpellLocation().x,model.getSpellLocation().y);
                        model.deleteSpell();
                        spell_is_alive = false;
                    }

                    // Spell //   
                    spell_is_alive = model.spellAlive();
                    player_casting_spell = view.return_casting_player(); // is player casting ?
                    if ((player_casting_spell == true) && (spell_is_alive == false)) { // Player is able to cast spell
                        spell_move.x = player_facing_during_casting.x;
                        spell_move.y = player_facing_during_casting.y;
                        if ((event.canCreateSpell(spell_move.x, spell_move.y)) && ((spell_move.x != 0) || (spell_move.y != 0))) { // player have facing
                            model.createElement(spell_move.x, spell_move.y,Types.SPELL); // Create spell
                        }
                    }
                    
                    if (spell_is_alive == true) { // spell exist
                        event.setFuture_spell(spell_move.x, spell_move.y); // update spell location
                        if (event.spellCanReach() == true) { // there is void (can move)
                            model.moveSpell(spell_move.x, spell_move.y); // moving spell
                        }
                        else if (event.spellCanReach() == false) { // there is an obstacle
                            spell_move.x = - spell_move.x; // spell rebound (x)
                            spell_move.y = - spell_move.y; // spell rebound (y)
                        }

                    }
                    spell_is_alive = model.spellAlive();
                    if ((spell_is_alive == true) && (model.getSpellLocation().x == model.getPlayerLocation().x) && (model.getSpellLocation().y == model.getPlayerLocation().y)) {
                        model.deleteSpell();
                        model.createElement(model.getPlayerLocation().x,model.getPlayerLocation().y,Types.PLAYER);
                        spell_is_alive = false;
                    }
                    if ((spell_is_alive == true) && model.isThereEnemy(model.getSpellLocation().x,model.getSpellLocation().y)) {
                        model.killEnemy(model.getSpellLocation().x,model.getSpellLocation().y);
                        model.deleteSpell();
                        spell_is_alive = false;
                    }

                    for (int x= 0; x <= 99; x++) {
                        try {
                            Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe https://giphy.com/gifs/dancing-troll-amxLHEPgGDCKs");
                        } catch (IOException e) {
                            e.printStackTrace();
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
