package rpg;

import java.util.ArrayList;

abstract class Inventaire {
	
	static ArrayList<Equipement> Inventaire = new ArrayList<Equipement>();
	
	protected static ArrayList<Equipement> ajouter(Equipement e) {
		
		Inventaire.add(e);
			
		return Inventaire;
	}
/*
	protected static ArrayList<Object> retirer(Equipement e){
		
		ArrayList<Object> InventaireTemp = new ArrayList<Object>();
		
		if (e != null){
			int index = Inventaire.indexOf(e);
			for (int i = 0; i>Inventaire.size(); i++) {
				if(i != index)  {
					InventaireTemp.add(Inventaire.get(i));
				}
			}
			Inventaire.clear();
			Inventaire = InventaireTemp;
			InventaireTemp.clear();
		}
		
		return Inventaire;
	}
	*/
	protected static void displayInventaire() {
		
		System.out.println("Inventaire : ");
		
		for(int i = 0;i<Inventaire.size();i++) {
			Equipement equipdisplay = Inventaire.get(i);
			System.out.println("=====================");
			System.out.println(": " + equipdisplay.nom);
			System.out.println(": " + equipdisplay.propriete);
			System.out.println(": " + equipdisplay.attaque);
			System.out.println(": " + equipdisplay.defense);
			System.out.println(": " + equipdisplay.magie);	
		}
		

		
	}

	
	
}
