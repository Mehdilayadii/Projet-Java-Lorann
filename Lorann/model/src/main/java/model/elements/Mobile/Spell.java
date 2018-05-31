package model.elements.Mobile;

import model.ElementsList;
import model.Types;

import java.awt.*;

public class Spell extends Mobile{

    private Point direction;
    int animationNumber = 8;

    /**** CONSTRUCTOR ****/
    public Spell(String stringStyle, int x, int y, Point direction) {
        super(stringStyle,Types.SPELL,x,y);
        this.direction = direction;
    }

    /**** GETTERS and SETTERS ****/
    public Point getDirection() {
        return direction;
    }

    public void setDirection(Point direction) {
        this.direction = direction;
    }

    /**** METHODS ****/
    public void animate() {
        if (animationNumber < 12){
            this.sprite = ElementsList.values()[animationNumber].getImage();
            this.stringStyle = ElementsList.values()[animationNumber].getCharacter();
            animationNumber++;

        }
        else {
            this.sprite = ElementsList.values()[animationNumber].getImage();
            this.stringStyle = ElementsList.values()[animationNumber].getCharacter();
            animationNumber = 8;
        }
    }
}
