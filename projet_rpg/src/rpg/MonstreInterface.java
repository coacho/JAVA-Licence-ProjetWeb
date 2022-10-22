package rpg;

import java.util.ArrayList;

public interface MonstreInterface  {

	static String genererNom() {return Monstre.nom;}
	static int pvMonstre() {return Monstre.pv;}
	static ArrayList<Object> lootMonstre() {return Monstre.loot;}
	static Monstre displayMonstre() {return null;}
	
	
}
