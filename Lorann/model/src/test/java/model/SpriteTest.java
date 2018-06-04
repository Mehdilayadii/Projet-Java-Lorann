package model;

import model.elements.ElementsList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpriteTest {

    /**
     * Check that a image have been load.
     */
    @Test
    public void loadSprite() {
        assertNotNull(Sprite.LoadSprite("../model/src/main/java/model/sprite/bone.png"));
    }

    /**
     * Check that all image have been load.
     */
    @Test
    public void loadAllSprite() {
        Sprite.LoadAllSprite();
        for (ElementsList list : ElementsList.values()) {
            assertNotNull(list.getImage());
        }
    }
}