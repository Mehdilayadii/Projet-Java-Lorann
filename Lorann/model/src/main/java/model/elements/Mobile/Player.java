package model.elements.Mobile;

import model.ElementsList;
import model.Types;

public class Player extends Mobile{

    private int animationNumber = 0;

    /**** CONSTRUCTOR ****/
    public Player(String stringStyle, int x, int y) {
        super(stringStyle,Types.PLAYER,x,y);
    }

    /**** METHODS ****/
    public void animate (){
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
}
