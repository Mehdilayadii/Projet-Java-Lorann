package view;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomJFrameTest {
	
	/** the jframe*/
	CustomJFrame jframe;
	/** the robot to simulate key press*/
	static Robot r = null;

	
	/**
	 * The set up before class
	 * @throws Exception
	 * @throws AWTException
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception, AWTException {    
	}

	
	/**
	 * The tear down after the class
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	
	/**
	 * The set up
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		try {
			r = new Robot();
			jframe = new CustomJFrame();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * The tear down
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
	}


	
	/**
	 * Test return_casting_player
	 */
	@Test
	public void testReturn_casting_player() {
		int expected = 1;
		int value;
		jframe.casting_spell = true;
		if(jframe.return_casting_player()) {
			value = 1;
		} else { value =0;}
		assertEquals(expected,value);
	}

	
	
	
	
	
	/**
	 * Test keyPressed
	 */
	@Test
	public void testKeyPressed() {
		final int expected = 0;
		r.keyPress(KeyEvent.VK_UP);
		int vk=jframe.deplacement_player.x;
		assertEquals(expected, vk);
	}

	
	/**
	 * Test keyReleased
	 */
	@Test
	public void testKeyReleased() {
		final int expected = 0;
		r.keyRelease(KeyEvent.VK_UP);
		final int vk=jframe.deplacement_player.y;
		assertEquals(expected, vk);
	}

}
