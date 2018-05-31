package model.elements;

import model.Sprite;
import model.Types;

import java.awt.*;

public class Elements {

    protected String stringStyle;
    protected Image sprite;

    protected Types type;

    /**** CONSTRUCTOR ****/
    public Elements(String stringStyle, Types type) {
        this.stringStyle = stringStyle;
        this.type = type;
        sprite = Sprite.getSpriteFromString(stringStyle);
    }

    /**** GETTERS and SETTERS ****/
    public String getStringStyle() {
        return stringStyle;
    }

    public Image getSprite() {
        return sprite;
    }
}
