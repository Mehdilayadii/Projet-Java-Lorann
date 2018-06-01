package controller;

import model.IModel;
import model.Types;
import view.IView;

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
        else if (type == Types.SPELL) {
            model.deleteSpell();    
        }
        
        playerDie();
        playerWin();
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
    
    // Spell //
    // 0 - Void
    // 1 - Obstacle
    // -1 - Demons
    // 2  - Player
    public int spellCanReach() {
        Types type = model.getType(futureX_spell,futureY_spell);
        int canReach_spell = 0;


        if ((type == Types.ITEM) || (type.isSolid() == true) || (type == Types.MAGICAL_BALL) || (type == Types.EXIT_DOOR)) {
            canReach_spell = 1;
        }
        
        if (type == Types.PLAYER) {
            canReach_spell = 2;
        }

        if (type == Types.ENEMY) {
            canReach_spell = -1;
        }
        
        return canReach_spell;
    }
    
    /*Check if we can create the spell*/
    public boolean canCreateSpell(int moveX, int moveY) {
        boolean canCreateSpell = false;
        int futureX = model.getPlayerLocation().x + moveX;
        int futureY = model.getPlayerLocation().y - moveY;
        Types spellSpawnLocationtype = model.getType(futureX,futureY);
        if ((spellSpawnLocationtype == Types.VOID) || (spellSpawnLocationtype == Types.ENEMY)) {
            canCreateSpell = true;
        }
        return canCreateSpell;
    }
}
