package model.elements.Mobile;

import model.elements.Elements;

import java.awt.*;

public class Mobile extends Elements {

    private Point location;

    /**** CONSTRUCTOR ****/
    public Mobile(String stringStyle,boolean isSolid, int x, int y) {
        super(stringStyle,isSolid);

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
