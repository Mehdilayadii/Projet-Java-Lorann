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

    // CONSTRUCTOR //
    public Events(IModel model, IView view,int moveX, int moveY) {

        this.model = model;
        this.view = view;

        this.futureX_player = model.getPlayerLocation().x+moveX;
        this.futureY_player = model.getPlayerLocation().y-moveY;

    }

    // METHODS //

    /**
     * Check if player can reach the desired case, also handle behavior of the player with his environment :
     * - Set score if go on item
     * @see IView#setScore(int)
     * - Spawn teh exit if go on magical ball
     * @see IModel#createElement(int, int, Types)
     * - Kill the player if go on an deadly point
     * @see Events#playerDie()
     * - Finish the game if player get to the exit
     * @see Events#playerWin()
     *
     * To get the type of a case :
     * @see IModel#getType(int, int)
     *
     * @return false if the desired case is an obstacle
     */
    public boolean playerCanReach() {

        Types type = model.getType(futureX_player,futureY_player);
        boolean canReach = !(type.isSolid());

        if (type == Types.ITEM) {
            view.setScore(view.getScore()+100);
        }
        else if (type == Types.MAGICAL_BALL) {
            model.createElement(0,0,Types.EXIT_DOOR);
        }
        
        playerDie();
        playerWin();
        return canReach;
    }

    /**
     * Check if player get on a deadly case, then finish the game.
     * @see IView#displayMessage(String)
     *
     * To get the type of a case, and then its behavior:
     * @see IModel#getType(int, int)
     */
    public void playerDie() {
        if (model.getType(futureX_player,futureY_player).getBehavior() == -1) {
            view.displayMessage("Game over !");
            gameEnd = true;
        }
    }

    /**
     * Check if player get on a exit case, then finish the game.
     * @see IView#displayMessage(String)
     *
     * To get the type of a case:
     * @see IModel#getType(int, int)
     */
    public void playerWin() {
        if (model.getType(futureX_player,futureY_player) == Types.EXIT_DOOR) {
            view.displayMessage("You finish the level !");
            gameEnd = true;
        }
    }

    /**
     * Use for the controller to check if the game is end.
     * @return True if the game is end
     */
    public boolean isGameEnd() {
        return gameEnd;
    }

    /**
     * Set the player future location, in function of its actual position and the user input
     *
     * @see IModel#getPlayerLocation()
     *
     * @param moveX User input : movement in X
     * @param moveY User input : movement in Y
     */
    public void setFuture_player(int moveX, int moveY) {
        this.futureX_player = model.getPlayerLocation().x + moveX;
        this.futureY_player = model.getPlayerLocation().y - moveY;
    }

    /**
     * Set the spell future location, in function of its actual position and the user input
     *
     * @see IModel#getSpellLocation()
     *
     * @param moveX User input : movement in X
     * @param moveY User input : movement in Y
     */
    public void setFuture_spell(int moveX, int moveY) {
        this.futureX_spell = model.getSpellLocation().x + moveX;
        this.futureY_spell = model.getSpellLocation().y - moveY;
    }

    /**
     * Check if spell can reach the desired case, also handle behavior of the player with his environment :
     * - Set score if go on item
     * @see IView#setScore(int)
     * - Spawn teh exit if go on magical ball
     * @see IModel#createElement(int, int, Types)
     * - Kill the player if go on an deadly point
     * @see Events#playerDie()
     * - Finish the game if player get to the exit
     * @see Events#playerWin()
     *
     * To get the type of a case :
     * @see IModel#getType(int, int)
     *
     * @return false if the desired case is an obstacle
     */

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
