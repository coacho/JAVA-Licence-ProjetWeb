package rpg;

public interface EquipementInterface {

	
	static String nomEquipement(Equipement newEquipement) {return Equipement.nom;}
	static String propEquipement(Equipement newEquipement) {return Equipement.propriete;}
	static int getAttaqueEquipement(Equipement newEquipement) {return Equipement.attaque;}
	static int getDefenseEquipement(Equipement newEquipement) {return Equipement.defense;}
	static int getMagieEquipement(Equipement newEquipement) {return Equipement.magie;}
	
	private static Equipement displayEquipement() {
		return null;
	}
	
	
}
