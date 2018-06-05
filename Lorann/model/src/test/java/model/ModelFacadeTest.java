package model;

import model.management.EnemiesAccess;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class ModelFacadeTest {

    private ModelFacade model;

    @Before
    public void setUp() throws Exception {
        this.model = new ModelFacade();
        model.createElement(0,1,Types.SPELL);
    }

    /**
     * Check that we get a Image stock in the memory.
     */
    @Test
    public void getSpriteFromMap() {
        assertEquals(model.getSpriteFromMap(0,0).getClass(),BufferedImage.class);
    }

    /**
     * Check that we get the good size.
     */
    @Test
    public void getMapSize() {
        assertEquals(new Dimension(20,12),model.getMapSize());
    }

    /**
     * Check that we get the good location
     */
    @Test
    public void getPlayerLocation() {
        assertEquals(new Point(13,3),model.getPlayerLocation());
    }

    /**
     * Check that we get the good location
     */
    @Test
    public void getSpellLocation() {
        assertEquals(new Point(13,2),model.getSpellLocation());
    }

    /**
     * Check that we get the good value
     */
    @Test
    public void spellAlive() {
        assertTrue(model.spellAlive());
    }

    /**
     * Check that we get the good type
     */
    @Test
    public void getType() {
        assertEquals(Types.VOID,model.getType(0,0));
    }
}