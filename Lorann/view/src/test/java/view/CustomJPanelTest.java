package view;

import static org.junit.Assert.*;

import java.awt.Image;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomJPanelTest {
    private CustomJPanel J;
    private CustomJPanel P;
    private Image[][] map;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	J=new CustomJPanel(map, 37);
	P=new CustomJPanel(map,8270);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetScore() throws Exception{
		assertEquals("SCORE : 00037", J.getScore());
	    assertEquals("SCORE : 08270", P.getScore());
	}

	@Test
	public void testSetScore() {
		J.setScore("00123");
		P.setScore("29341");
		assertEquals("SCORE : 00123", J.getScore());
	    assertEquals("SCORE : 29341", P.getScore());
	}

}
