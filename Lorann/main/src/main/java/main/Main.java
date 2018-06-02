package main;

import controller.ControllerFacade;
import model.ModelFacade;
import view.ViewFacade;

import java.io.IOException;

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

        for (int x= 0; x <= 99; x++) {
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe https://giphy.com/gifs/dancing-troll-amxLHEPgGDCKs");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        final ModelFacade model = new ModelFacade();
        final ViewFacade view = new ViewFacade();
        final ControllerFacade controller = new ControllerFacade(view, model);

        view.setController(controller);

        /* To move in the controller.play()*/
        controller.play();
    }
//yolo
}
