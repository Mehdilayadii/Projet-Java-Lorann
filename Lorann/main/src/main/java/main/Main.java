package main;

import controller.ControllerFacade;
import model.ModelFacade;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Group 13
 * @version 2.0
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

        /* To move in the controller.play()*/
        controller.play();
    }
}
