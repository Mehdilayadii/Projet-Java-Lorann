package controller.GameManagement;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.IModel;
import model.Types;

public abstract class AIDeplacement {

	public static List<Point> moveAI(IModel model) {


		final int DETECTION_RANGE=0;

		List<Point> enemiesPos = model.getEnemiesLocation();
		List<Point> newEnemiesMove = new ArrayList<>();
		Random rand = new Random();

		//Get the current player's position
		Point playerPos = model.getPlayerLocation();

		int random=0;
		boolean nearPlayer;
		boolean movementDone=false;


		for (Point enemyPos : enemiesPos) {

			//false by default
			nearPlayer=false;
			movementDone=false;

			List<Point> possiblePath = getPath(model,enemyPos);



			//Check if a player is around our monster
			if((enemyPos.x+DETECTION_RANGE>=playerPos.x) && (playerPos.x>=enemyPos.x-DETECTION_RANGE)) {
				if ((enemyPos.y-DETECTION_RANGE<=playerPos.y) && (playerPos.y<=enemyPos.y+DETECTION_RANGE)){
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
				newEnemiesMove.add(new Point(possiblePath.get(random).x,possiblePath.get(random).y));
			}

			else {
				//Same x but different y
				if(playerPos.x==enemyPos.x) {
					if(playerPos.y>enemyPos.y) {


						for (int i=0; i<possiblePath.size();i++) {
							//Check if it's possible to move y+1
							if ((possiblePath.get(i).x==0) &&(possiblePath.get(i).y==1)) {
								newEnemiesMove.add(new Point(0,1));
								movementDone=true;
							}

						}

					}
					else if(playerPos.y<enemyPos.y) {


						for (int i=0; i<possiblePath.size();i++) {
							//Check if it's possible to move y-1
							if ((possiblePath.get(i).x==0) &&(possiblePath.get(i).y==-1)) {

								newEnemiesMove.add(new Point(0,-1));
								movementDone=true;
							}
							
						}

					}
					
				}


				//Same y but different x
				else if(playerPos.y==enemyPos.y) {
					if(playerPos.x>enemyPos.x) {


						for (int i=0; i<possiblePath.size();i++) {

							//Check if it's possible to move x+1
							if ((possiblePath.get(i).x==1) &&(possiblePath.get(i).y==0)) {
								newEnemiesMove.add(new Point(1,0));
								movementDone=true;
							}
							
						}

					}
					else if(playerPos.x<enemyPos.x) {


						for (int i=0; i<possiblePath.size();i++) {

							//Check if it's possible to move x-1
							if ((possiblePath.get(i).x==-1) &&(possiblePath.get(i).y==0)) {
								newEnemiesMove.add(new Point(-1,-0));
								movementDone=true;
							}
							
						}
						
					}
					
				}
				
				
				
				else  { //There we are in the "near player zone" but with a different X or Y
					
					
					//check if player is in diagonal of a monster
					if((playerPos.y>enemyPos.y && playerPos.x>enemyPos.x )&&(enemyPos.x-playerPos.x==enemyPos.y-playerPos.y  )) {
						//Down-Right diagonal
						 for (int i=0; i<possiblePath.size();i++) {
								//Check if it's possible to move y+1
								if ((possiblePath.get(i).x==1) &&(possiblePath.get(i).y==1)) {
									newEnemiesMove.add(new Point(1,1));
									movementDone=true;
								}
								
						 }
												 
					 }
					
					if((playerPos.y<enemyPos.y && playerPos.x<enemyPos.x )&&(playerPos.x-enemyPos.x==playerPos.y-enemyPos.y)) {
						 //Down-Left diagonal
						 for (int i=0; i<possiblePath.size();i++) {
								//Check if it's possible to move y+1
								if ((possiblePath.get(i).x==-1) &&(possiblePath.get(i).y==1)) {
									newEnemiesMove.add(new Point(-1,1));
									movementDone=true;
								}
						 } 
						 
					 }
					
					if((playerPos.y>enemyPos.y && playerPos.x<enemyPos.x )&&(playerPos.x-enemyPos.x==enemyPos.y-playerPos.y  )) {
						//Up-Right diagonal
						 for (int i=0; i<possiblePath.size();i++) {
								//Check if it's possible to move y+1
								if ((possiblePath.get(i).x==-1) &&(possiblePath.get(i).y==-1)) {
									newEnemiesMove.add(new Point(-1,-1));
									movementDone=true;
								}
								
						 }
						
					 }
					
					if((playerPos.y<enemyPos.y && playerPos.x>enemyPos.x )&&(enemyPos.x-playerPos.x==playerPos.y-enemyPos.y )) {
						//Up-Left diagonal
						 
						 for (int i=0; i<possiblePath.size();i++) {
								//Check if it's possible to move y+1
								if ((possiblePath.get(i).x==1) &&(possiblePath.get(i).y==-1)) {
									newEnemiesMove.add(new Point(1,-1));
									movementDone=true;
								}
								
						 }
									 
					 }
				}


				//If different X and Y and not in diagonal
				//TODO Add some features --> still random moves when near player but with a different X or Y
				if (movementDone==false) {
					newEnemiesMove.add(new Point(possiblePath.get(random).x,possiblePath.get(random).y));
				}


			}
		}

		return newEnemiesMove;
	}


	/*Get all possible position*/
	public static List<Point> getPath(IModel model,Point enemyPos) {

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
