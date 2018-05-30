package model.elements;

import model.IState;
import model.State;

public class Static extends Elements implements IState {

    private boolean player_deadly;

    /**** CONSTRUCTOR ****/
    public Static(String stringStyle, boolean solid, boolean player_deadly) {
        super(stringStyle);
        this.isSolid = solid;
        this.player_deadly = player_deadly;
    }

    /**** GETTERS and SETTERS ****/
    public State getState() {
        return new State(this.player_deadly,false,this.isSolid,false);
    }
}
