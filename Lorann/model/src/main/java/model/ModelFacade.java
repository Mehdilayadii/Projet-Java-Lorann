package model;


import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.imageio.ImageIO;

import model.dao.ExampleDAO;
import model.dao.LorannBDDConnector;
import model.dao.ProcedureDAO;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class ModelFacade implements IModel {

    private final Sprite sprite;

    /**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
        this.sprite = new Sprite();
    }


    /**** METHODS ****/
    /*Start by getting all the sprites*/
    public void loadAllSprites() {
        sprite.LoadAllSprite();
    }

    /*Get the a specific sprite previously load*/
    public Image getSpriteFromString(String string) {
        return this.sprite.getSpriteFromString(string);
    }
    
    
    /*Connect to the database lorann */
    public void connectToDB() {
    	LorannBDDConnector conn = null;
    	try {
    		System.out.print("Trying to connect to Database :\n");
    		conn =new LorannBDDConnector();
    		System.out.print("Successfuly connected\n");
    	}
    	catch (Exception e){
    		e.printStackTrace();
    	}
    }


	@Override
	public List<Example> getLevelByID(int id) throws SQLException {
		return ProcedureDAO.getLevelByID(id);
	}

}
