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
        model.loadAllSprites();
    	//Connection to database "lorann" 
    	model.connectToDB();
    	
    	//this.getModel().getLevelByID(1);
    	//model.getLevelByID(1);
        System.out.print(model.getLevelByID(1));

    	//this.getModel().getLevelByID(1);
        /*final List<Example> examples = this.getModel().getLevelByID(1);
        final StringBuilder message = new StringBuilder();
        for (final Example example : examples) {
            message.append(example);
            message.append('\n');*/
    }

    /**
     * Main function, launch the game.
     */
    public void play() {
    }

    public Image[][] MapStringToMapSprite(String map[][]) {
        Image MapSprite[][] = new Image[map[0].length][map.length];

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                MapSprite[x][y] = model.getSpriteFromString(map[y][x]);
            }
        }
        return MapSprite;
    }
}
