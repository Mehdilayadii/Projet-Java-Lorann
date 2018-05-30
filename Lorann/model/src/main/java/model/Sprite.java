package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public abstract class Sprite {

    public static Image LoadSprite(String name) {
        Image picture;
        try {
            picture = ImageIO.read(new File(name));
            return picture;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void LoadAllSprite() {
        for (ElementsList sprite : ElementsList.values()) {
        	sprite.setImage(LoadSprite("../model/src/main/java/model/sprite/"+sprite.getName()+".png"));
        }
    }

    public static Image getSpriteFromString(String sprite) {
        return ElementsList.get(sprite).getImage();
    }
}
