
package rpg;

import java.util.Scanner;

public abstract class Manette extends CreateMap {

	
	private static String key ;
	private static boolean inputWanted = true;
	static boolean gameStatus = true;
	//private Position mouvement = new Position(0,0);
	
	
	public static void waitForKey(Map map, Joueur j)  {
		int x = j.position.getPositionX();
		int y = j.position.getPositionY(); ;
		
		while(gameStatus == true && inputWanted == true) {
		//displayMap();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Controle:(z/s/q/d/quit)");
			
		key = scan.nextLine();
		
		switch(key) {
			  case "z":
				  y--;
				  j.setPositionJoueurY(y);
				  map.setPositionJoueur(j.position);
				  getControle(map, j.position);
				  inputWanted = false;
				  break;
			  case "s":
				 y++;
				  j.setPositionJoueurY(y);
				  map.setPositionJoueur(j.position);
				  getControle(map, j.position);
				  inputWanted = false;
				  break;
			  case "q":
				  x--;
				  j.setPositionJoueurX(x);
				  map.setPositionJoueur(j.position);
				  getControle(map, j.position);
				  inputWanted = false;
				  break;
			  case "d":
				  x++;  
				  j.setPositionJoueurX(x);
				  map.setPositionJoueur(j.position);
				  getControle(map, j.position);
				  inputWanted = false;
				  break;
			  case "quit":
				  gameStatus = false;
				  inputWanted = false;
				  break;
			  default:
				  inputWanted = true;
					Map.displayMap(map);
				  break;
				  }
			inputWanted = true;
			//Map.deplacerMonstre(map);
			Map.remplirMap(map);
			waitForKey(map,j);
			}
		
		}

	private static void getControle(Map map, Position p) {
		//Map.deplacerMonstre(map);
		Map.remplirMap(map);
		Map.displayMap(map);
		  
	}
	
}
