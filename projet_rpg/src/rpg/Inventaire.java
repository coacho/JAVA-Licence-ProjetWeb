package rpg;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Inventaire {
	
	private static ArrayList<Equipement> Inventaire = new ArrayList<Equipement>();
	private static ArrayList<Equipement> Equiped = new ArrayList<Equipement>();
	private static Scanner scan = new Scanner(System.in);

	//private static String equip ="";
	
	protected static ArrayList<Equipement> ajouter(Equipement e) {
		e.equip = true;
		Inventaire.add(e);	
		return Inventaire;
	}
	private static ArrayList<Equipement> getInventaire(int i){
		
		return Inventaire;
	}

	protected static ArrayList<Equipement> retirer(Equipement e){
		
		ArrayList<Equipement> InventaireTemp = new ArrayList<Equipement>();
		
		if (e != null){
			int index = Inventaire.indexOf(e);
			for (int i = 0; i>Inventaire.size(); i++) {
				if(i != index)  {
					InventaireTemp.add(Inventaire.get(i));
				}
			}
			e.equip = false;
			Inventaire.clear();
			Inventaire = InventaireTemp;
			InventaireTemp.clear();
		}
		
		return Inventaire;
	}
	
	static void menuInventaire() {
		
		String stringPut;
		int intPut;
		
		System.out.println("==============");
		System.out.println(displayInventaire());
		System.out.println("==============");
		System.out.println("1 - retour");
		
		
		stringPut = scan.nextLine();
		switch(stringPut) {
		  case "1":
				break;
		default:
				menuInventaire();
			break;
		}

	}
	
	private static String displayInventaire(){
		
		String inventaireDisplay = "";
		
		System.out.println("Inventaire : ");
		
		for(int i = 0;i<Inventaire.size();i++) {
			Equipement equipdisplay = Inventaire.get(i);
			if(equipdisplay.equip == true){
				inventaireDisplay = inventaireDisplay +"\n" + i + " ======= equiped =========" ; 
			}else {
			inventaireDisplay = inventaireDisplay +"\n" + i + " =====================";
			}
			inventaireDisplay = inventaireDisplay +"\n" +"nom : " + equipdisplay.nom;
			inventaireDisplay = inventaireDisplay +"\n" +"propriété: " + equipdisplay.propriete;
			inventaireDisplay = inventaireDisplay +"\n" +"attaque : " + equipdisplay.attaque;
			inventaireDisplay = inventaireDisplay +"\n" +"defense : " + equipdisplay.defense;
			inventaireDisplay = inventaireDisplay +"\n" +"mana : " + equipdisplay.magie;	
		}
		return inventaireDisplay;
	}
/*
	private static void setEquiped(Equipement e) {
		if(e.equip = true) {
		Equiped.add(e);
		}else {
			Equiped.clear();;
		}
	}
	
	private static ArrayList<Equipement> getEquiped() {
		for(int i = 0; i< Inventaire.size();i++) {
			if(Inventaire.get(i).equip == true) {
				Equiped = getInventaire(i);
				setEquiped(Equiped.get(i));
			}
		}
		return Equiped;
	}
	
*/
	
}
