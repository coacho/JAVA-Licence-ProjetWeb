package rpg;

public interface EquipementInterface {

	static String getNomEquipement(Equipement e) {
		return e.getNomEquipement();
		}
	static String getPropEquipement(Equipement e) {
		return e.getPropEquipement();	
		}
	static int getAttaqueEquipement(Equipement e) {
		return e.getAtaqueEquipement();	
		}
	static int getDefenseEquipement(Equipement e) {
		return e.getDefenseEquipement();	
		}
	static int getMagieEquipement(Equipement e) {
		return e.getMagieEquipement();	
		}
	static Equipement creationEquipement() {
		return Equipement.creationeEquipement();
		}
	
}
