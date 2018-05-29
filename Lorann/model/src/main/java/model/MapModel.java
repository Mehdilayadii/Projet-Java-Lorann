package model;

import model.elements.Elements;

import java.awt.*;

public class MapModel {
    private Elements[][] map;

    /**** CONSTRUCTOR ****/
    public MapModel(String[][] mapString) {
        this.MapStringToMapElements(mapString);
    }

    /**** GETTERS and SETTERS ****/
    public Elements[][] getMap() {
        return map;
    }

    /**** METHODS ****/
    public void MapStringToMapElements(String mapString[][]) {

        int mapX = mapString.length;
        int mapY = mapString[0].length;

        map = new Elements[mapX][mapY];

        for (int x = 0; x < mapX; x++) {
            for (int y = 0; y < mapY; y++) {
                map[x][y] = new Elements(mapString[x][y]);
            }
        }
    }
}
