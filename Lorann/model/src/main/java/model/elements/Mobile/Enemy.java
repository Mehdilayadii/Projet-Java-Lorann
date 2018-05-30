package model.elements.Mobile;

import model.IState;
import model.State;

public class Enemy extends Mobile implements IState {

    private boolean player_deadly;

    /**** CONSTRUCTOR ****/
    public Enemy(String stringStyle, int x, int y) {
        super(stringStyle,x,y);
        player_deadly = true;
    }

    /**** GETTERS and SETTERS ****/
    public State getState() {
        return new State(this.player_deadly,false,this.isSolid,false);
    }
}
