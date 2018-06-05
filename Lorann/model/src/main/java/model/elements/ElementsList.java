package model.elements;

import model.Types;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>The Class Elements.</h1>
 *
 * @author Group 13
 * @version 2.0
 */

public enum ElementsList {

	// LORANN //
	
    /** Lorann looking down */
    Lorann_D                ("lorann_b","L1",Types.PLAYER,0,-1),
    /** Lorann looking down left */
    Lorann_DL               ("lorann_bl","L2",Types.PLAYER,-1,-1),
    /** Lorann looking left */
    Lorann_L                ("lorann_l","L3",Types.PLAYER,-1,0),
    /** Lorann looking up left */
    Lorann_UL               ("lorann_ul","L4",Types.PLAYER,-1,1),
    /** Lorann looking up */
    Lorann_U                ("lorann_u","L5",Types.PLAYER,0,1),
    /** Lorann looking up right */
    Lorann_UR               ("lorann_ur","L6",Types.PLAYER,1,1),
    /** Lorann looking right */
    Lorann_R                ("lorann_r","L7",Types.PLAYER,1,0),
    /** Lorann down right */
    Lorann_DR               ("lorann_br","L8",Types.PLAYER,1,-1),

    
    //SPELLS//
    
    /** Green spell */
    Spell_GREEN             ("fireball_1","S1",Types.SPELL),
    /** Blue spell */
    Spell_BLUE              ("fireball_2","S2",Types.SPELL),
    /** Purple spell */
    Spell_PURPLE            ("fireball_3","S3",Types.SPELL),
    /** Red spell */
    Spell_RED               ("fireball_4","S4",Types.SPELL),
    /** Yellow spell */
    Spell_YELLOW            ("fireball_5","S5",Types.SPELL),

    
    // DOOR //
    
    /**Closed door*/
    Door_CLOSE              ("gate_closed","DC",Types.OBSTACLE_KILL),
    /**Opened door*/
    Door_OPEN               ("gate_open", "DO",Types.EXIT_DOOR),

    
    // OBSTACLE //
    
    /** Space */
    Obstacle_SPACE          ("space"," ",Types.VOID),
    /** Corner bone */
    Obstacle_COIN           ("bone","C",Types.OBSTACLE),
    /** Horizontal bone */
    Obstacle_HORIZONTAL     ("horizontal_bone","H",Types.OBSTACLE),
    /** Vertical bone */
    Obstacle_VERTICAL       ("vertical_bone","V",Types.OBSTACLE),

    
    // DEMONS //

    //** Demon Kyrac */
    Demon_KYRAC             ("monster_1", "D1",Types.ENEMY),
    //** Demon Cargyr */
    Demon_CARGYR            ("monster_2", "D2",Types.ENEMY),
   //** Demon Arrbarr */
    Demon_ARRBARR           ("monster_3", "D3",Types.ENEMY),
   //** Demon Maarcg */
    Demon_MAARCG            ("monster_4", "D4",Types.ENEMY),

    
    // OTHERS //
    
    /** Gold bag */
    Object_GOLD             ("purse","G",Types.ITEM),
    /** Crystal ball */
    Object_BALL             ("crystal_ball","B",Types.MAGICAL_BALL);

	/** The x coordinate */
    int x = 0;
    
    /** The y coordinate */
    int y = 0;
    
    /** The name */
    private String name = "";
    
    /** The character*/
    private String character = "";
    
    /** The type */
    private Types type;

    /** The image */
    private Image image = null;


    private static Map<String, ElementsList> lookup = new HashMap<String, ElementsList>();
    static {
        for (ElementsList e : ElementsList.values()) {
            lookup.put(e.character,e);
        }
    }

    /**
     * Instantiate the element list.
     * 
     * @param name Name of the element
     * @param character Character of the element
     * @param type Type of the element
     */
    ElementsList(String name, String character, Types type){
        this.name = name;
        this.character = character;
        this.type = type;
    }

    /**
     * Instantiate the element list.
     * 
     * @param name Name of the element
     * @param character Character of the element
     * @param type Type of the element
     * @param x X coordinate
     * @param y Y coordinate
     */
    ElementsList(String name, String character, Types type, int x, int y){
        this.name = name;
        this.character = character;
        this.type = type;

        this.x = x;
        this.y = y;
    }

    				/**** GETTERS and SETTERS ****/
    
    /**
     * Get the name.
     * 
     * @return the name
     */
    public String getName(){
        return name;
    }

    /**
     * Get the image.
     * 
     * @return the image
     */
    public Image getImage() {
        return image;
    }
    
    /**
     * Get the type.
     * 
     * @return the type
     */
    public Types getType() {
        return this.type;
    }

    /**
     * Get the character.
     * 
     * @return the character
     */
    public String getCharacter() {
        return character;
    }

    /**
     * Set the image.
     * 
     * @param image The image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }
    
    /**
     * Get the direction.
     * 
     * @return an object of type Point
     */
    public Point getDirection() {
        return new Point(this.x,this.y);
    }

    /**
     * Get enumeration from given char.
     * 
     * @param character The character to get the corresponding enumeration
     * @return the enum of ElementsList
     */
    public static ElementsList get(String character) {
        return lookup.get(character);
    }
}
