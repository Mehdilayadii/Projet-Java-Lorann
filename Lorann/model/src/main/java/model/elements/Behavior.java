package model.elements;

public enum Behavior {
    PLAYER (true),
    PLAYER_LETHAL (true),
    PLAYER_SHOOT (false),
    OBSTACLE (true),
    FINISH (false),
    ITEM (false);

    private boolean isSolid;

    Behavior(boolean isSolid) {
        this.isSolid = isSolid;
    }
}
