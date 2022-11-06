
package rpg;

import java.util.Scanner;

public abstract class Manette extends Map {

	
	private static String key ;
	private static boolean inputWanted = true;
	static boolean gameStatus = true;
	
	
	
	public static void waitForKey(Joueur j, Monstre m)  {
		int x = j.position.get(0);
		int y = j.position.get(1); ;
		
		while(gameStatus == true && inputWanted == true) {
		//displayMap();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Controle:(z/s/q/d/quit)");
			
		key = scan.nextLine();
		
		switch(key) {
			  case "z":
				  y--;
				  j.position.set(1,y);
				  getControle(j, m);
				  inputWanted = false;
				  break;
			  case "s":
				 y++; 
				  j.position.set(1,y);
				  getControle(j, m);
				  inputWanted = false;
				  break;
			  case "q":
				  x--;
				  j.position.set(0,x);
				  getControle(j, m);
				  inputWanted = false;
				  break;
			  case "d":
				  x++;
				  j.position.set(0,x);
				  getControle(j, m);
				  inputWanted = false;
				  break;
			  case "quit":
				  gameStatus = false;
				  inputWanted = false;
				  break;
			  default:
				  displayMap();
				  inputWanted = true;
				  }
			inputWanted = true;
			if(getStatusOut() == "bagarre") {
				Combat combat = new Combat();
				combat.startCombat(j, m);
			}
			waitForKey(j,m);
			}
		
		}

	private static void getControle(Joueur j, Monstre m) {
		Map.setMap(j,m);
	}
	
}
