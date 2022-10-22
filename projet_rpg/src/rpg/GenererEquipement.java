package rpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenererEquipement {

	public static String nom;
	public static String propriete;
	public static int attaque;
	public static int defense;
	public static int magie;
	private static Random rand = new Random();
	private static boolean special = false;
	private static int specialUnlock = randomEquipement();
	
	private static int randomEquipement() {
		
		int min = 0;
		int max = 6;
		
		int random = (int)(Math.random()*(max-min+1)+min);
		
		return random;
		
	}
	
	
	public static String nomEquipement() {
		
		List<String> typelist = new ArrayList<>();

		String[] listArme = {"sword","axe","hammer","stick"};
		String[] listeArmor = {"plastron","helmet","shield"};
		String[] listeSpecial = {"football","spoon","beatles album"};
		String select;
		//int specialUnlock = testrand;  
		//specialUnlock = 5; //test
		
		if(specialUnlock == 5) {
		typelist.add(listeSpecial[rand.nextInt(listeSpecial.length)]);
		special = true;
		}
		else {
		typelist.add(listArme[rand.nextInt(listArme.length)]);
		typelist.add(listeArmor[rand.nextInt(listeArmor.length)]);
		}
		
		//System.out.println(specialTest); //test
		select = typelist.get(rand.nextInt(typelist.size()));
		Equipement.nom = select.toString();
		
        return Equipement.nom ;
	}
	
	protected static String proprieteEquipement() {
		String select;
		
		List<String> propList = new ArrayList<>();
		String[] prop = {"tin","iron","silver","gold","wood","leather"};
		
		propList.add(prop[rand.nextInt(prop.length)]);
		select = propList.get(rand.nextInt(propList.size()));
		Equipement.propriete = select.toString();
		//Equipement.propriete = propList[rand.nextInt(propList.length)].toString();
		
        return Equipement.propriete;
	}
	
	protected static int[] statEquipement() {
		
		int[] dirt = {0,0,0};
;		int[] tin = {2,1,randomEquipement()};
		int[] iron = {3,5,randomEquipement()};
		int[] silver = {4,3,randomEquipement()};
		int[] gold = {5,4,randomEquipement()};
		int[] wood = {1,1,randomEquipement()};
		int[] leather = {0,2,randomEquipement()};
		//int[] special = {0,0,9};
		
		switch(Equipement.propriete) {
		  case "tin":
			return tin;
		case "iron":
			 return iron;
		  case "silver":
			  return silver;
		  case "gold":
			  return gold;
		  case "wood":
			  return wood;
		  case "leather":
			  return leather;
		  default:
			  return dirt;
		}
	}
	
	protected static int getAttaque() {
		return Equipement.attaque = statEquipement()[0];
		}

	protected static int getDefense() {
		return Equipement.defense = statEquipement()[1];
		}
	protected static int getMagie() {
		return Equipement.magie  = statEquipement()[2];
		}
	
	public static void displayEquipement() {
		System.out.println("Equipement nom : "+ Equipement.nom);
		System.out.println(Equipement.propriete);
		System.out.println(Equipement.attaque);
		System.out.println(Equipement.defense);
		System.out.println(Equipement.magie);
	
		//System.out.println(statEquipement());
	}


	
	
	
}
