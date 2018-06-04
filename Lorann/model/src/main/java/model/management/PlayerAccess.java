package model.management;

import model.MapModel;
import model.elements.Mobile.Player;

public class PlayerAccess {

    private MapModel map;

    //CONSTRUCTOR//
    public PlayerAccess(MapModel map) {
        this.map = map;
    }

    //METHODS//
    /**
     * Move player
     * @see model.MapModel#getPlayer()
     * - Get infos about player
     * @see model.elements.Mobile.Mobile#getLocation()
     * - Get location of an element
     * @see model.elements.Mobile.Mobile#setLocation(int ,int)
     * - Set location of an element
     * @see model.MapModel#moveElement(int oldX, int oldY, int newX, int newY)
     * - Move element from current coordinate to new ones
     * @param moveX Relative direction in X coordinate
     * @param moveY Relative direction in Y coordinate
     *
     */
    public void movePlayer(int moveX, int moveY) {
        int newX = map.getPlayer().getLocation().x + moveX;
        int newY = map.getPlayer().getLocation().y - moveY;

        map.moveElement(map.getPlayer().getLocation().x,map.getPlayer().getLocation().y,newX,newY);
        map.getPlayer().setLocation(newX,newY);
    }

    /**
     * Create the player at a special location.
     * @param x spawn location
     * @param y spawn location
     */
    public void createPlayer(int x, int y) {
        Player player = new Player("L1",x,y);
        map.setPlayer(player);
        map.addElement(player,x,y);
    }
}
