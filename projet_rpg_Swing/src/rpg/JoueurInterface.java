package rpg;

public interface JoueurInterface {

	
	static String getNomJoueur(Joueur e) {
		return e.getNomJoueur();
		}
	static String getClasseJoueur(Joueur e) {
		return e.getClasseJoueur();	
		}

	static int getPvJoueur(Joueur e) {
		return e.getPvJoueur();	
		}
	static int getXpJoueur(Joueur e) {
		return e.getXpJoueur();	
		}
	static int getManaJoueur(Joueur e) {
		return e.getManaJoueur();	
		}
	static int getAttaqueJoueur(Joueur e) {
		return e.getAttaqueJoueur();	
		}
	public static Joueur CreationPersonage() {
		return Joueur.creationPersonage();
	}

	

}
