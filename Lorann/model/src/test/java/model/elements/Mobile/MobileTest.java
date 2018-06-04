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

	@Before
	public void setUp() throws Exception {
	m = new Mobile("L3",Types.PLAYER, 14, 11);
	b = new Mobile("D4",Types.ENEMY, 1, 7);

	}

	/**
	 * Check if the getter work
	 */
	@Test
	public void testGetLocation() {
		assertEquals(14, m.getLocation().x);
	    assertEquals(11, m.getLocation().y);
	    

		assertEquals(1, b.getLocation().x);
	    assertEquals(7, b.getLocation().y);
	}

	/**
	 * Check if the setter work
	 */
	@Test
	public void testSetLocation() {
		 m.setLocation(3,7);
		 assertEquals(3, m.getLocation().x);
	     assertEquals(7, m.getLocation().y);

	     b.setLocation(19,1);
		 assertEquals(19, b.getLocation().x);
	     assertEquals(1, b.getLocation().y);
	}

	/**
	 *  Check if the given location is negative. There is no max to location because map may change and become larger.
	 */
	@Test
	public void negativeValue() {
		try {
			new Mobile("L1",Types.PLAYER, -1, 11);
			fail("Location cannot be negative !");
		} catch(final Exception e) {
			final String expected = "Negative location error";
			assertEquals(expected, e.getMessage());
		}
	}
}
