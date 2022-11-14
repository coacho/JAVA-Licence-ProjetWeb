package rpg;

import java.util.ArrayList;
import java.util.Random;

public class GenererMonstre {

	protected String nom;
	protected String classe;
	protected int pv;
	protected Equipement loot;
	protected int xp;
	protected int mana;
	protected int attaque;
	protected Position position;

	private static String nomMonstre() {
		String[] list = {"ll","b","c","d","g","h","j","k","n","m","ss","r","x","z","t","j"};
		String[] list2 = {"a","e","i","o","u","y"};
		String[] list3 = {" - (sick)"," - (elder)"," - (young)", " - (angry)", " - (hungry)"};
		String tempnom = "";
	
		Random rand = new Random();
        for(int i = 1 ; i < 4 ; i++) {
        	tempnom = tempnom + list[rand.nextInt(list.length)];
        	tempnom = tempnom + list2[rand.nextInt(list2.length)];    	
        }
        tempnom = tempnom + list3[rand.nextInt(list3.length)];
		return tempnom.toString();
		
	}
	
	private static String classeMonstre() {
		String classe = "";
		String[] list = {"wolf","troll","bear","duck","possessed duck"};
		Random rand = new Random();
		for(int i = 1 ; i < 4 ; i++) {
			classe = list[rand.nextInt(list.length)];
		}
		return classe;
		
	}

	private static int pvMonstre() {
		int min = 5;
		int max = 100;
		
		int random = (int)(Math.random()*(max-min+1)+min);
		
		return random;
	}
	private static int attaqueMonstre() {
		int min = 5;
		int max = 10;
		
		int random = (int)(Math.random()*(max-min+1)+min);
		return random;
	}	
	private static int xpMonstre() {
		int min = 5;
		int max = 10;
		
		int random = (int)(Math.random()*(max-min+1)+min);
		return random;
	}	
	private static int manaMonstre() {
		int min = 5;
		int max = 10;
		
		int random = (int)(Math.random()*(max-min+1)+min);
		return random;
	}
	
	private static Equipement lootMonstre() {
		Equipement newloot = EquipementInterface.creationEquipement();
		return newloot;
	}
	private static Position position(){
		Position position = new Position(0, 0);
		return position.positionMonstre();
	}

	protected static ArrayList<Object> generate() {
		
		ArrayList<Object> monstre = new ArrayList<Object>();
		
		monstre.add(nomMonstre());
		monstre.add(classeMonstre());
		monstre.add(pvMonstre());
		monstre.add(lootMonstre());
		monstre.add(xpMonstre());
		monstre.add(manaMonstre());
		monstre.add(attaqueMonstre());
		monstre.add(position());
		
		return monstre;
	}
}
