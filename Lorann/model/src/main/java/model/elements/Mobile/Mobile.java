package model.elements.Mobile;

import model.Types;
import model.elements.Elements;

import java.awt.*;

public class Mobile extends Elements{

    protected Point location;

    /**** CONSTRUCTOR ****/
    public Mobile(String stringStyle, Types type, int x, int y) {
        super(stringStyle, type);

        this.location = new Point(x,y);
    }

    /**** GETTERS and SETTERS ****/
    public Point getLocation() {
        return location;
    }

    public void setLocation(int x, int y) {
        this.location.x = x;
        this.location.y = y;
    }
}
