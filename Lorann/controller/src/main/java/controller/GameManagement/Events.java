package controller.GameManagement;

import model.IModel;
import model.Types;
import view.IView;

public class Events {

    private boolean gameEnd = false;

    private IModel model;
    private IView view;

    int futureX_player;
    int futureY_player;
    
    int futureX_spell;
    int futureY_spell;

    /**** CONSTRUCTOR ****/
    public Events(IModel model, IView view,int moveX, int moveY) {

        this.model = model;
        this.view = view;

        this.futureX_player = model.getPlayerLocation().x+moveX;
        this.futureY_player = model.getPlayerLocation().y-moveY;

    }

    /**** METHODS ****/
    public boolean playerCanReach() {

        Types type = model.getType(futureX_player,futureY_player);
        boolean canReach = !(type.isSolid());

        if (type == Types.ITEM) {
            view.setScore(view.getScore()+100);
        }
        else if (model.getType(model.getPlayerLocation().x,model.getPlayerLocation().y) == Types.ENEMY) {
            view.displayMessage("Game over !");
            gameEnd = true;
        }
        else if (type == Types.MAGICAL_BALL) {
            model.createElement(0,0,Types.EXIT_DOOR);
        }
        
        playerDie();
        playerWin();
        return canReach;
    }

    public void playerDie() {
        if (model.getType(futureX_player,futureY_player).getBehavior() == -1) {
            view.displayMessage("Game over !");
            gameEnd = true;
        }
    }

    public void playerWin() {
        if (model.getType(futureX_player,futureY_player) == Types.EXIT_DOOR) {
            view.displayMessage("You finish the level !");
            gameEnd = true;
        }
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    public void setFuture_player(int moveX, int moveY) {
        this.futureX_player = model.getPlayerLocation().x + moveX;
        this.futureY_player = model.getPlayerLocation().y - moveY;
    }
    
    public void setFuture_spell(int moveX, int moveY) {
        this.futureX_spell = model.getSpellLocation().x + moveX;
        this.futureY_spell = model.getSpellLocation().y - moveY;
    }

    public boolean spellCanReach() {
        Types type = model.getType(futureX_spell,futureY_spell);
        boolean canReach_spell = true;


        if ((type == Types.ITEM) || (type.isSolid() == true) || (type == Types.MAGICAL_BALL) || (type == Types.EXIT_DOOR)) {
            canReach_spell = false;
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
