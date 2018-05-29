package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Sprite {

    public Image LoadSprite(String name) {
        Image picture;
        try {
            picture = ImageIO.read(new File(name));
            return picture;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void LoadAllSprite() {
<<<<<<< HEAD
        for (CharToSprite sprite : CharToSprite.values()) {
            sprite.setImage(LoadSprite("F:\\Cesi\\Annee 1\\_Project\\Github\\Projet-Java-Lorann\\Lorann\\main\\src\\main\\ressources\\sprite\\"+sprite.getName()+".png"));
=======
        for (CharToSprite sprite : CharToSprite.values()) {       	
        	sprite.setImage(LoadSprite("../model/src/main/java/model/sprite/"+sprite.getName()+".png"));
>>>>>>> 9c8b3cbac2038aef21ff2b99dbcc77f1cdb50513
        }
    }

    public Image getSpriteFromString(String sprite) {
        return CharToSprite.valueOf(sprite).getImage();
    }
}
