package model.elements.Mobile;

import model.Types;

public class Spell extends Mobile{

    /**** CONSTRUCTOR ****/
    public Spell(String stringStyle, int x, int y) {
        super(stringStyle,Types.SPELL,x,y);
    }
}
