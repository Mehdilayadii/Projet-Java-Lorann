package model.management;

import model.MapModel;
import model.Types;
import model.elements.Mobile.Spell;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class SpellAccessTest {

    private SpellAccess spellAccess;
    private MapModel map;
    private String mapString[][] =
            {       {"C","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","C"},
                    {"V","D1","L1","S1"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","V"},
                    {"V"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","D2","V"},
                    {"C","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","H","C"}};
    @Before
    public void setUp() throws Exception {
        map = new MapModel(mapString);

        Spell spell = new Spell("S1",1,3,new Point(0,0));

        map.addElement(spell,1,3);
        map.setSpell(spell);

        spellAccess = new SpellAccess(map);
    }

    /**
     * Check if the spell move correctly.
     */
    @Test
    public void moveSpell() {
        spellAccess.moveSpell(0,1);
        assertEquals(new Point(1,2),map.getSpell().getLocation());
    }

    /**
     * Check if we can create a spell.
     */
    @Test
    public void createSpell() {
        assertNotSame(map.getMap()[5][5].getType(),Types.SPELL);
        spellAccess.createSpell(0,1);
        assertNotSame(map.getMap()[5][4].getType(),Types.SPELL);
    }
    /**
     * Check if we can delete a spell.
     */
    @Test
    public void deleteSpell() {
        spellAccess.deleteSpell();
        assertNotSame(Types.SPELL,map.getMap()[1][3].getType());
    }
}