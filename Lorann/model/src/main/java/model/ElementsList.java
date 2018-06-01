package model;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public enum ElementsList {

    /*Lorann*/
    Lorann_D                ("lorann_b","L1",Types.PLAYER,0,-1),
    Lorann_DL               ("lorann_bl","L2",Types.PLAYER,-1,-1),
    Lorann_L                ("lorann_l","L3",Types.PLAYER,-1,0),
    Lorann_UL               ("lorann_ul","L4",Types.PLAYER,1,-1),
    Lorann_U                ("lorann_u","L5",Types.PLAYER,0,1),
    Lorann_UR               ("lorann_ur","L6",Types.PLAYER,1,1),
    Lorann_R                ("lorann_r","L7",Types.PLAYER,1,0),
    Lorann_DR               ("lorann_br","L8",Types.PLAYER,1,-1),

    /*Spell*/
    Spell_GREEN             ("fireball_1","S1",Types.SPELL),
    Spell_BLUE              ("fireball_2","S2",Types.SPELL),
    Spell_PURPLE            ("fireball_3","S3",Types.SPELL),
    Spell_RED               ("fireball_4","S4",Types.SPELL),
    Spell_YELLOW            ("fireball_5","S5",Types.SPELL),

    /*Doors*/
    Door_CLOSE              ("gate_closed","DC",Types.OBSTACLE_KILL),
    Door_OPEN               ("gate_open", "DO",Types.EXIT_DOOR),

    /*Obstacle*/
    Obstacle_SPACE          ("space"," ",Types.VOID),
    Obstacle_COIN           ("bone","C",Types.OBSTACLE),
    Obstacle_HORIZONTAL     ("horizontal_bone","H",Types.OBSTACLE),
    Obstacle_VERTICAL       ("vertical_bone","V",Types.OBSTACLE),

    /*Demons*/
    Demon_KYRAC             ("monster_1", "D1",Types.ENEMY),
    Demon_CARGYR            ("monster_2", "D2",Types.ENEMY),
    Demon_ARRBARR           ("monster_3", "D3",Types.ENEMY),
    Demon_MAARCG            ("monster_4", "D4",Types.ENEMY),

    /*Others*/
    Object_GOLD             ("purse","G",Types.ITEM),
    Object_BALL             ("crystal_ball","B",Types.MAGICAL_BALL);

    int x = 0;
    int y = 0;
    private String name = "";
    private String character = "";
    private Types type;

    private Image image = null;

    private static Map<String, ElementsList> lookup = new HashMap<String, ElementsList>();
    static {
        for (ElementsList e : ElementsList.values()) {
            lookup.put(e.character,e);
        }
    }

    //Constructeur
    ElementsList(String name, String character, Types type){
        this.name = name;
        this.character = character;
        this.type = type;
    }

    /*For player*/
    ElementsList(String name, String character, Types type, int x, int y){
        this.name = name;
        this.character = character;
        this.type = type;

        this.x = x;
        this.y = y;
    }

    /**** GETTERS and SETTERS ****/
    public String getName(){
        return name;
    }

    public Image getImage() {
        return image;
    }

    public Types getType() {
        return this.type;
    }

    public String getCharacter() {
        return character;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Point getDirection() {
        return new Point(this.x,this.y);
    }

    /* Get enum from given char */
    public static ElementsList get(String character) {
        return lookup.get(character);
    }
}
