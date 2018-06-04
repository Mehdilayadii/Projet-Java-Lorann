package model.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImportLevelTest {

    private String[][] mapString ={{" "," ","C","V","V","V","V","V","V","V","V","C"},
            {" "," ","H","G"," "," "," "," "," "," ","B","H"},
            {" "," ","C","V","V","C"," "," "," "," "," ","H"},
            {" "," "," "," "," ","H","G","H"," ","H","G","H"},
            {" "," ","C","V","V","C","V","C"," ","C","V","C"},
            {" "," ","H","D2"," "," "," "," "," "," "," ","H"},
            {"C","V","C","V","V","V","C"," "," "," "," ","H"},
            {"H"," ","H"," ","D3","G","H"," "," "," "," ","H"},
            {"H"," ","C"," "," "," ","H"," "," "," "," ","H"},
            {"H"," "," ","C","V","V","C"," "," "," "," ","H"},
            {"H"," "," "," "," "," "," "," "," "," "," ","H"},
            {"H"," "," "," "," "," "," "," "," "," "," ","H"},
            {"H"," ","C","V","V","C"," "," "," "," "," ","H"},
            {"H"," ","H","L1"," ","H"," "," "," "," "," ","H"},
            {"H"," "," "," ","G","H"," "," "," "," "," ","H"},
            {"H"," ","C","V","V","V","C","V","V","V","V","C"},
            {"H"," "," "," "," "," ","H"," "," "," "," "," "},
            {"C","V","V","C"," "," ","C","V","V","V","V","C"},
            {" "," "," ","H"," "," "," "," "," "," ","DC","H"},
            {" "," "," ","C","V","V","V","V","V","V","V","C"}};

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createMap() {
        assertEquals(mapString, ImportLevel.CreateMap());
    }
}