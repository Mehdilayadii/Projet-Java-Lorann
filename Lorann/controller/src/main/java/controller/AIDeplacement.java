package controller;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.IModel;
import model.Types;

public abstract class AIDeplacement {

	public static List<Point> moveAI(IModel model) {

		List<Point> enemiesPos = model.getEnemiesLocation();
		List<Point> newEnemiesPos = new ArrayList<>();
		Random rand = new Random();

		int random;
		int directionX;
		int directionY;

		for (Point enemyMove : enemiesPos) {

			List<Point> possiblePath = getPath(model,enemyMove);

			//Random int, for deplacement in x and y
			if (possiblePath.size() <= 1) {
				random = 0;
			}
			else {
				random = rand.nextInt(possiblePath.size());
			}
			// minimum = 0 // maximum = array length //

			newEnemiesPos.add(new Point(possiblePath.get(random).x,possiblePath.get(random).y));
		}
		return newEnemiesPos;
	}

	/*Get all possible position*/
	public static List<Point> getPath(IModel model,Point enemyPos) {

		List<Point> possiblePath = new ArrayList<>();
		Types typeCheck;
		int i = 0;

		for (int x = -1; x <= 1; x++) {
			for (int y = -1; y <= 1; y++) {
				typeCheck = model.getType(enemyPos.x+x,enemyPos.y + y);
				if (typeCheck == Types.VOID || typeCheck == Types.PLAYER) {
					possiblePath.add(new Point(x,y));
				}
			}
		}
		return possiblePath;
	}
}
