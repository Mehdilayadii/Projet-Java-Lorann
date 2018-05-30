package model.elements;

import model.Sprite;

import java.awt.*;

public class Elements {

    private String stringStyle;
    protected Image sprite;

    private boolean isSolid;

    /**** CONSTRUCTOR ****/
    public Elements(String stringStyle,boolean isSolid) {
        this.stringStyle = stringStyle;
        this.isSolid = isSolid;

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
