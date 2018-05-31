package controller;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.IModel;
import model.Types;

public abstract class AIDeplacement {

	public static List<Point> moveAI(IModel model) {


		final int DETECTION_RANGE=10;

		List<Point> enemiesPos = model.getEnemiesLocation();
		List<Point> newEnemiesPos = new ArrayList<>();
		Random rand = new Random();

		//Get the current player's position
		Point playerPos = model.getPlayerLocation();

		int random=0;
		boolean nearPlayer;
		boolean movementDone=false;


		for (Point enemyMove : enemiesPos) {

			//false by default
			nearPlayer=false;
			movementDone=false;

			List<Point> possiblePath = getPath(model,enemyMove);



			//Check if a player is around our monster
			if((enemyMove.x+DETECTION_RANGE>=playerPos.x) && (playerPos.x>=enemyMove.x-DETECTION_RANGE)) {
				if ((enemyMove.y-DETECTION_RANGE<=playerPos.y) && (playerPos.y<=enemyMove.y+DETECTION_RANGE)){
					nearPlayer=true;
				} 
			}


			if (possiblePath.size() <= 1) {
				random = 0;
			}
			else {
				random = rand.nextInt(possiblePath.size());
			}
			// minimum = 0 // maximum = array length //

			//If not near just do random moves
			if (!nearPlayer) {
				newEnemiesPos.add(new Point(possiblePath.get(random).x,possiblePath.get(random).y));
			}

			else {
				//Same x but different y
				if(playerPos.x==enemyMove.x) {
					if(playerPos.y>enemyMove.y) {


						for (int i=0; i<possiblePath.size();i++) {
							//Check if it's possible to move y+1
							if ((possiblePath.get(i).x==0) &&(possiblePath.get(i).y==1)) {
								newEnemiesPos.add(new Point(0,1));
								movementDone=true;
							}

						}

					}
					else if(playerPos.y<enemyMove.y) {


						for (int i=0; i<possiblePath.size();i++) {
							//Check if it's possible to move y-1
							if ((possiblePath.get(i).x==0) &&(possiblePath.get(i).y==-1)) {

								newEnemiesPos.add(new Point(0,-1));
								movementDone=true;
							}
							
						}

					}
					
				}


				//Same y but different x
				else if(playerPos.y==enemyMove.y) {
					if(playerPos.x>enemyMove.x) {


						for (int i=0; i<possiblePath.size();i++) {

							//Check if it's possible to move x+1
							if ((possiblePath.get(i).x==1) &&(possiblePath.get(i).y==0)) {
								newEnemiesPos.add(new Point(1,0));
								movementDone=true;
							}
							
						}


					}
					else if(playerPos.x<enemyMove.x) {


						for (int i=0; i<possiblePath.size();i++) {

							//Check if it's possible to move x-1
							if ((possiblePath.get(i).x==-1) &&(possiblePath.get(i).y==0)) {
								newEnemiesPos.add(new Point(-1,-0));
								movementDone=true;
							}
							
						}
						
					}
					
				}


				//If different X and Y
				//TODO Add some features --> still random moves when near player but with a different X or Y
				if (movementDone==false) {
					newEnemiesPos.add(new Point(possiblePath.get(random).x,possiblePath.get(random).y));
				}


			}


		}

		return newEnemiesPos;
	}


	/*Get all possible position*/
	public static List<Point> getPath(IModel model,Point enemyPos) {

		List<Point> possiblePath = new ArrayList<>();
		Types typeCheck;

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
