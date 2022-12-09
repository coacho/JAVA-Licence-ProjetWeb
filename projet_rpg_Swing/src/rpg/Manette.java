
package rpg;


public abstract class Manette extends MapCreate {

	public static boolean gameStatus = true;
	public static int input;
	
	public static void setKey(int keyCode) {
		Manette.input = keyCode;
		
	}
	public static int getKey() {
		return Manette.input;
	}
	
	public static void waitForKey(Map map, Joueur j)  {
		
		int x = j.position.getPositionX();
		int y = j.position.getPositionY(); ;
		
			
			int inputCurrent;
			
			inputCurrent = getKey();
			
			switch(inputCurrent) {
				  case 37: //haut
					  y--;
					  Map.deplacerJoueur(x, y, map);
				break;
				  case 39: //droite
					  y++;
					  Map.deplacerJoueur(x, y, map);
				break;
				  case 38: //bas
					  x--;				  
					  Map.deplacerJoueur(x, y, map);
				break;
				  case 40: //gauche
					  x++;  
					  Map.deplacerJoueur(x, y, map);
				break;
				  case 0:
					  gameStatus = false;
				break;
				  default:
				Map.playMonstre(map);
				map.remplirMap();
				//Map.displayMap(map);
					  break;
					  }		
				Map.playMonstre(map);
				map.remplirMap();
				MapEvenement.checkEventMap(map,j);					
	}		
}
	

