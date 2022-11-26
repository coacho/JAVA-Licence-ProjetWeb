package rpg;


public interface MonstreInterface  {

	
	static String getNomMonstre(Monstre m) {
		return m.getNomMonstre();
		}
	static String getClasseMonstre(Monstre m) {
		return m.getClasseMonstre();
		}
	static int getPvMonstre(Monstre m) {
		return m.getPvMonstre();
		}
	static Equipement getLootMonstre(Monstre m) {
		return m.getLootMonstre();
		}
	static int getXpMonstre(Monstre m) {
		return m.getXpMonstre();
		}
	static int getManaMonstre(Monstre m) {
		return m.getManaMonstre();
		}
	static int getAttaqueMonstre(Monstre m) {
		return m.getAttaqueMonstre();
		}
	static Monstre creationMonstre() {
		return Monstre.creationMonstre();
		}
	static Monstre killMonstre(Monstre m) {
		return Monstre.killMonstre(m);
		}
	
	
}
