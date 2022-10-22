package rpg;

import java.util.ArrayList;

public class Monstre extends GenererMonstre implements MonstreInterface {

	static String nom;
	static String classe;
	static int pv;
	static ArrayList<Object> loot;
	static int xp;
	static int mana;

	private Monstre(String nom, String classe, int pv, ArrayList<Object> loot, int xp, int mana){
		super.nom = nom;
		super.classe = classe;
		super.pv = pv;
		super.loot = loot;
		super.xp = xp;
		super.mana = mana;
			
		}
	
	
	public static Monstre creationMonstre() {
		nomMonstre();
		lootMonstre();
		Monstre newMonstre = new Monstre(nom,classe,pv,loot,xp,mana);
		return newMonstre;
		
	}
	
	
}
