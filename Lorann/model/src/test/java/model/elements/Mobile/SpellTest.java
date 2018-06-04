package model.elements.Mobile;

import model.elements.ElementsList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class SpellTest {

    private Spell spell;
    @Before
    public void setUp() throws Exception {
        this.spell = new Spell("S1",0,0,new Point(0,0));
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test if the animate method change the char of the spell and make a full animation loop.
     */
    @Test
    public void animate() {
        spell.animate();
        assertEquals(ElementsList.Spell_GREEN .getCharacter(),spell.getStringStyle());
        spell.animate();
        assertEquals(ElementsList.Spell_BLUE  .getCharacter(),spell.getStringStyle());
        spell.animate();
        assertEquals(ElementsList.Spell_PURPLE.getCharacter(),spell.getStringStyle());
        spell.animate();
        assertEquals(ElementsList.Spell_RED   .getCharacter(),spell.getStringStyle());
        spell.animate();
        assertEquals(ElementsList.Spell_YELLOW.getCharacter(),spell.getStringStyle());
        spell.animate();
        assertEquals(ElementsList.Spell_GREEN .getCharacter(),spell.getStringStyle());
    }
}