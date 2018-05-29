package model;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public enum CharToSprite {

    /*Lorann*/
    Lorann_D                ("lorann_b","L1"),
    Lorann_DL               ("lorann_bl","L2"),
    Lorann_L                ("lorann_l","L3"),
    Lorann_UL               ("lorann_ul","L4"),
    Lorann_U                ("lorann_u","L5"),
    Lorann_UR               ("lorann_ur","L6"),
    Lorann_R                ("lorann_r","L7"),
    Lorann_DR               ("lorann_br","L8"),

    /*Spell*/
    Spell_GREEN             ("fireball_1","S1"),
    Spell_BLUE              ("fireball_2","S2"),
    Spell_PURPLE            ("fireball_3","S3"),
    Spell_RED               ("fireball_4","S4"),
    Spell_YELLOW            ("fireball_5","S5"),

    /*Doors*/
    Door_CLOSE              ("gate_closed","DC"),
    Door_OPEN               ("gate_open", "DO"),

    /*Obstacle*/
    Obstacle_SPACE          ("space"," "),
    Obstacle_COIN           ("bone","C"),
    Obstacle_HORIZONTAL     ("horizontal_bone","H"),
    Obstacle_VERTICAL       ("vertical_bone","V"),

    /*Demons*/
    Demon_KYRAC             ("monster_1", "D1"),
    Demon_CARGYR            ("monster_2", "D2"),
    Demon_ARRBARR           ("monster_3", "D3"),
    Demon_MAARCG            ("monster_4", "D4"),

    /*Others*/
    Object_GOLD             ("purse","G"),
    Object_BALL             ("crystal_ball","B");

    private String name = "";
    private String character = "";
    private Image image = null;

    private static Map<String, CharToSprite> lookup = new HashMap<String, CharToSprite>();
    static {
        for (CharToSprite e : CharToSprite.values()) {
            lookup.put(e.character,e);
        }
    }

    //Constructeur
    CharToSprite(String name, String character){
        this.name = name;
        this.character = character;
    }

    /**** GETTERS and SETTERS ****/
    public String getName(){
        return name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    /* Get enum from given char */
    public static CharToSprite get(String character) {
        return lookup.get(character);
    }
}
