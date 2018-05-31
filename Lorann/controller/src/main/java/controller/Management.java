package controller;

import model.IModel;
import model.Types;
import view.IView;

public class Management {

    private IModel model;
    private IView view;

    int moveX;
    int moveY;

    /**** CONSTRUCTOR ****/
    public Management(IModel model, IView view,int moveX, int moveY) {
        this.model = model;
        this.view = view;

        this.moveX = moveX;
        this.moveY = moveY;

    }

    /**** METHODS ****/
    public boolean playerCanReach() {
        int futureX = model.getPlayerLocation().x+moveX;
        int futureY = model.getPlayerLocation().y-moveY;

        Types type = model.getType(futureX,futureY);
        boolean canReach = !(type.isSolid());

        if (type == Types.ITEM) {

        }
        else if (type == Types.EXIT_DOOR) {
            view.displayMessage("You finish the level !");
        }

        return canReach;
    }

    public boolean playerDie() {
        boolean playerDie = false;
        int futureX = model.getPlayerLocation().x+moveX;
        int futureY = model.getPlayerLocation().y-moveY;

        if (model.getType(futureX,futureY).getBehavior() == -1) {
            playerDie = true;
        }

        return playerDie;
    }
}
