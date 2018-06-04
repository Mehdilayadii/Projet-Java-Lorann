package model;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import model.dao.ImportLevel;
import model.dao.LorannBDDConnector;
import model.elements.Mobile.Mobile;
import model.elements.Mobile.Player;
import model.elements.Mobile.Spell;
import model.elements.Static.Static;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Groupe 13
 * @version 2.0
 */
public final class ModelFacade implements IModel {

	/** Map model */
    private MapModel map;
    
    /**
     * Instantiates a new model facade.
     */
    public ModelFacade()  {
        Sprite.LoadAllSprite();
        this.map = new MapModel(ImportLevel.CreateMap(this));
    }

    // GETTERS and SETTERS //
    
    /**
     * Get sprite from specific coordinate
     * @see model.MapModel#getMap()
     * - Get the map
     * @see model.elements.Elements#getSprite()
     * - Get the sprite
     * @param x X coordinate
     * @param y Y coordinate
     * @return the sprite at these coordinates
     */
    public Image getSpriteFromMap(int x,int y) {
        return map.getMap()[x][y].getSprite();
    }

    /**
     * Get dimension from a map
     * @see model.MapModel#getMap()
     * - Get the map
     * @return a object of type Dimension (dimension of the map)
     */
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
     * @see model.MapModel#animateElements(int, int)
     * - Animate elements
     * @param directionX Direction in X coordinate
     * @param directionY Direction in Y coordinate
     */
    public void animate(int directionX, int directionY) {
        map.animateElements(directionX, directionY);
    }

    /**
     * Move player
     * @see model.MapModel#getPlayer()
     * - Get infos about player
     * @see model.elements.Mobile.Mobile#getLocation()
     * - Get location of an element
     * @see model.elements.Mobile.Mobile#setLocation(int ,int)
     * - Set location of an element
     * @see model.MapModel.moveElement(int oldX, int oldY, int newX, int newY)
     * - Move element from current coordinate to new ones
     * @param directionX Relative direction in X coordinate
     * @param directionY Relative direction in Y coordinate
     * 
     */
    public void movePlayer(int moveX, int moveY) {
        int newX = map.getPlayer().getLocation().x + moveX;
        int newY = map.getPlayer().getLocation().y - moveY;

        map.moveElement(map.getPlayer().getLocation().x,map.getPlayer().getLocation().y,newX,newY);
        map.getPlayer().setLocation(newX,newY);
    }

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
     * Get Player location
     * @see model.elements.Mobile.Mobile#getLocation()
     * - Get location of an element
     * @see model.MapModel#getPlayer()
     * - Get infos about player
     * @return object of type Point with player coordinates
     */
    
    public Point getPlayerLocation() {
        return map.getPlayer().getLocation();
    }

    /**
     * Get Enemies location
     * @see model.MapModel#getEnemies()
     * - Get current mobile elements
     * @return list of points of enemies locations
     */
    public List<Point> getEnemiesLocation() {

        List<Point> enemiesLocations = new ArrayList<>();
        List<Mobile> enemies = map.getEnemies();

        for(Mobile enemy : enemies) {
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
     * @see model.MapModel#addElement()
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
     * Get type of an element at specific coordinates
     * 
     * @see model.MapModel#getMaps()
     * - Get the map 
     * @see model.elements.Elements#getType()
     * - Get type of a specific square of the map
     * @param x coordinate X 
     * @param y coordinate Y 
     * 
     * @return type of an element
     */
    public Types getType(int x, int y) {
        return map.getMap()[x][y].getType();
    }
    
    

    /**
     * Create a an element at specific coordinates (of  types : Player, Enemy, Spell, or Exit door
     * 
     * @see model.Types
     * - Enumeration of all available types
     * @see model.MapModel#getEnemies()
     * - Get current mobile elements
     * @see model.elements.Mobile.Mobile#getLocation()
     * - Get current location of an element
     * @see model.MapModel#setPlayer(player)
     * - Set player 
     * @see model.MapModel#setSpell(spell)
     * - Set the spell at a specific position
     * @see model.MapModel#getSpell(spell)
     * - Get current location of the spell
     * @see model.MapModel#getExitDoor()
     * - Get infos about exit door
     * @see model.MapModel#addElement(Element,int,int)
     * - Add element at specific coordinates
     * 
     * @param x coordinate X of an element
     * @param y coordinate Y of an element
     * @param type type of element to create
     */
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

    /**
     * Delete the spell
     * 
     * @see model.elements.Mobile.Mobile#getLocation()
     * - Get current location of an element
     * @see model.MapModel#setSpell(spell)
     *  - Set the spell at a specific position
     * @see model.MapModel#getSpell()
     *  - Get current location of the spell
     * @see model.MapModel#addElement(Element,int,int)
     * - Create an element at specific coordinate
     * 
     */
    
    public void deleteSpell() {
        int x = map.getSpell().getLocation().x;
        int y = map.getSpell().getLocation().y;
        map.setSpell(null);
        map.addElement(new Static(" ",Types.VOID),x,y); 
    }

    /**
    * Move the spell
    * 
    * @see model.elements.Mobile.Mobile#getLocation()
    * - Get current location of an element
    * @see model.elements.Mobile.Mobile#setLocation(int,int)
    *  - Move an element at new coordinates
    * @see model.MapModel#getSpell()
    *  - Get current location of the spell
    * @see model.MapModel#moveElement(int,int,int,int)
    * - Move an element at specific coordinate
    * 
    * @param moveX new coordinate X of the spell
     *@param moveY new coordinate Y of the spell
    */
    
    
    public void moveSpell(int moveX, int moveY) {
        int oldX = map.getSpell().getLocation().x;
        int oldY = map.getSpell().getLocation().y;
        int newX = oldX + moveX;
        int newY = oldY - moveY;
        
        map.getSpell().setLocation(newX,newY);
        map.moveElement(oldX,oldY,newX,newY);

    }
    
    /**
     * Get location of the spell
     * 
     * @see model.elements.Mobile.Mobile#getLocation()
     * - Get location of a specifi element
     * @see model.MapModel#getSpell()
     * - Get current infos about the spell
     * @return a object of type Point with spell's coordinates
     */
    public Point getSpellLocation() {
        return map.getSpell().getLocation();
    }

    /**
     * Check if spell is alive
     * 
     * @see model.MapModel#getSpell()
     * - Get current infos about the spell
     * @return false if no spell is currently created
     */
    
    public boolean spellAlive() {
        if (map.getSpell() != null) {
            return true;
        }
        return false;
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
