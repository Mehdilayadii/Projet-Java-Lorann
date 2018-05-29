package model.elements;

import model.Sprite;

import java.awt.*;

public class Elements {
    private String stringStyle;
    private Image sprite;


    /**** CONSTRUCTOR ****/
    public Elements(String stringStyle) {
        this.stringStyle = stringStyle;

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
