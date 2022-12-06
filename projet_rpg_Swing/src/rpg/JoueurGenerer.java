package rpg;

import java.util.ArrayList;
import java.util.Scanner;

 public abstract class JoueurGenerer{

	protected String nom;
	protected int argent;
	protected String classe;
	protected int pv;
	protected int xp;
	protected int mana;
	protected int attaque;
	protected Position position;
	
	static Scanner scan = new Scanner(System.in);
	
	private static String nomJoueur() {
		String nom = "";
		System.out.println("Entrez le nom du personnage : ");
		nom = scan.nextLine();
		return nom;
	}
	private static String classeJoueur() {
		String classe = "";
		System.out.println("Entrez la classe du personnage : ");
		classe = scan.nextLine();
		return classe;
	}
	private static int pvJoueur(){
		int pv = 100;
		return pv;
	}
	private static int argentJoueur(){
		int argent = 0;
		return argent;
	}	
	private static int xpJoueur(){
		int xp = 0;
		return xp;
	}
	private static int manaJoueur(){
		int mana = 0;
		return mana;
	}
	private static int attaqueJoueur(){
		int attaque = 10;
		return attaque;
	}
	private static Position position(){
		Position position = new Position(0,0);
		return position.positionJoueur();
	}

	public static ArrayList<Object> generate() {
		
		ArrayList<Object> joueur = new ArrayList<Object>();
	
			joueur.add(nomJoueur());
			joueur.add(classeJoueur());
			joueur.add(pvJoueur());
			joueur.add(argentJoueur());
			joueur.add(xpJoueur());
			joueur.add(manaJoueur());
			joueur.add(attaqueJoueur());
			joueur.add(position());

			
			return joueur;
	
	}
}