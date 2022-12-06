package rpg;

import java.util.ArrayList;

public class ListeMonstre{

	//private ArrayList<Monstre> listeMonstre =  new ArrayList<Monstre>();
	private static ArrayList<Monstre> listeMonstre = new ArrayList<Monstre>();
	private static Monstre monstreInList;

	public static ArrayList<Monstre> setListMonstre(Monstre monstre) {
		listeMonstre.add(monstre);
		//listeMonstre.monstreInList = monstre;
		return listeMonstre;
	}
	
	private static Monstre getMonstreInList(Monstre monstre) {
		monstreInList = listeMonstre.get(listeMonstre.indexOf(monstre));
		return monstreInList;
		
	}
	public static ArrayList<Monstre> getListMonstre(ArrayList<Monstre> listm) {
		return listm;
		
	}
	
}
