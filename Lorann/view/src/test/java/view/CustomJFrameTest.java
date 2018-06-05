package view;

import static org.junit.Assert.*;

import java.awt.Point;
import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomJFrameTest {
	private Point dp1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	dp1 = new Point(0,0);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReturn_deplacement_player() {
		
	}

	@Test
	public void testReturn_casting_player() {
		fail("Not yet implemented");
	}

	@Test
	public void testChanging_value_deplacement() {
		final int expected = 1;
		final int vk=CustomJFrame.getChanging_value_deplacement().changing_value_deplacement(KeyEvent.VK_UP);
		assertEquals(expected, vk);
	}
	
	@Test
	public void testKeyPressed() {
		fail("Not yet implemented");
	}

	@Test
	public void testKeyReleased() {
		final int expected = 0;
		final int vk=CustomJFrame.keyReleased(KeyEvent.VK_UP).deplacement_player.y;
		assertEquals(expected, vk);
	}

	@Test
	public void testKeyTyped() {
		fail("Not yet implemented");
	}

}
