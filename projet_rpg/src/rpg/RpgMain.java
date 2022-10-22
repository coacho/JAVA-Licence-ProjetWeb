package rpg;


public class RpgMain{

	public static void main(String[] args) {
		
		JoueurInterface j1 = Joueur.creationPersonage();
		System.out.println();
		Joueur.displayJoueur();
		System.out.println("==============");
		//System.out.println(j1.nom);
		
		Monstre m1 = Monstre.creationMonstre();
		Monstre.displayMonstre();
		System.out.println("==============");
		
		Equipement e1 = Equipement.creationEquipement();
		Equipement.displayEquipement();
		//System.out.println(EquipementInterface.nomEquipement(e1));
		
	}

	

}
