package model;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import model.dao.ImportLevel;
import model.elements.Elements;
import model.elements.Mobile.Mobile;
import model.elements.Mobile.Player;
import model.elements.Mobile.Spell;
import model.elements.Static.Static;
import model.management.EnemiesAccess;
import model.management.PlayerAccess;
import model.management.SpellAccess;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Groupe 13
 * @version 2.0
 */
public final class ModelFacade implements IModel {

	/** Map model */
    private MapModel map;

    private PlayerAccess playerAccess;
    private EnemiesAccess enemiesAccess;
    private SpellAccess spellAccess;
    
    /**
     * Instantiates a new model facade.
     */
    public ModelFacade()  {
        Sprite.LoadAllSprite();
        this.map = new MapModel(ImportLevel.CreateMap(1));

        this.playerAccess = new PlayerAccess(map);
        this.enemiesAccess = new EnemiesAccess(map);
        this.spellAccess = new SpellAccess(map);
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
     * @see PlayerAccess#movePlayer(int, int)
     */
    public void movePlayer(int moveX, int moveY) {
        playerAccess.movePlayer(moveX,moveY);
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
     * @see EnemiesAccess#moveEnemies(List)
     */
    public void moveEnemies(List<Point> enemiesMove) {
        enemiesAccess.moveEnemies(enemiesMove);
    }

    /**
     * @see EnemiesAccess#getEnemiesLocation()
     */
    public List<Point> getEnemiesLocation() {
        return enemiesAccess.getEnemiesLocation();
    }
    
    /**
     * @see EnemiesAccess#killEnemy(int, int)
     */
    public void killEnemy(int x, int y) {
        enemiesAccess.killEnemy(x,y);
    }

    /**
     * @see EnemiesAccess#isThereEnemy(int, int)
     */
    public boolean isThereEnemy(int x,int y) {
        return enemiesAccess.isThereEnemy(x,y);
    }

    /**
     * @see SpellAccess#moveSpell(int, int)
     */
    public void moveSpell(int moveX, int moveY) {
        spellAccess.moveSpell(moveX,moveY);

    }
    /**
     * @see SpellAccess#deleteSpell()
     */
    public void deleteSpell() {
        spellAccess.deleteSpell();
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
     * Get type of an element at specific coordinates
     * 
     * @see MapModel#getMap()
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
     * @see model.MapModel#setPlayer(Player)
     * - Set player 
     * @see model.MapModel#setSpell(Spell)
     * - Set the spell at a specific position
     * @see MapModel#getSpell()
     * - Get current location of the spell
     * @see model.MapModel#getExitDoor()
     * - Get infos about exit door
     * @see model.MapModel#addElement(Elements, int, int)
     * - Add element at specific coordinates
     * 
     * @param x coordinate X of an element
     * @param y coordinate Y of an element
     * @param type type of element to create
     */
    public void createElement(int x, int y,Types type) {
        switch (type) {
            case PLAYER:
                playerAccess.createPlayer(x,y);
                break;
            case ENEMY:
                enemiesAccess.createEnemy(x,y);
                break;
            case SPELL:
                spellAccess.createSpell(x,y);
                break;
            case EXIT_DOOR:
                map.addElement(new Static("DO",Types.EXIT_DOOR),map.getExitDoor().x,map.getExitDoor().y);
                break;
		default:
			break;
        }
    }
}
