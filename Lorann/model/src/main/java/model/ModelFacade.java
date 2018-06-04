package model;


import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.ImportLevel;
import model.dao.LorannBDDConnector;
import model.dao.ProcedureDAO;
import model.elements.Mobile.Mobile;
import model.elements.Mobile.Player;
import model.elements.Mobile.Spell;
import model.elements.Static.Static;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class ModelFacade implements IModel {

    private MapModel map;
    /**
     * Instantiates a new model facade.
     * @throws SQLException 
     */
    public ModelFacade()  {
        Sprite.LoadAllSprite();
        this.map = new MapModel(ImportLevel.CreateMap(this));
    }

    // GETTERS and SETTERS //
    public Image getSpriteFromMap(int x,int y) {
        return map.getMap()[x][y].getSprite();
    }

    public Dimension getMapSize() {
        return new Dimension(map.getMap().length,map.getMap()[0].length);
    }

    // METHODS //
   /**
	 * Connect to the database lorann
	 */
    public void connectToDB() {
        LorannBDDConnector conn = null;
        try {
            System.out.print("Trying to connect to Database :\n");
            conn =new LorannBDDConnector();
            System.out.print("Successfuly connected\n");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Animate elements
     * @see model.IModel#animate(int, int)
     * @param directionX Direction in X coordinate
     * @param directionY Direction in Y coordinate
     */
    public void animate(int directionX, int directionY) {
        map.animateElements(directionX, directionY);
    }

    /*Move player*/
    public void movePlayer(int moveX, int moveY) {
        int newX = map.getPlayer().getLocation().x + moveX;
        int newY = map.getPlayer().getLocation().y - moveY;

        map.moveElement(map.getPlayer().getLocation().x,map.getPlayer().getLocation().y,newX,newY);
        map.getPlayer().setLocation(newX,newY);
    }

    /**
     * Move enemies on the map
     * @param enemiesMove List of current enemies position
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
     * Get Player location
     * @see model.MapModel#getLocation()
     * @see model.MapModel#getPlayer()
     */
    public Point getPlayerLocation() {
        return map.getPlayer().getLocation();
    }

    /**
     * Get Enemies location
     * @see model.MapModel#getEnemies()
     * @return enemiesMove List of current enemies position
     */
    public List<Point> getEnemiesLocation() {

        List<Point> enemiesLocations = new ArrayList<>();
        List<Mobile> enemies = map.getEnemies();

        for(Mobile enemy : enemies) {
            enemiesLocations.add(enemy.getLocation());
        }
        return enemiesLocations;
    }
    /*Kill enemy*/
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

    /*Get type of an element*/
    public Types getType(int x, int y) {
        return map.getMap()[x][y].getType();
    }

    /*Create a player*/
    public void createElement(int x, int y,Types type) {
        switch (type) {
            case PLAYER:
                /*Use to be sure that the player haven't benn eat*/
                Player player = new Player("L1",x,y);
                map.setPlayer(player);
                map.addElement(player,x,y);
                break;
            case ENEMY:
                /*Use to be sure that the enemies haven't benn eat*/
                for (Mobile enemyLoc : map.getEnemies()) {
                    if (enemyLoc.getLocation().x == x && enemyLoc.getLocation().y == y) {
                        map.addElement(enemyLoc,x,y);
                    }
                }
                break;
            case SPELL:
                int posX = getPlayerLocation().x+x;
                int posY = getPlayerLocation().y-y;
                Spell spell = new Spell("S1",posX,posY, new Point(x,y));

                map.addElement(spell,posX,posY);
                map.setSpell(spell);
                map.getSpell().setLocation(posX,posY);
                break;
            case EXIT_DOOR:
                map.addElement(new Static("DO",Types.EXIT_DOOR),map.getExitDoor().x,map.getExitDoor().y);
                break;
        }
;
    }

    /* Delete the spell*/
    public void deleteSpell() {
        int x = map.getSpell().getLocation().x;
        int y = map.getSpell().getLocation().y;
        map.setSpell(null);
        map.addElement(new Static(" ",Types.VOID),x,y); 
    }

    /* Spell get and set location*/
    public void moveSpell(int moveX, int moveY) {
        int oldX = map.getSpell().getLocation().x;
        int oldY = map.getSpell().getLocation().y;
        int newX = oldX + moveX;
        int newY = oldY - moveY;
        
        map.getSpell().setLocation(newX,newY);
        map.moveElement(oldX,oldY,newX,newY);

    }
    public Point getSpellLocation() {
        return map.getSpell().getLocation();
    }

    /* Check if spell is alive*/
    public boolean spellAlive() {
        if (map.getSpell() != null) {
            return true;
        }
        return false;
    }

    /*Check if there is an enemy at a position*/
    public boolean isThereEnemy(int x,int y) {
        for (Point enemyLoc : getEnemiesLocation()) {
            if (enemyLoc.x == x && enemyLoc.y == y) {
                return true;
            }
        }
        return false;
    }
}
