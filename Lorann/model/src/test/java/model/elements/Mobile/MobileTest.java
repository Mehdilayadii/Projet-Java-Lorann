package model.elements.Mobile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Types;

public class MobileTest {
	
	private Mobile m;
	private Mobile b;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	m = new Mobile("L3",Types.PLAYER, 14, 11);
	b = new Mobile("D4",Types.ENEMY, 1, 7);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetLocation() {
		assertEquals(14, m.getLocation().x);
	    assertEquals(11, m.getLocation().y);
	    

		assertEquals(1, b.getLocation().x);
	    assertEquals(7, b.getLocation().y);
	}

	@Test
	public void testSetLocation() {
		 m.setLocation(3,7);
		 assertEquals(3, m.getLocation().x);
	     assertEquals(7, m.getLocation().y);

	     b.setLocation(19,1);
		 assertEquals(19, b.getLocation().x);
	     assertEquals(1, b.getLocation().y);
	}

	@Test
	public void excepXMinRange() {
		try {
			new Mobile("S4", Types.SPELL, -1, 1);
			fail("Should throw exception when x < 0");
		} catch (final Exception e) {
			final String expected = "x out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void excepXMaxRange() {
		try {
			new Mobile("S4", Types.SPELL, 20, 1);
			fail("Should throw exception when x > 19");
		} catch (final Exception e) {
			final String expected = "x out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void excepYMinRange() {
		try {
			new Mobile("S4", Types.SPELL, 1, -1);
			fail("Should throw exception when y < 0");
		} catch (final Exception e) {
			final String expected = "y out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void excepYMaxRange() {
		try {
			new Mobile("S4", Types.SPELL, 1, 12);
			fail("Should throw exception when y > 11");
		} catch (final Exception e) {
			final String expected = "y out of range";
			assertEquals(expected, e.getMessage());
		}
	}
}
