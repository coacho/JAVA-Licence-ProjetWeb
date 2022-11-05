package rpg;

import java.util.ArrayList;

public class Joueur extends GenererJoueur implements JoueurInterface{


	private Joueur() {
		
		super.nom = nom;
		super.classe = classe;
		super.pv = pv;
		super.argent = argent;
		super.xp = xp;
		super.mana = mana;
		super.attaque = attaque;
	}
	
	static Joueur creationPersonage() {

		ArrayList<Object> joueurArray = new ArrayList<Object>();
		joueurArray = generate();
		
		String nom = joueurArray.get(0).toString();
		String classe = joueurArray.get(1).toString();
		int pv = (int) joueurArray.get(2);
		int argent  = (int) joueurArray.get(3);;
		int xp = (int) joueurArray.get(4);;
		int mana = (int) joueurArray.get(5);;
		int attaque = (int) joueurArray.get(6);;
		
		Joueur newJoueur = new Joueur();
		newJoueur.nom = nom;
		newJoueur.classe = classe;
		newJoueur.pv = pv;
		newJoueur.argent = argent;
		newJoueur.xp = xp;
		newJoueur.mana = mana;
		newJoueur.attaque = attaque;
		
		return newJoueur;
	}
	
	public String getNomJoueur() {return nom;}
	public String getClasseJoueur() {return classe;}
	public int getPvJoueur() {return pv;}
	public int getArgentJoueur() {return argent;}
	public int getXpJoueur() {return xp;}
	public int getManaJoueur() {return mana;}
	public int getAttaqueJoueur() {return attaque;}
	
}
