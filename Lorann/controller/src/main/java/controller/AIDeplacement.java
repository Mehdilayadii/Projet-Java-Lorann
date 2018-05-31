package controller;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.IModel;

public abstract class AIDeplacement {
	
	//
	

	

public static List<Point> moveAI(IModel model) {
		
		List<Point> enemiesPos = model.getEnemiesLocation();
		List<Point> newEnemiesPos = new ArrayList<>();
		Random rand = new Random();

		for (Point enemyMove : enemiesPos) {



			//Random int, for deplacement in x and y
			int directionX = rand.nextInt(3)-1 ; 
			int directionY = rand.nextInt(3)-1;
			// minimum = -1 // maximum=+1 //

			newEnemiesPos.add(new Point(directionX,directionY));
            
		}

		return newEnemiesPos;
	
}
}
