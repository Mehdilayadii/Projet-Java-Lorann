package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExampleTest {

	private Example test;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
    public void setUp() throws Exception {
        this.test = new Example("test", 1,2);
    }

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
    public void testGetElement() {
        final String expected = "test" ;
        assertEquals(expected, this.test.getElement());
    }

    @Test
    public void testGetCooX() {
        final int expected = 1;
        assertEquals(expected, this.test.getCooX());
    }
    
    @Test
    public void testGetCooY() {
        final int expected = 2;
        assertEquals(expected, this.test.getCooY());
    }

    
    @Test
    public void testSetElement() {
        String expected = "test";
        assertEquals(expected, this.test.getElement());
        expected = "element";
        this.test.setElement(expected);
        assertEquals(expected, this.test.getElement());
    }
    
    
    
    @Test
    public void testSetCooX() {
        int expected = 1;
        assertEquals(expected, this.test.getCooX());
        expected = 3;
        this.test.setCooX(expected);
        assertEquals(expected, this.test.getCooX());
    }
    
    @Test
    public void testSetCooY() {
        int expected = 2;
        assertEquals(expected, this.test.getCooY());
        expected = 4;
        this.test.setCooY(expected);
        assertEquals(expected, this.test.getCooY());
    }

    
    @Test
    public void testToString() {
        final String expected = "test;1;2";
        assertEquals(expected, this.test.toString());
    }


}


