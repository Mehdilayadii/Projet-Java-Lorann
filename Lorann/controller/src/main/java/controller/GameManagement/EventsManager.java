package controller.GameManagement;

import model.IModel;
import model.Types;
import view.IView;

import java.awt.*;

public class EventsManager {

    private IModel model;
    private IView view;

    private boolean game_loop = true;

    private Point spell_position;
    private Point player_facing_during_casting;
    private Point spell_move;
    private Point player_move;
    private boolean player_casting_spell;
    private boolean spell_is_alive;

    public Events event;

    // CONSTRUCTOR //
    public EventsManager(IModel model, IView view) {
        this.model = model;
        this.view = view;

        this.spell_position = new Point(0,0);
        this.player_facing_during_casting = new Point(0,0);
        this.spell_move = new Point(0,0);
        this.player_move = new Point(0,0);
        this.player_casting_spell = false;
        this.spell_is_alive = false;

        this.event = new Events( model, view, player_move.x, player_move.y);
    }
    /**
     * This constructor is used for the class Events only.
     */
    public EventsManager() {
    }

    // GETTERS and SETTERS //
    public IModel getModel() {
        return model;
    }
    public IView getView() {
        return view;
    }

    /**
     * Set the spell state
     * Player state is a boolean :
     * @see model.IModel#spellAlive();
     */
    public void setSpell_is_alive(){
        spell_is_alive = model.spellAlive();
    }

    /**
     * Set the player movement from user inputs, it's also the player look direction.
     * @see view.IView#return_deplacement_player()
     * */
    public void setPlayer_move() {
        player_move = view.return_deplacement_player(); //
    }

    public Point getPlayer_move() {
        return player_move;
    }

    // METHODS //

    /**
     * Animate all animated elements :
     * - PLayer
     * - Spell
     *
     * @see model.IModel#animate(int, int)
     */
    public void animateSprites() {
        model.animate(player_move.x, player_move.y);
    }

    /**
     * Get the direction of the player.
     */
    public void setPlayer_facing_during_casting() {
        if ((player_move.x != 0) || (player_move.y != 0)) { // player is moving
            if (spell_is_alive == false) { // spell not exist
                player_facing_during_casting.x = player_move.x; // set new facing (x)
                player_facing_during_casting.y = player_move.y; // set new facing (y)
            }
        }
    }

    /**
     * Change the player location from the user inputs.
     * Check if player finish (Die or Win) or if he can't reach the point.
     *
     * @return False if the player finish.
     *
     * @see Events#playerCanReach()
     * @see Events#isGameEnd()
     */
    public boolean movePlayer() {
        event.setFuture_player(player_move.x, player_move.y);
        if (event.isGameEnd() == true) {
            game_loop = false;
            return false;
        }
        else if (event.playerCanReach()) {
            model.movePlayer(player_move.x,player_move.y);
        }
        return true;
    }

    /**
     * Check if the player pick up the spell. If so make sure that the player haven't been erase by the spell.
     */
    public void checkPlayerGetSpell() {
        setSpell_is_alive();
        if ((spell_is_alive == true) && (model.getSpellLocation().x == model.getPlayerLocation().x) && (model.getSpellLocation().y == model.getPlayerLocation().y)) {
            model.deleteSpell();
            model.createElement(model.getPlayerLocation().x,model.getPlayerLocation().y,Types.PLAYER);
        }
    }

    public void checkMobGetSpell() {
        setSpell_is_alive();
        if ((spell_is_alive == true) && model.isThereEnemy(model.getSpellLocation().x,model.getSpellLocation().y)) {
            model.killEnemy(model.getSpellLocation().x,model.getSpellLocation().y);
            model.deleteSpell();
        }
    }

    public void createSpell() {
        spell_is_alive = model.spellAlive();
        player_casting_spell = view.return_casting_player(); // is player casting ?
        if ((player_casting_spell == true) && (spell_is_alive == false)) { // Player is able to cast spell
            spell_move.x = player_facing_during_casting.x;
            spell_move.y = player_facing_during_casting.y;
            if ((event.canCreateSpell(spell_move.x, spell_move.y)) && ((spell_move.x != 0) || (spell_move.y != 0))) { // player have facing
                model.createElement(spell_move.x, spell_move.y,Types.SPELL); // Create spell
            }
        }
    }

    public void moveSpell() {
        if (spell_is_alive == true) { // spell exist
            event.setFuture_spell(spell_move.x, spell_move.y); // update spell location
            if (event.spellCanReach() == true) { // there is void (can move)
                model.moveSpell(spell_move.x, spell_move.y); // moving spell
            }
            else if (event.spellCanReach() == false) { // there is an obstacle
                spell_move.x = - spell_move.x; // spell rebound (x)
                spell_move.y = - spell_move.y; // spell rebound (y)
            }
        }
    }
/*
            //RECHECK IF SPELL EAT SOMETHING
            spell_is_alive = model.spellAlive();
            if ((spell_is_alive == true) && (model.getSpellLocation().x == model.getPlayerLocation().x) && (model.getSpellLocation().y == model.getPlayerLocation().y)) {
                model.deleteSpell();
                model.createElement(model.getPlayerLocation().x,model.getPlayerLocation().y,Types.PLAYER);
                spell_is_alive = false;
            }
            if ((spell_is_alive == true) && model.isThereEnemy(model.getSpellLocation().x,model.getSpellLocation().y)) {
                model.killEnemy(model.getSpellLocation().x,model.getSpellLocation().y);
                model.deleteSpell();
                spell_is_alive = false;
            }

            // Refresh Screen //
            view.showElements();
/*
*/
}
