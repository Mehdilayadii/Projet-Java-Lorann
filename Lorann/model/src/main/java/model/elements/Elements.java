package model.elements;

import model.IState;
import model.Sprite;
import model.State;

import java.awt.*;

public class Elements implements IState{

    protected String stringStyle;
    protected Image sprite;

    protected boolean isSolid;

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

	@Override
	public State getState() {
		
		return new State(false,false,false,false);
	}
}
