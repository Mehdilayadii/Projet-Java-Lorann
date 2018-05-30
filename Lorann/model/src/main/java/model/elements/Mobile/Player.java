package model.elements.Mobile;

import model.ElementsList;

public class Player extends Mobile{

    private int animationNumber = 0;

    /**** CONSTRUCTOR ****/
    public Player(String stringStyle,boolean isSolid, int x, int y) {
        super(stringStyle,isSolid,x,y);
    }

    /**** METHODS ****/
    public void animate (){
        if (animationNumber < 8){
            this.sprite = ElementsList.values()[animationNumber].getImage();
            animationNumber++;
        }
        else {
            animationNumber = 0;
        }
    }
}
