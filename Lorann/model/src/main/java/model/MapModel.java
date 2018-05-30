package model;

import model.elements.Elements;
import model.elements.Mobile.Enemy;
import model.elements.Mobile.Mobile;
import model.elements.Mobile.Player;
import model.elements.Mobile.Spell;
import model.elements.Static;
import model.elements.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MapModel {

    private Elements[][] map;
    private Player player;

    private List<Enemy> enemies = new ArrayList<Enemy>();

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

    public List<Enemy> getEnemies() {
        return enemies;
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
            case OBSTACLE:
                element = new Static(stringStyle,true,false);
                break;
            case ENEMY:
                enemies.add(new Enemy(stringStyle,positionX,positionY));
                element = enemies.get(enemies.size() - 1);
                break;
            case SPELL:
                element = new Spell(stringStyle,positionX,positionY);
                break;
            case OBSTACLE_KILL:
                element = new Static(stringStyle,true,true);
                break;
            case ITEM:
                element = new Static(stringStyle,true,false);
                break;
            case EXIT_DOOR:
                element = new Static(stringStyle,true,false);
                break;
            default:
                element = new Elements(stringStyle);
        }
        return element;
    }

    /* Move any Element*/
    public void moveElement(int oldX, int oldY, int newX, int newY) {
        Elements elementToMove = map[oldX][oldY];
        map[newX][newY] = elementToMove;
        if ((newX != oldX) || (newY != oldY)) {
        	map[oldX][oldY] = new Elements(" ");
        }
    }

    /* Animate Player and Spells*/
    public void animateElements() {
        player.animate();
    }
}
