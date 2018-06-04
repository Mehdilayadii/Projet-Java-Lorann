package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpriteTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void loadSprite() {
        
        assertNotNull(Sprite.LoadSprite("model/src/main/java/model/sprite/bone.png"));
    }

    @Test
    public void loadAllSprite() {
    }

    @Test
    public void getSpriteFromString() {
    }
}