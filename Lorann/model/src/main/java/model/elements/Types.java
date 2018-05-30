package model.elements;

public enum Types {
    PLAYER          (true),
    ENEMY           (true),
    SPELL           (false),
    OBSTACLE        (true),
    OBSTACLE_KILL   (true),
    ITEM            (false),
    EXIT_DOOR       (false);

    private boolean isSolid;

    /**** GETTERS and SETTERS ****/
    public boolean isSolid() {
        return isSolid;
    }

    Types(boolean isSolid) {
        this.isSolid = isSolid;
    }
}
