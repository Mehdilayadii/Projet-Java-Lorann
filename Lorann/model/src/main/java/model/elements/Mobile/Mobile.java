package model.elements.Mobile;

import model.elements.Elements;

import java.awt.*;

public class Mobile extends Elements {

    protected Point location;

    /**** CONSTRUCTOR ****/
    public Mobile(String stringStyle, int x, int y) {
        super(stringStyle);

        this.location = new Point(x,y);
        this.isSolid = true;
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
