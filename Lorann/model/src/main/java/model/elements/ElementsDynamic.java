package model.elements;

import java.awt.*;

public class ElementsDynamic {
    private Point location;

    /**** CONSTRUCTOR ****/
    public ElementsDynamic() {
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
