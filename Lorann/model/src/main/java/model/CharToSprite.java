package model;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public enum CharToSprite {
    COIN ("bone","C"),
    HORIZONTAL ("horizontal_bone","H"),
    VERTICAL ("vertical_bone","V");

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
