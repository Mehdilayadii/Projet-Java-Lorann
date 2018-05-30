package model.elements.Mobile;

import model.IState;
import model.State;

public class Spell extends Mobile implements IState {

    private boolean enemy_deadly;

    /**** CONSTRUCTOR ****/
    public Spell(String stringStyle, int x, int y) {
        super(stringStyle,x,y);
        this.enemy_deadly = true;
    }

    /**** GETTERS and SETTERS ****/
    public State getState() {
        return new State(false,this.enemy_deadly,this.isSolid,false);
    }
}
