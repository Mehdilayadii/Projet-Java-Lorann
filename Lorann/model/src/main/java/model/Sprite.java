package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public abstract class Sprite {

    /**
	 * Create the sprite from a name
	 *
	 * @return a a Sprite of type Image
	 * 
	 */
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

    /**
	 * Load all the sprites 
	 */    
    public static void LoadAllSprite() {
        for (ElementsList sprite : ElementsList.values()) {
        	sprite.setImage(LoadSprite("model/src/main/java/model/sprite/"+sprite.getName()+".png"));
        }
    }
    /**
	 * Create the sprite from a string
	 *
	 * @return  a a Sprite of type Image
	 * 
	 */
    public static Image getSpriteFromString(String sprite) {
        return ElementsList.get(sprite).getImage();
    }
}
