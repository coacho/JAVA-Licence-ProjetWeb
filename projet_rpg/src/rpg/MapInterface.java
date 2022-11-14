package rpg;

import java.util.ArrayList;

interface MapInterface {

	Position mapSize();
	
	Position positionSortie();
	
	Position positionMonstre();

	Position positionJoueur();
	
	Position positionObstacle();
	
	ArrayList<String>[] grille();
	
	int mapLenght();
	int mapHeight();


}
