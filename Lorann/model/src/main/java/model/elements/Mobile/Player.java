package model.elements.Mobile;

import model.ElementsList;

public class Player extends Mobile{

    private int animationNumber = 0;

    /**** CONSTRUCTOR ****/
    public Player(String stringStyle, int x, int y) {
        super(stringStyle,x,y);
    }

    /**** METHODS ****/
    public void animate (){
        if (animationNumber < 8){
            this.sprite = ElementsList.values()[animationNumber].getImage();
            this.stringStyle = ElementsList.values()[animationNumber].getCharacter();
            animationNumber++;
        }
        else {
            animationNumber = 0;
        }
    }
}
