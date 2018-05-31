package model;

public enum Types {
    /*Mobile*/
    PLAYER          (false   ,0),
    ENEMY           (true   ,-1),
    SPELL           (false  ,1),

    /*Static*/
    OBSTACLE        (true   ,0),
    OBSTACLE_KILL   (true   ,-1),
    VOID            (false  ,0),

    /*Special*/
    ITEM            (false  ,0),
    EXIT_DOOR       (false  ,0);

    private boolean isSolid;
    /*
    -1  Player deadly
     0  Nothing
     1  Mob deadly
     */
    private int behavior;

    /**** GETTERS and SETTERS ****/
    public boolean isSolid() {
        return isSolid;
    }

    /**** CONSTRUCTOR ****/
    Types(boolean isSolid, int behavior) {
        this.isSolid = isSolid;
        this.behavior = behavior;
    }
}
