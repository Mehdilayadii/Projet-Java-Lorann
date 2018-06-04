package model.management;

import model.MapModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class PlayerAccessTest {

    private PlayerAccess playerAccess;
    private MapModel map;
    private String mapString[][] =
            {       {"C","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","C"},
                    {"V","D1","L1","S1"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","D2","V"},
                    {"C","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","C"}};

    @Before
    public void setUp() throws Exception {
        map = new MapModel(mapString);
        playerAccess = new PlayerAccess(map);
    }

    /**
     * Check if the player move correctly.
     */
    @Test
    public void movePlayer() {
        playerAccess.movePlayer(0,1);
        assertEquals(new Point(1,1),map.getPlayer().getLocation());
    }

    /**
     * Check if we can recreate the player
     */
    @Test
    public void createPlayer() {
        playerAccess.createPlayer(10,10);
        assertEquals("L1",map.getMap()[10][10].getStringStyle());
    }
}