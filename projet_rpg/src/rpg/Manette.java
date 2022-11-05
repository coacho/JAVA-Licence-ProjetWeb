
package rpg;

import java.awt.event.KeyEvent;
import java.util.Scanner;

public abstract class Manette {

	private static int x = 1;
	private static int y = 1;
	static String key ;
	//private static int event;
	private static boolean inputWanted = true;
	private static boolean gameStatus = true;
	
	public static void waitForKey() {

		while(gameStatus == true && inputWanted == true) {

		System.out.println("Controle:(z/s/q/quit)");
		//try (Scanner scan = new Scanner(System.in)) {
		Scanner scan = new Scanner(System.in);
			key = scan.nextLine();
			//Scanner scan2 = new Scanner(System.in);
			
			int entrer =  KeyEvent.VK_ENTER;
			
		//	entrer = scan2.nextInt();
			
			switch(key) {
			  case "z":
				//getArrowKeyX(scan);
				  y--;
				  getControle(x,y);
				  inputWanted = false;
				  break;
			  case "s":
				//getArrowKeyX(scan);
				  y++;
				  getControle(x,y);
				  inputWanted = false;
				  break;
			  case "q":
				  x--;
				  getControle(x,y);
				  inputWanted = false;
				  break;
			  case "d":
				  x++;
				  getControle(x,y);
				  inputWanted = false;
				  break;
			  case "quit":
				  gameStatus = false;
				  inputWanted = false;
				  break;
			  default:
				  inputWanted = true;
				  }
			inputWanted = true;
			waitForKey();
			
			}
		}

	//}
	private static void getControle(int x, int y) {
		Map.generateMap("i",12,12,x,y);
	}
	
}
