package rpg;

import java.util.Scanner;

abstract class CreationPersonage{

	protected String nom;
	protected int argent;
	protected String classe;
	protected int pv;
	protected int xp;
	protected int mana;

	public CreationPersonage() {
		
		System.out.println("Entrez le nom du personnage : ");
			
		try {
			Scanner scan = new Scanner(System.in);
			Joueur.nom = scan.nextLine();
			
			System.out.println("Entrez la classe du personnage : ");
			scan = new Scanner(System.in);
			Joueur.classe = scan.nextLine();
			Joueur.pv = 100;
			Joueur.argent = 0;
			Joueur.xp = 0;
			Joueur.mana = 0;
			}
			catch(Exception e) {
				
			};
	
	}
}