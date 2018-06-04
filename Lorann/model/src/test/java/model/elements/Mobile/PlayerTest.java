package model.elements.Mobile;

import model.elements.ElementsList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp() throws Exception {
        this.player = new Player("L1",0,0);
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test if the animate change the char of the player (In the good order).
     */
    @Test
    public void animate() {
        for (int i=0; i < 8; i++) {
            player.animate(0,0);
            assertEquals(ElementsList.values()[i].getCharacter(),player.getStringStyle());
        }
    }
}