package model;

/**
 * <h1>The Interface IModel. Implement by model.ModelFacade</h1>
 *
 * @author Group 13
 * @version 2.0
 */

public enum Types {
    /*Mobile*/
    PLAYER          (false   ,0),
    ENEMY           (false   ,-1),
    SPELL           (false  ,1),

    /*Static*/
    OBSTACLE        (true   ,0),
    OBSTACLE_KILL   (true   ,-1),
    VOID            (false  ,0),

    /*Special*/
    ITEM            (false  ,0),
    MAGICAL_BALL    (false  ,0),
    EXIT_DOOR       (false  ,0);

	/** the element is solid */
    private boolean isSolid;
    
    /** the element can kill */
    /*
    -1  Player deadly
     0  Nothing
     1  Mob deadly
     */
    private int behavior;
    
					/**** CONSTRUCTOR ****/
	Types(boolean isSolid, int behavior) {
	this.isSolid = isSolid;
	this.behavior = behavior;
}

    				/**** GETTERS and SETTERS ****/
    /**
     * Get if the element is solid.
     * 
     * @return isSolid
     */
    public boolean isSolid() {
        return isSolid;
    }

    /**
     * Get if element can kill.
     * 
     * @return behavior
     */
    public int getBehavior() {
        return behavior;
    }

}
