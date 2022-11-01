package rpg;

public class RpgMain{

	public static void main(String[] args) {
		
		//Joueur j1 = Joueur.creationPersonage();
		//System.out.println();
		//Joueur.displayJoueur();
		//System.out.println("==============");
		//System.out.println(j1.nom);
		
		//Monstre m1 = Monstre.creationMonstre();
		//Monstre.displayMonstre();
		//System.out.println("==============");
		
		Equipement e1 =  EquipementInterface.creationEquipement();
		Inventaire.ajouter(e1);
		Equipement e2 = EquipementInterface.creationEquipement();
		//EquipementInterface.displayEquipement(e1);
		//EquipementInterface.nom(e1);
		
		Inventaire.ajouter(e2);
		
		//System.out.println("inventaire:");
		Inventaire.displayInventaire();
		
		//Equipement.displayEquipement();
		//Equipement.displayEquipement((Equipement) inv1.get(0));
		//System.out.println(EquipementInterface.nomEquipement(e1));
		
		//Menu.genererMenuVide(6);
		//Combat combat = new Combat();
		//combat.startCombat(j1, m1);
		
		
	}

	

}
 