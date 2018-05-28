package model;

import model.dao.CharToSprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
            sprite.setImage(LoadSprite("sprite\\"+sprite.getName()+".png"));
        }
    }

    public Image getSpriteFromString(String sprite) {
        return CharToSprite.valueOf(sprite).getImage();
    }
}