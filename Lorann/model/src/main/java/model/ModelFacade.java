package model;


import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.ImportLevel;
import model.dao.LorannBDDConnector;
import model.dao.ProcedureDAO;
import model.elements.Mobile.Mobile;
import model.elements.Mobile.Spell;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class ModelFacade implements IModel {

    private MapModel map;

    /**
     * Instantiates a new model facade.
     * @throws SQLException 
     */
    public ModelFacade()  {
        Sprite.LoadAllSprite();
        this.map = new MapModel(ImportLevel.CreateMap(this));
    }

    /**** GETTERS and SETTERS ****/
    public Image getSpriteFromMap(int x,int y) {
        return map.getMap()[x][y].getSprite();
    }

    public Dimension getMapSize() {
        return new Dimension(map.getMap().length,map.getMap()[0].length);
    }

    /**** METHODS ****/
    /*Connect to the database lorann */
    public void connectToDB() {
    	LorannBDDConnector conn = null;
    	try {
    		System.out.print("Trying to connect to Database :\n");
    		conn =new LorannBDDConnector();
    		System.out.print("Successfuly connected\n");
    	}
    	catch (Exception e){
    		e.printStackTrace();
    	}
    }

	@Override
	public List<Example> getLevelByID(int id) throws SQLException {
		return ProcedureDAO.getLevelByID(id);
	}

	/*Animate*/
    public void animate() {
        map.animateElements();
    }

    /*Move player*/
    public void movePlayer(int moveX, int moveY) {
        int newX = map.getPlayer().getLocation().x + moveX;
        int newY = map.getPlayer().getLocation().y - moveY;

        map.moveElement(map.getPlayer().getLocation().x,map.getPlayer().getLocation().y,newX,newY);
        map.getPlayer().setLocation(newX,newY);
    }

    /*Move enemies*/
    public void moveEnemies(List<Point> enemiesMove) {
        List<Point> enemiesOld = getEnemiesLocation();
        int i = 0;

        for (Point enemyMove : enemiesMove) {
            int oldX = map.getEnemies().get(i).getLocation().x;
            int oldY = map.getEnemies().get(i).getLocation().y;

            int newX = oldX + enemyMove.x;
            int newY = oldY + enemyMove.y;

            map.moveElement(oldX,oldY,newX,newY);
            map.getEnemies().get(i).setLocation(newX,newY);

            i++;
        }
    }

    /* Get Player location*/
    public Point getPlayerLocation() {
        return map.getPlayer().getLocation();
    }

    /* Get Enemies locations */
    public List<Point> getEnemiesLocation() {

        List<Point> enemiesLocations = new ArrayList<>();
        List<Mobile> enemies = map.getEnemies();

        for(Mobile enemy : enemies) {
            enemiesLocations.add(enemy.getLocation());
        }
        return enemiesLocations;
    }

    /*Get type of an element*/
    public Types getType(int x, int y) {
        return map.getMap()[x][y].getType();
    }

    /*Create the spell*/
    public void createSpell(int directionX, int directionY) {
        int x = getPlayerLocation().x+directionX;
        int y = getPlayerLocation().y+directionY;
        Spell spell = new Spell("S1",x,y, new Point(directionX,directionY));

        map.addElement(spell,x,y);
    }

    /*Spell get and set location*/
    public void moveSpell(int moveX, int moveY) {
        int newX = map.getSpell().getLocation().x + moveX;
        int newY = map.getSpell().getLocation().y - moveY;

        map.moveElement(map.getSpell().getLocation().x,map.getSpell().getLocation().y,newX,newY);
        map.getSpell().setLocation(newX,newY);
    }
    public Point getSpellLocation() {
        return map.getSpell().getLocation();
    }

}
