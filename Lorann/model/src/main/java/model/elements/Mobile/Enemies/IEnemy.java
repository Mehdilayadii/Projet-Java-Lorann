package model.elements.Mobile.Enemies;

import model.elements.Mobile.IMobile;

import java.awt.*;

public interface IEnemy extends IMobile {
    Point getBehavior();
}
