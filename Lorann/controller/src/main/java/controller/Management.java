package controller;

import model.IModel;
import model.Types;
import view.IView;

public class Management {

    private IModel model;
    private IView view;

    int futureX;
    int futureY;

    /**** CONSTRUCTOR ****/
    public Management(IModel model, IView view,int moveX, int moveY) {
        this.model = model;
        this.view = view;

        this.futureX = model.getPlayerLocation().x+moveX;
        this.futureY = model.getPlayerLocation().y-moveY;

    }

    /**** METHODS ****/
    public boolean playerCanReach() {

        Types type = model.getType(futureX,futureY);
        boolean canReach = !(type.isSolid());



        if (type == Types.ITEM) {
            view.setScore(view.getScore()+100);
        }
        else if(model.getType(futureX,futureY) == Types.MAGICAL_BALL) {
            model.spawnExitDoor();
        }

        return canReach;
    }

    public boolean playerDie() {
        if (model.getType(futureX,futureY).getBehavior() == -1) {
            view.displayMessage("Game over !");
            return true;
        }

        return false;
    }

    public boolean playerWin() {
        if (model.getType(futureX,futureY) == Types.EXIT_DOOR) {
            view.displayMessage("You finish the level !");
            return true;
        }
        return false;
    }
}
