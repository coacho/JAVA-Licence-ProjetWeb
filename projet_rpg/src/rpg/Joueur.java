package rpg;

import java.util.ArrayList;

public class Joueur extends CreationPersonage implements JoueurInterface{

	static String nom;
	static String classe;
	static int pv;
	static int argent;
	static int xp;
	static int mana;
	static int attaque;


	private Joueur(String nom, String classe, int pv, int argent, int xp, int mana,int attaque) {
		
		super.nom = nom;
		super.classe = classe;
		super.pv = pv;
		super.argent = argent;
		super.xp = xp;
		super.mana = mana;
		super.attaque = attaque;
	}
	
	static Joueur creationPersonage() {
		Joueur newJoueur = new Joueur(nom,classe,pv,argent,xp,mana,attaque);
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
	
	public static ArrayList <Object> getJoueurStats(int index) {
		
		String jNom = Joueur.nom;
		String JClasse = Joueur.classe;
		int jPv = Joueur.pv;
		int Jargent = Joueur.argent;
		int xp = Joueur.xp;
		int mana = Joueur.mana;
		int attaque = Joueur.attaque;
				
		ArrayList <Object> statJoueur = new ArrayList <Object>();
		
		statJoueur.add(jNom);
		statJoueur.add(JClasse);
		statJoueur.add(jPv);
		statJoueur.add(Jargent);
		statJoueur.add(xp);
		statJoueur.add(mana);
		statJoueur.add(attaque);
		
		
		return statJoueur;
	}
	
}
