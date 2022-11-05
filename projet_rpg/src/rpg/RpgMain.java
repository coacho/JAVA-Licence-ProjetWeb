package rpg;


public class RpgMain{

	public static void main(String[] args) {
		
		//KeyEvent keyX = new KeyEvent;
		//Manette.geyArrowKeyX(keyX);
		Map.generateMap("i",12,12,1,1);
		Manette.waitForKey();
		Joueur j1 = JoueurInterface.CreationPersonage();

		Monstre m1 = MonstreInterface.creationMonstre();
		
		Equipement e1 =  EquipementInterface.creationEquipement();
		Inventaire.ajouter(e1);
		Equipement e2 = EquipementInterface.creationEquipement();
		Inventaire.ajouter(e2);
		
		//Menu.genererMenuVide(6);
		Combat combat = new Combat();
		combat.startCombat(j1, m1);
	}

	

}
 