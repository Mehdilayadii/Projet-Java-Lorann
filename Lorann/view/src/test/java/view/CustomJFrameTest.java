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
	CustomJFrame jframe;
	static Robot r = null;

	
    //jframe.getKeyListeners()[0].keyPressed(key);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception, AWTException {
		
		
        
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		try {
			r = new Robot();
			jframe = new CustomJFrame();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReturn_deplacement_player() {
		
	}

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

	
	
	
	
	@Test
	public void testKeyPressed() {
		final int expected = 0;
		r.keyPress(KeyEvent.VK_UP);
		int vk=jframe.deplacement_player.x;
		assertEquals(expected, vk);
	}

	@Test
	public void testKeyReleased() {
		final int expected = 0;
		r.keyRelease(KeyEvent.VK_UP);
		final int vk=jframe.deplacement_player.y;
		assertEquals(expected, vk);
	}

}
