package model.elements;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElementsListTest {

    /**
     * Check if we get the good element from a specific character.
     */
    @Test
    public void get() {
        String testString = "D3";
        assertEquals(ElementsList.get(testString),ElementsList.Demon_ARRBARR);

        testString = "DC";
        assertEquals(ElementsList.get(testString),ElementsList.Door_CLOSE);
    }
}