package rpg;

import java.util.ArrayList;

abstract class Inventaire {

	static ArrayList<Object> Inventaire;
	
	protected static ArrayList<Object> ajouter(Equipement newEquipement) {
		
		if (newEquipement != null){
			Inventaire.add(newEquipement);
		}
			
		return Inventaire;
	}
	
	protected static ArrayList<Object> retirer(Equipement trashEquipement){
		
		ArrayList<Object> InventaireTemp = new ArrayList<Object>();
		
		if (trashEquipement != null){
			int index = Inventaire.indexOf(trashEquipement);
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
	
	protected String displayInventaire() {
		
		
		return "Inventaire : " + Inventaire.toString();
		
	}

	
	
}
