package rpg;

import java.util.ArrayList;

abstract class Magasin {

	static String nom;
	static String type;
	static int argent;
	static ArrayList<Object> inventaireMagasin = new ArrayList<Object>();
	static int indexAchat;
	static int indexVente;

	private Magasin(String nom, String type, String loot, int argent) {
		this.nom =  nom;
		this.type = type;
		this.argent = argent;
	}
	
	private ArrayList<Object> magasinEquiment() {
	
		for (int i=0 ; i<5 ; i++) {
		Equipement magEquipement = Equipement.creationEquipement();
		inventaireMagasin.add(magEquipement);
		}
		return inventaireMagasin;
		
	}
	
	private String magasinHopital() {
		return null;
	}
	
	private void magasinAcheter() {
		Inventaire.ajouter((Equipement) inventaireMagasin.get(indexAchat));
	}
	
	private void magasinVendre(Equipement vente) {
		inventaireMagasin.add(vente);
		//Inventaire.retirer(vente);
	}
}
