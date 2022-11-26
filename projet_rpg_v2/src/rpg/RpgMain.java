package rpg;

import java.awt.AWTException;
import java.io.IOException;

public class RpgMain{

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		
		
		Map map1 = Map.newMap(12,12);
		Monstre m1 = MonstreInterface.creationMonstre();
		map1.setListMonstre(m1);
		Monstre m2 = MonstreInterface.creationMonstre();
		map1.setListMonstre(m2);
		Joueur j1 = JoueurInterface.CreationPersonage();
		map1.setPositionJoueur(j1.position);
		Map.remplirMap(map1);
		Map.displayMap(map1);
		Manette.waitForKey(map1, j1);
		

	}

	

}
 