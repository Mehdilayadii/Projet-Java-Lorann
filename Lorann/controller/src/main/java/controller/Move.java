package controller;

import model.IModel;
import model.Types;

public abstract class Move {

    public static boolean playerCanReach(IModel model,int moveX, int moveY) {
        int futureX = model.getPlayerLocation().x+moveX;
        int futureY = model.getPlayerLocation().y-moveY;

        Types type = model.getType(futureX,futureY);
        boolean canReach = !(type.isSolid());

        return canReach;
    }

    public static boolean playerDie(IModel model,int moveX, int moveY) {
        boolean playerDie = false;
        int futureX = model.getPlayerLocation().x+moveX;
        int futureY = model.getPlayerLocation().y-moveY;

        if (model.getType(futureX,futureY).getBehavior() == -1) {
            playerDie = true;
        }

        return playerDie;
    }
}
