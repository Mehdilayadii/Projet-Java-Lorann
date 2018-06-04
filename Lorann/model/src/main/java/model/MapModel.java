package model;

import model.elements.Elements;
import model.elements.ElementsList;
import model.elements.Mobile.Mobile;
import model.elements.Mobile.Player;
import model.elements.Mobile.Spell;
import model.elements.Static.Static;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>The Class MapModel provides basic methods of the Model component.</h1>
 *
 * @author Groupe 13
 * @version 2.0
 */

public class MapModel {

	/** The map */
    private Elements[][] map;
    
    /** The player */
    private Player player;
    
    /** The spell */
    private Spell spell;
    
    /** The exit door */
    private Point exitDoor;

    /** The list of enemies */
    private List<Mobile> enemies = new ArrayList<Mobile>();

    /**** CONSTRUCTOR ****/
    
    /**
     * Instantiate a map model from the map
     * @see model.MapModel#MapStringToMapElements(String[][] mapString)
     * - Convert string to element
     * @param mapString 2 dimension array of type String : the map
     */
    public MapModel(String[][] mapString) {
        this.MapStringToMapElements(mapString);
    }

    /**** GETTERS and SETTERS ****/
    
    /**
     * Get the map
     * @return a 2 dimension array of type Elements : the map
     */
    public Elements[][] getMap() {
        return map;
    }

    /**
     * Get the player
     * @return an object of type Player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Get the enemies
     * @return a list of object of type Mobile
     */
    public List<Mobile> getEnemies() {
        return enemies;
    }

    /**
     * Get the spell
     * @return an object of type Spell
     */
    public Spell getSpell() {
        return spell;
    }
    
    /**
     * Set the spell
     * @param spell Object of type Spell
     */
    public void setSpell(Spell spell) {
    	this.spell = spell;
    }

    /**
     * Get the exit door informations
     * @return an object of type Point 
     */
    public Point getExitDoor() {
        return this.exitDoor;
    }

    /**
     * Set the player
     * @param spell Object of type Player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }
    
    
    /**** METHODS ****/
    
    /**
     * Convert the map from the string ressource
     * @see model.MapModel#elementsFromType(Types type, String stringStyle, int positionX, int positionY)
     * - Get element from specific type
     * @see model.elements.ElementsList#getType()
     * - Get type
     * @param mapString the map
     */
    public void MapStringToMapElements(String mapString[][]) {

        int mapX = mapString.length;
        int mapY = mapString[0].length;

        map = new Elements[mapX][mapY];

        for (int x = 0; x < mapX; x++) {
            for (int y = 0; y < mapY; y++) {
                map[x][y] = elementsFromType(ElementsList.get(mapString[x][y]).getType(), mapString[x][y],x,y);
            }
        }
    }

    /**
     * Choose the good class for the elements (from type given in ElementsList)
     * @param type type of the future element
     * @param stringStyle each stringStyle corresponds to a specific sprite (example "L1" = the player)
     * @param positionX X coordinate
     * @param positionY Y coordinate
     */
    public Elements elementsFromType(Types type, String stringStyle, int positionX, int positionY) {
        Elements element;

        switch (type) {
            case PLAYER:
                player = new Player(stringStyle,positionX,positionY);
                element = player;
                break;
            case ENEMY:
                enemies.add(new Mobile(stringStyle,Types.ENEMY,positionX,positionY));
                element = enemies.get(enemies.size()-1);
                break;
            case OBSTACLE_KILL:
                element = new Static(stringStyle, type);
                exitDoor = new Point(positionX,positionY);
            default:
                element = new Static(stringStyle, type);
        }
        return element;
    }

    /**
     * Move any elements
     * @param oldX Current X coordinate
     * @param oldY Current Y coordinate
     * @param newX New X coordinate
     * @param newY New Y coordinate
     */
    public void moveElement(int oldX, int oldY, int newX, int newY) {
        Elements elementToMove = map[oldX][oldY];
        if ((newX != oldX) || (newY != oldY)) {
            map[newX][newY] = elementToMove;
            map[oldX][oldY] = new Static(" ", Types.VOID);
        }
    }

    /**
     * Animate Player and Spells
     * 
     * @see model.elements.Mobile.Player#animate(int directionX, int directionY)
     * - Animate 
     * @param directionX Relative X coordinate deplacement
     * @param directionY Relative Y coordinate deplacement
     * 
     */
    public void animateElements(int directionX, int directionY) {
        player.animate(directionX,directionY);
        if (spell != null) {
            spell.animate();
        }
    }

    /**
     * Create an element
     * 
     * @param elements object of type Elements to add
     * @param x X coordinate
     * @param y Y coordinate 
     * 
     */
    public void addElement(Elements elements, int x, int y) {
        map[x][y] = elements;
    }
}
