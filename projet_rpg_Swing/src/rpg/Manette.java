
package rpg;


public abstract class Manette extends CreateMap {

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
		
			MapEvenement.checkEventMap(map,j);

			int inputCurrent;
			
			inputCurrent = getKey();
			
			switch(inputCurrent) {
				  case 37: //haut
					  y--;
					  Map.deplacerJoueur(x, y, map);
					  getControle(map);
				break;
				  case 39: //droite
					  y++;
					  Map.deplacerJoueur(x, y, map);
					  getControle(map);
				break;
				  case 38: //bas
					  x--;				  
					  Map.deplacerJoueur(x, y, map);
					  getControle(map);
				break;
				  case 40: //gauche
					  x++;  
					  Map.deplacerJoueur(x, y, map);
					  getControle(map);
				break;
				  case 0:
					  gameStatus = false;
				break;
				  default:
				Map.displayMap(map);
					  break;
					  }
			
				Map.remplirMap(map);
				Map.playMonstre(map);
				
			}
		

	private static void getControle(Map map) {
		Map.remplirMap(map);
		Map.playMonstre(map);

	}
		
}
	

