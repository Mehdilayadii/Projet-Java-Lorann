package controller;

import model.IModel;
import model.State;

public abstract class Move {
	
	 private final IModel model;
	
	 public Move(IModel model) {
		 this.model=model;
	 }
    /* Check if reachable */
    public boolean isNotReachable(int x,int y) {
    	State state = model.getState(x,y);
        return state.isSolid;
    }
    
    public boolean isPlayerDeadly(int x,int y) {
    	State state = model.getState(x,y);
        return state.player_deadly;
    }
    
    public boolean isEnnemyDeadly(int x,int y) {
    	State state = model.getState(x,y);
        return state.enemy_deadly;
    }
    
    public boolean isItem(int x,int y) {
    	State state = model.getState(x,y);
        return state.pickable;
    }
    
    
    
    
}
