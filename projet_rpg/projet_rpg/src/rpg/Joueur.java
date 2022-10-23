package rpg;


public class Joueur extends CreationPersonage implements JoueurInterface{

	static String nom;
	static String classe;
	static int pv;
	static int argent;
	static int xp;
	static int mana;


	private Joueur(String nom, String classe, int pv, int argent, int xp, int mana) {
		
		super.nom = nom;
		super.classe = classe;
		super.pv = pv;
		super.argent = argent;
		super.xp = xp;
		super.mana = mana;
	}
	
	static Joueur creationPersonage() {
		Joueur newJoueur = new Joueur(nom,classe, pv,argent,xp,mana);
		return newJoueur;
	}
	
	public static void displayJoueur() {
		System.out.println("nom : " + nom);
		System.out.println("classe: "+ classe);
		System.out.println("pv : " + pv);
		System.out.println("argent : " + argent);
		System.out.println("xp : " + xp);
		System.out.println("mana : "+ mana);
	}
	
}
