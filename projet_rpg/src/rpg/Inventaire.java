package rpg;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Inventaire {
	
	private static ArrayList<Equipement> Inventaire = new ArrayList<Equipement>();
	private static ArrayList<Equipement> enMain = new ArrayList<Equipement>();
	static Scanner scan = new Scanner(System.in);

	//private static String equip ="";
	
	protected static ArrayList<Equipement> ajouter(Equipement e) {
		Inventaire.add(e);	
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
			Inventaire.clear();
			Inventaire = InventaireTemp;
			InventaireTemp.clear();
		}
		
		return Inventaire;
	}
	
	static void menuInventaire() {
		String input;
		
		System.out.println("==============");
		System.out.println(displayInventaire());
		System.out.println("==============");
		System.out.println("1 - equiper objet");
		
		
		input = scan.nextLine();
		switch(input) {
		  case "1":
			 System.out.println("quel objet ?");
			 equiperEnMain(scan.nextInt());
		default:
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

	private static Equipement equiperEnMain(int i) {
		Equipement e = Inventaire.get(i);
		e.equip = true;
		enMain.add(e);
		return enMain.get(0);
	}

	
}
