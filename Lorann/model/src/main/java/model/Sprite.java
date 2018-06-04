package model;

import model.elements.ElementsList;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public abstract class Sprite {

    /**
	 * Create the sprite from a name
	 *
	 * @param name String : name of the string
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
	 * @see model.elements.ElementsList#setImage(Image image)
	 * - Set image
	 * @see model.elements.ElementsList#getName()
	 * - Get name of a sprite
	 */    
    public static void LoadAllSprite() {
        for (ElementsList sprite : ElementsList.values()) {
        	sprite.setImage(LoadSprite("../model/src/main/java/model/sprite/"+sprite.getName()+".png"));
        }
    }
    /**
	 * Get the sprite from a string
	 *
	 * @see model.elements.ElementsList#getImage()
	 * Get image
	 * 
	 * @param sprite Strin : name of the sprite
	 * @return  a a Sprite of type Image
	 * 
	 */
    public static Image getSpriteFromString(String sprite) {
        return ElementsList.get(sprite).getImage();
    }
}
