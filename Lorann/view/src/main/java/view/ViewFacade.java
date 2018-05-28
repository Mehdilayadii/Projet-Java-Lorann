package view;

import javax.swing.*;

import controller.IController;

import java.awt.*;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 */
public class ViewFacade implements IView {

    private IController controller;

    /* Test purpose */
    private String map[][] =
            {       {"o","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","o"},
                    {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
                    {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
                    {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
                    {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
                    {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
                    {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
                    {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
                    {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
                    {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
                    {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
                    {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
                    {"o","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","o"}};

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

    /**** GETTERS and SETTERS ****/
    public void setController(IController controller) {
        this.controller = controller;
    }

    /**** METHODS ****/
    public final void run() {
        final CustomJFrame window;
        window = new CustomJFrame();
    }

    public void showElements() {
        new CustomJPanel();
    }
}
