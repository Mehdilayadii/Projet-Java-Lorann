package model.elements;

import model.Sprite;
import model.Types;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class ElementsListTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Sprite.LoadAllSprite();
    }

    /**
     * Check if we get the good element for specific character.
     */
    @Test
    public void get() {
        assertEquals(ElementsList.get("D3"),ElementsList.Demon_ARRBARR);
        assertEquals(ElementsList.get("DC"),ElementsList.Door_CLOSE);
    }

    /**
     * Check if we get the good name for specific Element.
     */
    @Test
    public void getName() {
        assertEquals("monster_3",ElementsList.Demon_ARRBARR.getName());
        assertEquals("horizontal_bone",ElementsList.Obstacle_HORIZONTAL.getName());
        assertEquals("fireball_5",ElementsList.Spell_YELLOW.getName());
    }

    /**
     * Check if we get an Image stock in the memory for specific Element. Image have to be load before.
     * @see ElementsListTest#setUpBeforeClass()
     */
    @Test
    public void getImage() {
        assertEquals(BufferedImage.class,ElementsList.Object_GOLD.getImage().getClass());
        assertEquals(BufferedImage.class,ElementsList.Obstacle_COIN.getImage().getClass());
    }

    /**
     * Check if we get the good type for specific Element.
     */
    @Test
    public void getType() {
        assertEquals(Types.ENEMY,ElementsList.Demon_ARRBARR.getType());
        assertEquals(Types.OBSTACLE,ElementsList.Obstacle_HORIZONTAL.getType());
        assertEquals(Types.SPELL,ElementsList.Spell_YELLOW.getType());
    }

    /**
     * Check if we get the good char for specific Element.
     */
    @Test
    public void getCharacter() {
        assertEquals("D3",ElementsList.Demon_ARRBARR.getCharacter());
        assertEquals("H",ElementsList.Obstacle_HORIZONTAL.getCharacter());
        assertEquals("S5",ElementsList.Spell_YELLOW.getCharacter());
    }

    /**
     * Check that the setter work.
     */
    @Test
    public void setImage() {
        try {
            Image test = ImageIO.read(new File("../model/src/main/java/model/sprite/bone.png"));
            ElementsList.Spell_YELLOW.setImage(test);
            assertEquals(test,ElementsList.Spell_YELLOW.getImage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check if we get the good direction for specific Element.
     */
    @Test
    public void getDirection() {
        assertEquals(new Point(-1,1),ElementsList.Lorann_UL.getDirection());
        assertEquals(new Point(1,0),ElementsList.Lorann_R.getDirection());
        assertEquals(new Point(0,0),ElementsList.Spell_BLUE.getDirection());
    }
}