package model.elements.Mobile;

import model.elements.ElementsList;
import model.Types;

public class Player extends Mobile{

    private int animationNumber = 0;

    /**** CONSTRUCTOR ****/
    public Player(String stringStyle, int x, int y) {
        super(stringStyle,Types.PLAYER,x,y);
    }

    /**** METHODS ****/
    public void animate (int directionX, int directionY){

        if (directionX == 0 && directionY == 0) {
            if (animationNumber < 7){
                this.sprite = ElementsList.values()[animationNumber].getImage();
                this.stringStyle = ElementsList.values()[animationNumber].getCharacter();
                animationNumber++;
            }
            else {
                this.sprite = ElementsList.values()[animationNumber].getImage();
                this.stringStyle = ElementsList.values()[animationNumber].getCharacter();
                animationNumber = 0;
            }
        }
        else {
            for (int i = 0; i < 8; i++) {
                if(ElementsList.values()[i].getDirection().x == directionX && ElementsList.values()[i].getDirection().y == directionY) {
                    this.sprite = ElementsList.values()[i].getImage();
                }
            }
        }
    }
}
