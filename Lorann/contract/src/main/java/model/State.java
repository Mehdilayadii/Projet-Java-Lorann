package model;

public class State {

    public boolean player_deadly;
    public boolean enemy_deadly;

    public boolean isSolid;
    public boolean pickable;

    /**** CONSTRUCTOR ****/
    public State(boolean player_deadly,boolean enemy_deadly,boolean isSolid,boolean pickable) {
        this.player_deadly = player_deadly;
        this.enemy_deadly = enemy_deadly;
        this.isSolid = isSolid;
        this.pickable = pickable;
    }
}
