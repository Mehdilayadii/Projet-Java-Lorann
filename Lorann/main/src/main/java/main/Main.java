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

        final ModelFacade model = new ModelFacade();
        final ViewFacade view = new ViewFacade();
        final ControllerFacade controller = new ControllerFacade(view, model);

        view.setController(controller);

        /* To move in the controller.play()*/
        controller.play();
    }

}
