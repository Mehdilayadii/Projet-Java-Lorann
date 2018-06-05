package model.elements.Mobile;

import model.elements.IElements;

import java.awt.*;

public interface IMobile extends IElements {
    Point getLocation();
    void setLocation(int x, int y);
}
