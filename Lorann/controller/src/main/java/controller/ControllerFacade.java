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
        Point player_facing = new Point(0,0);
        Point player_deplacement_point = new Point(0,0);
        boolean player_casting_spell = false;
        boolean spell_is_alive = false;

        Management management = new Management(model, view, player_deplacement_point.x, player_deplacement_point.y);

     // GAME LOOP //    
        try {
                while (game_loop) {

                    // Animate Sprite //
                    model.animate();

                    // Loop //
                    Thread.sleep(speed);
                    spell_is_alive = model.spellAlive();

                    // Get Player Facing //
                    player_deplacement_point = view.return_deplacement_player();
                    if ((player_deplacement_point.x != 0) || (player_deplacement_point.y != 0)) {
                        if (spell_is_alive == false) {
                            player_facing.x = player_deplacement_point.x;
                            player_facing.y = player_deplacement_point.y;
                        }
                    }    

                    // Moving //
                    management.setFuture(player_deplacement_point.x, player_deplacement_point.y);
                    if (management.isGameEnd() == true) { // Player die
                        game_loop = false;
                    }
                    else if (management.playerCanReach()) { // Moving player
                        model.movePlayer(player_deplacement_point.x,player_deplacement_point.y);
                    }
                    System.out.println(management.isGameEnd());
                    model.moveEnemies(AIDeplacement.moveAI(model)); // Moving demons



                    // Spell //                    
                    player_casting_spell = view.return_casting_player(); // Casting ?
                    if ((player_casting_spell == true) && (spell_is_alive == false)) {
                        if ((player_facing.x != 0) || (player_facing.y != 0)) { // Create spell
                            model.createSpell(player_facing.x, player_facing.y);
                        }
                    }
                    if (spell_is_alive == true) { // Moving spell
                        model.moveSpell(player_facing.x, player_facing.y);
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
