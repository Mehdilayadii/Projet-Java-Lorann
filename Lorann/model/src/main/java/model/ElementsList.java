package model;

import model.elements.Behavior;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public enum ElementsList {

    /*Lorann*/
    Lorann_D                ("lorann_b","L1",Behavior.PLAYER),
    Lorann_DL               ("lorann_bl","L2",Behavior.PLAYER),
    Lorann_L                ("lorann_l","L3",Behavior.PLAYER),
    Lorann_UL               ("lorann_ul","L4",Behavior.PLAYER),
    Lorann_U                ("lorann_u","L5",Behavior.PLAYER),
    Lorann_UR               ("lorann_ur","L6",Behavior.PLAYER),
    Lorann_R                ("lorann_r","L7",Behavior.PLAYER),
    Lorann_DR               ("lorann_br","L8",Behavior.PLAYER),

    /*Spell*/
    Spell_GREEN             ("fireball_1","S1",Behavior.PLAYER_SHOOT),
    Spell_BLUE              ("fireball_2","S2",Behavior.PLAYER_SHOOT),
    Spell_PURPLE            ("fireball_3","S3",Behavior.PLAYER_SHOOT),
    Spell_RED               ("fireball_4","S4",Behavior.PLAYER_SHOOT),
    Spell_YELLOW            ("fireball_5","S5",Behavior.PLAYER_SHOOT),

    /*Doors*/
    Door_CLOSE              ("gate_closed","DC",Behavior.PLAYER_LETHAL),
    Door_OPEN               ("gate_open", "DO",Behavior.FINISH),

    /*Obstacle*/
    Obstacle_SPACE          ("space"," ",Behavior.OBSTACLE),
    Obstacle_COIN           ("bone","C",Behavior.OBSTACLE),
    Obstacle_HORIZONTAL     ("horizontal_bone","H",Behavior.OBSTACLE),
    Obstacle_VERTICAL       ("vertical_bone","V",Behavior.OBSTACLE),

    /*Demons*/
    Demon_KYRAC             ("monster_1", "D1",Behavior.PLAYER_LETHAL),
    Demon_CARGYR            ("monster_2", "D2",Behavior.PLAYER_LETHAL),
    Demon_ARRBARR           ("monster_3", "D3",Behavior.PLAYER_LETHAL),
    Demon_MAARCG            ("monster_4", "D4",Behavior.PLAYER_LETHAL),

    /*Others*/
    Object_GOLD             ("purse","G",Behavior.ITEM),
    Object_BALL             ("crystal_ball","B",Behavior.ITEM);

    private String name = "";
    private String character = "";
    private Behavior behavior;

    private Image image = null;

    private static Map<String, ElementsList> lookup = new HashMap<String, ElementsList>();
    static {
        for (ElementsList e : ElementsList.values()) {
            lookup.put(e.character,e);
        }
    }

    //Constructeur
    ElementsList(String name, String character, Behavior behavior){
        this.name = name;
        this.character = character;
        this.behavior = behavior;
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
    public static ElementsList get(String character) {
        return lookup.get(character);
    }
}
