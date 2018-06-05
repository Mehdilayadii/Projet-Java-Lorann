package model.management;

import model.MapModel;
import model.Types;
import model.elements.Elements;
import model.elements.IElements;
import model.elements.Mobile.Enemies.IEnemy;
import model.elements.Mobile.Mobile;
import model.elements.Static.Static;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EnemiesAccess {

    private MapModel map;

    //CONSTRUCTOR//
    public EnemiesAccess(MapModel map) {
        this.map = map;
    }

    //METHODS//

    /**
     * Move enemies on the map
     * @param enemiesMove List of current enemies position
     * @see model.MapModel#getEnemies()
     * - Get current mobile elements
     * @see model.elements.Mobile.Mobile#getLocation()
     * - Get location of an element
     * @see model.elements.Mobile.Mobile#setLocation(int ,int)
     * - Set location of an element
     */
    public void moveEnemies(List<Point> enemiesMove) {
        int i = 0;

        for (Point enemyMove : enemiesMove) {
            int oldX = map.getEnemies().get(i).getLocation().x;
            int oldY = map.getEnemies().get(i).getLocation().y;

            int newX = oldX + enemyMove.x;
            int newY = oldY + enemyMove.y;

            if (isThereEnemy(newX,newY) == false) {
                map.moveElement(oldX,oldY,newX,newY);
                map.getEnemies().get(i).setLocation(newX,newY);
            }

            i++;
        }
    }

    /**
     * Get Enemies location
     * @see model.MapModel#getEnemies()
     * - Get current mobile elements
     * @return list of points of enemies locations
     */
    public List<Point> getEnemiesLocation() {

        List<Point> enemiesLocations = new ArrayList<>();
        List<IEnemy> enemies = map.getEnemies();

        for(IEnemy enemy : enemies) {
            enemiesLocations.add(enemy.getLocation());
        }
        return enemiesLocations;
    }

    /**
     * Kill a specific enemy
     * @see model.MapModel#getEnemies()
     * - Get current mobile elements
     * @see model.ModelFacade#getEnemiesLocation()
     * - Get current enemies positions
     * @see model.MapModel#addElement(IElements, int, int)
     * - Add element at specific position
     * @param x coordinate X of an enemy
     * @param y coordinate Y of an enemy
     */
    public void killEnemy(int x, int y) {
        int i = 0;
        List<Point> enemiesLocation = getEnemiesLocation();

        for (Point enemyLocation : enemiesLocation) {
            if(enemyLocation.x == x && enemyLocation.y == y) {
                map.addElement(new Static(" ", Types.VOID),x,y);
                map.getEnemies().remove(i);
            }
            i++;
        }
    }

    /**
     * Create an enemy at a special location, is used to refresh the view. Only MapModel can create new enemies.
     * @param x spawn location
     * @param y spawn location
     */
    public void createEnemy(int x, int y) {
        for (IEnemy enemyLoc : map.getEnemies()) {
            if (enemyLoc.getLocation().x == x && enemyLoc.getLocation().y == y) {
                map.addElement(enemyLoc,x,y);
            }
        }
    }

    /**
     * Check if there is enemy at specific position
     *
     * @see model.ModelFacade#getEnemiesLocation()
     * - Get current location of enemies
     *
     * @param x coordinate X
     * @param y coordinate Y
     *
     * @return false if there is no enemy at this position
     */
    public boolean isThereEnemy(int x,int y) {
        for (Point enemyLoc : getEnemiesLocation()) {
            if (enemyLoc.x == x && enemyLoc.y == y) {
                return true;
            }
        }
        return false;
    }
}
