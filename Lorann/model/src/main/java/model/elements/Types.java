package model.elements;

public enum Types {
    PLAYER (true),
    ENEMY (true),
    SPELL (false),
    OBSTACLE (true),
    OBSTACLE_KILL(true),
    ITEM (false),
    EXIT_DOOR (false);

    private boolean isSolid;

    Types(boolean isSolid) {
        this.isSolid = isSolid;
    }
}
