package view;

import javax.swing.*;

import controller.IController;

import java.awt.*;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 */
public class ViewFacade implements IView {

    private final CustomJFrame window;
    private IController controller;

    /* Test purpose */
    private String map[][] =
            {{"C","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","C"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," ","L1"," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"C","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","C"}};

    /**
     * CONSTRUCTOR
     * Instantiates a new view facade.
     */
    public ViewFacade() {
        window = new CustomJFrame();
    }

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    /**** GETTERS and SETTERS ****/
    public void setController(IController controller) {
        this.controller = controller;
    }

    /**** METHODS ****/
    public final void run() {

    }


    public void showElements() {
        window.add(new CustomJPanel(controller.MapStringToMapSprite(map)));

        window.setVisible(true);
    }
}
