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

        Management management;

        Point player_facing = new Point(0,0);
        Point player_deplacement_point = new Point(0,0);
        boolean player_casting_spell = false;

        try {
              while (game_loop) {
                    //Refresh screen//
                    model.animate();
                    Thread.sleep(speed);
                    //deplacement//
                  player_deplacement_point = view.return_deplacement_player();
                  management = new Management(model, view, player_deplacement_point.x, player_deplacement_point.y);
                    if ((player_deplacement_point.x != 0) || (player_deplacement_point.y != 0)) {
                        player_facing.x = player_deplacement_point.x;
                        player_facing.y = player_deplacement_point.y;
                    }

                    if (management.playerDie()) {
                        view.displayMessage("Game over !");
                        game_loop = false;
                    }
                    else if (management.playerCanReach()) {
                        model.movePlayer(player_deplacement_point.x,player_deplacement_point.y);
                    }
                    model.moveEnemies(AIDeplacement.moveAI(model));

                    // Spell //
                    player_casting_spell = view.return_casting_player();
                    if (player_casting_spell == true) {
                    	if ((player_facing.x != 0) || (player_facing.y != 0)) {
	                        System.out.println("Casting:");
	                        System.out.println(player_facing);
	                        model.createSpell(player_facing.x, player_facing.y);
                    	}
                    }

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
