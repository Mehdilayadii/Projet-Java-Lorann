package view;

import javax.swing.*;

import controller.IController;

import java.awt.*;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 */
public class ViewFacade implements IView {

    /**
     * CONSTRUCTOR
     * Instantiates a new view facade.
     */
    public ViewFacade() {
        super();

    }

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    /**** METHODS ****/
    public final void run() {
        final CustomJFrame window;
        window = new CustomJFrame();
    }
}
