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
     
    	//Connection to database "lorann" 
    	model.connectToDB();
    	
    	
   // Convert List<Example> to StringBuilder
        final List<Example> examples = this.getModel().getLevelByID(1);
        final StringBuilder message = new StringBuilder();
        for (final Example example : examples) {
            message.append(example);
            message.append('\n'); 
        }
        
        
        
        //Convert StringBuilder type to String type
        String test=message.toString();

        
        String[] ary = test.split("\n");
       // Store differents elements as String type
        String x; 
        String y;
        String element;
        
        //Real coordinates as integer
        int cooX;
        int cooY;
        
        //Our map
        String[][]mapV2= new String[20][12];

        for(int i=0;i<ary.length;i++){	
        	
        	 //Temporary String storing sql recording line per line
             String provisoire = ary[i];
            
              //Separe our message from database to real coordinate
            		//Example : Convert C;1;1
            		//To Element=C, X=1, Y=1
              String[] tempo = provisoire.split(";"); // Cutting String 
        	  element=tempo[0];
        	  x=tempo[1];
        	  y=tempo[2];
        	  
        	  //Convert String coordinates to integer
        	  cooX=Integer.parseInt(x); 
        	  cooY=Integer.parseInt(y);
        	  cooX-=1;
          	  cooY-=1;
          	  
        	  //Store data into our map
        	  mapV2[cooX][cooY]=element; 
        	  
        		}
        
        // Show the map //TO BE DELETED LATER
        for(int i=0;i<12;i++) {
        	System.out.print("\n");
        	for(int j=0;j<20;j++) {
        		System.out.print(mapV2[j][i]);
        	}

        }
        
        
        
        
        }

    /**
     * Main function, launch the game.
     */
    public void play() {
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
