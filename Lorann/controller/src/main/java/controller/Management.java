package controller;

import model.IModel;
import model.Types;
import view.IView;

import java.awt.*;
import java.util.List;

public class Management {

    private IModel model;
    private IView view;
    private boolean gameEnd = false;

    int futureX;
    int futureY;
    
    int futureX_spell;
    int futureY_spell;

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
        else if (model.getType(model.getPlayerLocation().x,model.getPlayerLocation().y) == Types.ENEMY) {
            view.displayMessage("Game over !");
            gameEnd = true;
        }
        else if (type == Types.MAGICAL_BALL) {
            model.spawnExitDoor();
        }

        return canReach;
    }

    public void playerDie() {
        if (model.getType(futureX,futureY).getBehavior() == -1) {
            view.displayMessage("Game over !");
            gameEnd = true;
        }
    }

    public void playerWin() {
        if (model.getType(futureX,futureY) == Types.EXIT_DOOR) {
            view.displayMessage("You finish the level !");
            gameEnd = true;
        }
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    public void setFuture(int moveX, int moveY) {
        this.futureX = model.getPlayerLocation().x + moveX;
        this.futureY = model.getPlayerLocation().y - moveY;
    }
    
    public void setFuture_spell(int moveX, int moveY) {
        this.futureX_spell = model.getSpellLocation().x + moveX;
        this.futureY_spell = model.getSpellLocation().y - moveY;
    }
    
	public boolean spellCanReach() {
        Types type = model.getType(futureX_spell,futureY_spell);
        boolean canReach_spell = !(type.isSolid());
        
        if (type == Types.PLAYER) {
        	model.deleteSpell();
        }
        
		return canReach_spell;
	}
}
