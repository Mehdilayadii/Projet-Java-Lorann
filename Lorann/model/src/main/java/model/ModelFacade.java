package model;


import java.awt.*;
import java.sql.SQLException;
import java.util.List;

import model.dao.ImportLevel;
import model.dao.LorannBDDConnector;
import model.dao.ProcedureDAO;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class ModelFacade implements IModel {

    private MapModel map;

    /**
     * Instantiates a new model facade.
     * @throws SQLException 
     */
    public ModelFacade()  {
        Sprite.LoadAllSprite();
        this.map = new MapModel(ImportLevel.CreateMap(this));
        
    }

    /**** GETTERS and SETTERS ****/
    public Image getSpriteFromMap(int x,int y) {
        return map.getMap()[x][y].getSprite();
    }

    public Dimension getMapSize() {
        return new Dimension(map.getMap().length,map.getMap()[0].length);
    }

    /**** METHODS ****/
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
