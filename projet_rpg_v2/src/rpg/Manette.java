
package rpg;

import java.util.Scanner;

public abstract class Manette extends CreateMap {

	private static String key ;
	private static boolean inputWanted = true;
	static boolean gameStatus = true;
	
	public static void waitForKey(Map map, Joueur j)  {
		
		int x = j.position.getPositionX();
		int y = j.position.getPositionY(); ;
		

		while(gameStatus == true && inputWanted == true) {

			EvenementMap.checkEventMap(map,j);
						
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			System.out.println("Controle:(z/s/q/d/quit)");
			key = scan.nextLine();
			
			switch(key) {
				  case "z":
					  y--;
					  Map.deplacerJoueur(x, y, map);
					  getControle(map);
					  inputWanted = false;
					  break;
				  case "s":
					  y++;
					  Map.deplacerJoueur(x, y, map);
					  getControle(map);
					  inputWanted = false;
					  break;
				  case "q":
					  x--;				  
					  Map.deplacerJoueur(x, y, map);
					  getControle(map);
					  inputWanted = false;
					  break;
				  case "d":
					  x++;  
					  Map.deplacerJoueur(x, y, map);
					  getControle(map);
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
				Map.remplirMap(map);
				waitForKey(map,j);
				
			}
		}

	private static void getControle(Map map) {
		Map.remplirMap(map);
		Map.displayMap(map);
	}
	
}
