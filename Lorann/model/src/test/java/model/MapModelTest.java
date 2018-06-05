package model;

import model.elements.Elements;
import model.elements.Mobile.Player;
import model.elements.Static.Static;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapModelTest {

    private MapModel map;
    private String mapString[][] =
            {   {"C","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","C"},
                {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                {"C","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","C"}};

    @Before
    public void setUp() throws Exception {
        map = new MapModel(mapString);
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Check that the map of elements is filled from a string array.
     */
    @Test
    public void mapStringToMapElements() {
        map.MapStringToMapElements(mapString);

        for (int y = 0; y < 12 ; y++) {
            for (int x = 0; y < 20 ; y++) {
                assertNotNull(map.getMap()[x][y]);
            }
        }

    }

    /**
     * Check that we get the good element from a specific type.
     */
    @Test
    public void elementsFromType() {
        Elements element = map.elementsFromType(Types.PLAYER,"L1",0,0);
        Elements exceptedElement = Player.getInstance();
        assertEquals(element.getClass(),exceptedElement.getClass());

        element = map.elementsFromType(Types.OBSTACLE,"C",0,0);
        exceptedElement = new Static("C",Types.OBSTACLE);
        assertEquals(element.getClass(),exceptedElement.getClass());
    }

    /**
     * Check that a specific element have move.
     */
    @Test
    public void moveElement() {
        map.MapStringToMapElements(mapString);

        int oldX = 0;
        int oldY = 0;
        int newX = 5;
        int newY = 5;

        Elements elementsToMove = map.getMap()[0][0];
        map.moveElement(oldX,oldY,newX,newY);

        assertEquals(elementsToMove,map.getMap()[5][5]);
    }

    /**
     * Check that an element have been created in the elements map.
     */
    @Test
    public void addElement() {
        map.MapStringToMapElements(mapString);

        Elements element = new Static("C",Types.OBSTACLE);
        map.addElement(element,5,5);

        assertEquals(element, map.getMap()[5][5]);
    }
}