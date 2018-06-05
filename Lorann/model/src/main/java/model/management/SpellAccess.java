package model.management;

import model.MapModel;
import model.Types;
import model.elements.Elements;
import model.elements.Mobile.Spell;
import model.elements.Static.Static;

import java.awt.*;

public class SpellAccess {

    private MapModel map;

    //CONSTRUCTOR//
    public SpellAccess(MapModel map) {
        this.map = map;
    }

    //METHODS//
    /**
     * Move the spell
     *
     * @see model.elements.Mobile.Mobile#getLocation()
     * - Get current location of an element
     * @see model.elements.Mobile.Mobile#setLocation(int,int)
     *  - Move an element at new coordinates
     * @see model.MapModel#getSpell()
     *  - Get current location of the spell
     * @see model.MapModel#moveElement(int,int,int,int)
     * - Move an element at specific coordinate
     *
     * @param moveX new coordinate X of the spell
     *@param moveY new coordinate Y of the spell
     */
    public void moveSpell(int moveX, int moveY) {
        int oldX = map.getSpell().getLocation().x;
        int oldY = map.getSpell().getLocation().y;
        int newX = oldX + moveX;
        int newY = oldY - moveY;

        map.getSpell().setLocation(newX,newY);
        map.moveElement(oldX,oldY,newX,newY);
    }

    /**
     * Create a spell at a special location, in function of the player location and a direction vector.
     * @param x spawn location
     * @param y spawn location
     */
    public void createSpell(int x,int y) {
        int posX = map.getPlayer().getLocation().x+x;
        int posY = map.getPlayer().getLocation().y-y;
        Spell spell = new Spell("S1",posX,posY, new Point(x,y));

        map.addElement(spell,posX,posY);
        map.setSpell(spell);
        map.getSpell().setLocation(posX,posY);
    }

    /**
     * Delete the spell
     *
     * @see model.elements.Mobile.Mobile#getLocation()
     * - Get current location of an element
     * @see model.MapModel#setSpell(Spell)
     *  - Set the spell at a specific position
     * @see model.MapModel#getSpell()
     *  - Get current location of the spell
     * @see model.MapModel#addElement(Elements, int, int)
     * - Create an element at specific coordinate
     */
    public void deleteSpell() {
        int x = map.getSpell().getLocation().x;
        int y = map.getSpell().getLocation().y;
        map.setSpell(null);
        map.addElement(new Static(" ",Types.VOID),x,y);
    }
}
