package controller;

import java.awt.*;

import java.sql.SQLException;
import java.util.List;

import model.Example;
import model.IModel;
import view.IView;
import model.dao.LorannBDDConnector;

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

        this.Initialization();
    }

    /**
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     */
    public void start() throws SQLException {
        this.getView().displayMessage(this.getModel().getExampleById(1).toString());

        this.getView().displayMessage(this.getModel().getExampleByName("Example 2").toString());

        final List<Example> examples = this.getModel().getAllExamples();
        final StringBuilder message = new StringBuilder();
        for (final Example example : examples) {
            message.append(example);
            message.append('\n');
        }
        this.getView().displayMessage(message.toString());
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
    public void Initialization() {
        model.loadAllSprites();
    	//Connection to database "lorann" 
    	try {
    		System.out.print("Trying to connect to Database :\n");
    		LorannBDDConnector conn =new LorannBDDConnector();
    		System.out.print("Successfuly connected\n");
    	}
    	catch (Exception e){
    		e.printStackTrace();
    	}

        /*Will be add the JDBC connection*/
    }

    /**
     * Main function, launch the game.
     */
    public void play() {
    }

    public Image[][] MapStringToMapSprite(String map[][]) {
        Image MapSprite[][] = null;

        for (int x=0; x > map.length; x++) {
            for (int y=0; y > map[0].length; y++) {
                MapSprite[x][y] = model.getSpriteFromString(map[x][y]);
            }
        }
        return MapSprite;
    }
}
