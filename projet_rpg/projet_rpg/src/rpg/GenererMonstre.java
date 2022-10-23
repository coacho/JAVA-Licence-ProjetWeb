package rpg;

import java.util.ArrayList;
import java.util.Random;

public class GenererMonstre {

	protected String nom;
	protected String classe;
	protected int pv;
	protected static ArrayList<Object> loot;
	protected int xp;
	protected int mana;

	protected static String nomMonstre() {
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
        Monstre.nom = tempnom;
		
		return Monstre.nom;
		
	}
	
	protected static int pvMonstre() {
		int min = 5;
		int max = 100;
		
		int random = (int)(Math.random()*(max-min+1)+min);
		Monstre.pv = random;
		return Monstre.pv;
	}
	
	protected static ArrayList<Object>  lootMonstre() {
		Equipement newloot = Equipement.creationEquipement();
		ArrayList<Object> lootList = new ArrayList<Object>();
		lootList.add(EquipementInterface.nomEquipement(newloot));
		lootList.add(EquipementInterface.propEquipement(newloot));
		lootList.add(EquipementInterface.getAttaqueEquipement(newloot)-1);
		lootList.add(EquipementInterface.getDefenseEquipement(newloot)-1);
		lootList.add(EquipementInterface.getMagieEquipement(newloot)-1);
		loot = lootList;
		return loot;
	}

	
	public static void displayMonstre() {
		pvMonstre();
		System.out.println("monstre nom : "+ Monstre.nom);
		System.out.println("pv : "+ Monstre.pv);
		System.out.println(lootMonstre());
	}

	
}
