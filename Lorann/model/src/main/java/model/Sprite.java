package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Sprite {



    public Image LoadSprite() {
        Image picture;
        try {
            picture = ImageIO.read(new File("images/lorann_b.png"));
            return picture;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
