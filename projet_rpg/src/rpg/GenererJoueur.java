package rpg;

import java.util.ArrayList;
import java.util.Scanner;

 public class GenererJoueur{

	protected String nom;
	protected int argent;
	protected String classe;
	protected int pv;
	protected int xp;
	protected int mana;
	protected int attaque;
	static Scanner scan = new Scanner(System.in);
	
	private static String nomMonstre() {
		String nom = "";
		System.out.println("Entrez le nom du personnage : ");
		nom = scan.nextLine();
		return nom;
	}
	private static String classeMonstre() {
		String classe = "";
		System.out.println("Entrez la classe du personnage : ");
		//Scanner scan = new Scanner(System.in);
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
	public static ArrayList<Object> generate() {
		
		ArrayList<Object> joueur = new ArrayList<Object>();
	
			joueur.add(nomMonstre());
			joueur.add(classeMonstre());
			joueur.add(pvJoueur());
			joueur.add(argentJoueur());
			joueur.add(xpJoueur());
			joueur.add(manaJoueur());
			joueur.add(attaqueJoueur());

			
			return joueur;
	
	}
}