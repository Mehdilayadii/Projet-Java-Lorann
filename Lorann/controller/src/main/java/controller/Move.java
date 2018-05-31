package controller;

import model.IModel;

public abstract class Move {

    public static boolean playerCanReach(IModel model,int moveX, int moveY) {
        int futureX = model.getPlayerLocation().x+moveX;
        int futureY = model.getPlayerLocation().y-moveY;
        boolean canReach = !(model.getType(futureX,futureY).isSolid());
        return canReach;
    }



}
