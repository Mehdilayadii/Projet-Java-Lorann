package model.dao;

import java.awt.*;

public enum CharToSprite {
    C ("bone"),
    H ("horizontal_bone"),
    V ("vertical_bone");

    private String name = "";
    private Image image = null;

    //Constructeur
    CharToSprite(String name){
        this.name = name;
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
}
