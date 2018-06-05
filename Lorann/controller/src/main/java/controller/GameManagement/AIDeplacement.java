package controller.GameManagement;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.IModel;
import model.Types;



/**
 *<h1>Class AIDeplacement.</h1>
 * 
 * @author Groupe 13
 * @version 2.0
 */

public class AIDeplacement {

	private IModel model;
	private List<Point> newEnemiesMove;
	private static final int DETECTION_RANGE=5;

	//CONSTRUCTOR//
	public AIDeplacement(IModel model) {
		this.model = model;
		this.newEnemiesMove = new ArrayList<>();
	}

	/**
	 * Generate new moves for monsters
	 * 
	 * @see  model.IModel#getEnemiesLocation()
	 * - Get enemies location
	 * @see model.IModel#getPlayerLocation()
	 * - Get player location
	 * @see  controller.GameManagement.AIDeplacement#getPath(Point enemyPos)
	 * - Get possible moves
	 * @return a list of Point : the move of each enemie
	 */
	public List<Point> moveAI() {
		newEnemiesMove = new ArrayList<>();

		List<Point> enemiesPos = model.getEnemiesLocation();
		Random rand = new Random();

		//Get the current player's position
		Point playerPos = model.getPlayerLocation();
		int random;

		for (Point enemyPos : enemiesPos) {

			List<Point> possiblePath = getPath(enemyPos);

			if (possiblePath.size() <= 1) {
				random = 0;
			}
			else {
				random = rand.nextInt(possiblePath.size());
			}

			if (isPlayerReachable(enemyPos,possiblePath) != null) {
				newEnemiesMove.add(isPlayerReachable(enemyPos,possiblePath));
			}
			else  {
				newEnemiesMove.add(new Point(possiblePath.get(random).x,possiblePath.get(random).y));
			}
		}
		return newEnemiesMove;
	}

	/**
	 * Check if the player can be see and if he can be rush.
	 *
	 * @see AIDeplacement#isMovePossible(int, int, List)
	 *
	 * @param enemyPos position of the enemy to move.
	 * @param possiblePath list of possibles paths of this enemy
	 * @return
	 */
	private Point isPlayerReachable(Point enemyPos,List<Point> possiblePath) {
		Point playerDirectionRelative = new Point(model.getPlayerLocation().x-enemyPos.x, model.getPlayerLocation().y-enemyPos.y);
		int moveX = playerDirectionRelative.x+enemyPos.x;
		int moveY = playerDirectionRelative.y+enemyPos.y;

		if(Math.abs(playerDirectionRelative.x) < DETECTION_RANGE && Math.abs(playerDirectionRelative.y) < DETECTION_RANGE) {
			return isMovePossible(playerDirectionRelative.x,playerDirectionRelative.y, possiblePath);
		}

		return null;
	}

	/**
	 * Verify that the movement to the player is accessible (no obstacle)
	 * @param moveX Movement X to verify
	 * @param moveY Movement Y to verify
	 * @param possiblePath All possible path for this enemy
	 * @return null if no possible path found
	 */
	private Point isMovePossible(int moveX, int moveY, List<Point> possiblePath) {
		if(moveX < 0) {
			moveX = -1;
		}
		else if(moveX > 0) {
			moveX = 1;
		}
		if(moveY < 0) {
			moveY = -1;
		}
		else if(moveY > 0) {
			moveY = 1;
		}
		for (Point path : possiblePath) {
			if (path.x == moveX && path.y == moveY) {
				return path;
			}
		}
		return null;
	}

	/**
	 * Get the different square around available
	 * @param enemyPos current enemies positions
	 * @return a list of Point : available moves
	 */
	private List<Point> getPath(Point enemyPos) {

		List<Point> possiblePath = new ArrayList<>();
		Types typeCheck;

		for (int x = -1; x <= 1; x++) {
			for (int y = -1; y <= 1; y++) {
				typeCheck = model.getType(enemyPos.x+x,enemyPos.y + y);
				if (typeCheck == Types.VOID || typeCheck == Types.PLAYER || typeCheck == Types.SPELL) {
					possiblePath.add(new Point(x,y));
				}
			}
		}
		return possiblePath;
	}
}
