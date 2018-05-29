package main;

import java.sql.SQLException;

import model.dao.*;
import controller.ControllerFacade;
import model.ModelFacade;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {

        /*
    	//Connection to database "lorann" 
    	try {
    		System.out.print("Trying to connect to Database :\n");
    		LorannBDDConnector conn =new LorannBDDConnector();
    		System.out.print("Successfuly connected\n");
    	}
    	catch (Exception e){
    		e.printStackTrace();
    	}
    	*/
        System.out.print(System.getProperty("user.dir"));

        final ModelFacade model = new ModelFacade();
        final ViewFacade view = new ViewFacade();
        final ControllerFacade controller = new ControllerFacade(view, model);

        view.setController(controller);

        /* To move in the controller.play()*/
        view.showElements();
    }

}
