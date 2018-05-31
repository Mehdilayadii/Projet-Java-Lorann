package controller;

import java.awt.Point;
import java.util.List;
import java.util.Random;

public abstract class AIDeplacement {
	
	//
	

	
	
public List<Point> moveAI() {
		
		List<Point> enemiesPos = getEnemiesLocation();
		//List<Point> movePos ;
		Random rand = new Random();
		

		for (Point enemyMove : enemiesPos) {



			//Each random int = a specific movement
			int direction = rand.nextInt(8) + 1;
			// minimum = 1 // maximum=8 //



            switch(direction) {

				case 1 : // UP
				{
					enemyMove.y=(int) (enemyMove.getY()-1.0);
					break;
				}

				case 2 : // DIAGONAL UP RIGHT
				{
					enemyMove.x=(int) (enemyMove.getX()+1.0);
					enemyMove.y=(int) (enemyMove.getY()-1.0);
					break;
				}

				case 3 : // RIGHT
				{
					enemyMove.x=(int) (enemyMove.getX()+1.0);
					break;
				}

				case 4 : // DIAGONAL DOWN RIGHT
				{
					enemyMove.x=(int) (enemyMove.getX()+1.0);
					enemyMove.y=(int) (enemyMove.getY()-1.0);
					break;
				}

				case 5 : // DOWN
				{
					enemyMove.y=(int) (enemyMove.getY()-1.0);
					break;
				}

				case 6 : // DIAGONAL DOWN LEFT
				{
					enemyMove.y=(int) (enemyMove.getY()-1.0);
					enemyMove.x=(int) (enemyMove.getX()-1.0);
					break;
				}

				case 7 : // LEFT
				{
					enemyMove.x=(int) (enemyMove.getX()-1.0);
					break;
				}

				case 8 : // DIAGONAL UP LEFT
				{
					enemyMove.x=(int) (enemyMove.getX()-1.0);
					enemyMove.y=(int) (enemyMove.getY()-1.0);
					break;
				}
            }
            
		}

		return enemiesPos;

}
}
