package model;

import model.elements.Elements;
import model.elements.Mobile.Mobile;
import model.elements.Mobile.Player;
import model.elements.Mobile.Spell;
import model.elements.Static;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MapModel {

    private Elements[][] map;
    private Player player;
    private Spell spell;
    private Point exitDoor;

    private List<Mobile> enemies = new ArrayList<Mobile>();

    /**** CONSTRUCTOR ****/
    public MapModel(String[][] mapString) {
        this.MapStringToMapElements(mapString);
    }

    /**** GETTERS and SETTERS ****/
    public Elements[][] getMap() {
        return map;
    }

    public Player getPlayer() {
        return player;
    }

    public List<Mobile> getEnemies() {
        return enemies;
    }

    public Spell getSpell() {
        return spell;
    }
    
    public void setSpell(Spell spell) {
    	this.spell = spell;
    }

    public Point getExitDoor() {
        return this.exitDoor;
    }

    /**** METHODS ****/
    /* Convert the map from the string ressource*/
    public void MapStringToMapElements(String mapString[][]) {

        int mapX = mapString.length;
        int mapY = mapString[0].length;

        map = new Elements[mapX][mapY];

        for (int x = 0; x < mapX; x++) {
            for (int y = 0; y < mapY; y++) {
                map[x][y] = elementsFromType(ElementsList.get(mapString[x][y]).getType(), mapString[x][y],x,y);
            }
        }
    }

    /* Choose the good class for the elements (from type given in ElementsList)*/
    public Elements elementsFromType(Types type, String stringStyle, int positionX, int positionY) {
        Elements element;

        switch (type) {
            case PLAYER:
                player = new Player(stringStyle,positionX,positionY);
                element = player;
                break;
            case ENEMY:
                enemies.add(new Mobile(stringStyle,Types.ENEMY,positionX,positionY));
                element = enemies.get(enemies.size()-1);
                break;
            case OBSTACLE_KILL:
                element = new Static(stringStyle, type);
                exitDoor = new Point(positionX,positionY);
            default:
                element = new Static(stringStyle, type);
        }
        return element;
    }

    /* Move any Element*/
    public void moveElement(int oldX, int oldY, int newX, int newY) {
        Elements elementToMove = map[oldX][oldY];
        if ((newX != oldX) || (newY != oldY)) {
            map[newX][newY] = elementToMove;
            map[oldX][oldY] = new Static(" ", Types.VOID);
        }
    }

    /* Animate Player and Spells*/
    public void animateElements() {
        player.animate();
        if (spell != null) {
            spell.animate();
        }
    }

    /*Create an element*/
    public void addElement(Elements elements, int x, int y) {
        map[x][y] = elements;
    }
}
