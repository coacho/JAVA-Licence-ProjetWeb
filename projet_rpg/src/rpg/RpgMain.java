package rpg;

import java.awt.AWTException;
import java.io.IOException;

public class RpgMain{

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		
		Map.generateMap("i",30,30);
		Monstre m1 = MonstreInterface.creationMonstre();
		Joueur j1 = JoueurInterface.CreationPersonage();
		Equipement e1 =  EquipementInterface.creationEquipement();
		Inventaire.ajouter(e1);
		Equipement e2 = EquipementInterface.creationEquipement();
		Inventaire.ajouter(e2);
		
		Manette.waitForKey(j1, m1);
		

	}

	

}
 