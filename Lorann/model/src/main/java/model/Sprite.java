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
        for (CharToSprite sprite : CharToSprite.values()) {
        	sprite.setImage(LoadSprite("model/src/main/java/model/sprite/"+sprite.getName()+".png"));
        }
    }

    public Image getSpriteFromString(String sprite) {
        return CharToSprite.get(sprite).getImage();
    }
}
