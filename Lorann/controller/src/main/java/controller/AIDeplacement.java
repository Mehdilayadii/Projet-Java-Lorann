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



			//Each random int = a specific movement
			int direction = rand.nextInt(8) + 1;
			// minimum = 1 // maximum=8 //



            switch(direction) {

				case 1 : // UP
				{
					newEnemiesPos.add(new Point(0,1));
					break;
				}

				case 2 : // DIAGONAL UP RIGHT
				{
					newEnemiesPos.add(new Point(1,1));
					break;
				}

				case 3 : // RIGHT
				{
					newEnemiesPos.add(new Point(1,0));
					break;
				}

				case 4 : // DIAGONAL DOWN RIGHT
				{
					newEnemiesPos.add(new Point(1,-1));
					break;
				}

				case 5 : // DOWN
				{
					newEnemiesPos.add(new Point(0,-1));
					break;
				}

				case 6 : // DIAGONAL DOWN LEFT
				{
					newEnemiesPos.add(new Point(-1,-1));
					break;
				}

				case 7 : // LEFT
				{
					newEnemiesPos.add(new Point(-1,0));
					break;
				}

				case 8 : // DIAGONAL UP LEFT
				{
					newEnemiesPos.add(new Point(-1,1));
					break;
				}
            }
            
		}

		return newEnemiesPos;
	
	/*
	int i=0;
	List<Point> oldEnemiesPos = model.getEnemiesLocation();
	List<Point> newEnemiesPos = new ArrayList<>();
	for (Point enemyMove : oldEnemiesPos) {
		newEnemiesPos.add(new Point(1,0));
	}
return newEnemiesPos;*/
}
}
