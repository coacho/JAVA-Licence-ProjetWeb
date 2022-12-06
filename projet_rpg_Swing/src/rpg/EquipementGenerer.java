		package rpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EquipementGenerer{

	public String nom;
	public String propriete;
	public static String propPrivate;
	public int attaque = 0;
	public int defense = 0;
	public int magie = 0;
	public boolean equip = false;
	
	private static int randomEquipement() {
		int min = 0;
		int max = 6;
		int random = (int)(Math.random()*(max-min+1)+min);
		return random;
	}
	
	private static String nomEquipement() {
		Random rand = new Random();
		int specialUnlock = randomEquipement();
		
		List<String> typelist = new ArrayList<>();

		String[] listArme = {"sword","axe","hammer","stick"};
		String[] listeArmor = {"plastron","helmet","shield"};
		String[] listeSpecial = {"football","spoon","beatles album"};
		String select = "";

		if(specialUnlock == 5) {
		typelist.add(listeSpecial[rand.nextInt(listeSpecial.length)]);
		}
		else {
		typelist.add(listArme[rand.nextInt(listArme.length)]);
		typelist.add(listeArmor[rand.nextInt(listeArmor.length)]);  
		}
		
		//System.out.println(specialTest); //test
		select = typelist.get(rand.nextInt(typelist.size()));
		
        return select.toString();
	}
	
	private static String proprieteEquipement() {
		String select = "";
		Random rand = new Random();
		
		List<String> propList = new ArrayList<>();
		String[] prop = {"tin","iron","silver","gold","wood","leather"};
		
		propList.add(prop[rand.nextInt(prop.length)]);
		select = propList.get(rand.nextInt(propList.size()));
		propPrivate = select.toString();
		
        return select.toString();
	}
	
	private static int[] statEquipement() {
		
		int[] dirt = {0,0,0};
		int[] tin = {2,1,randomEquipement()};
		int[] iron = {3,5,randomEquipement()};
		int[] silver = {4,3,randomEquipement()};
		int[] gold = {5,4,randomEquipement()};
		int[] wood = {1,1,randomEquipement()};
		int[] leather = {0,2,randomEquipement()};
		
		switch(propPrivate) {
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
	
	private static int getAttaque() {
		return statEquipement()[0];
		}

	private static int getDefense() {
		return statEquipement()[1];
		}
	private static int getMagie() {
		return statEquipement()[2];
		}
	
	protected static ArrayList<Object> generate() {
		ArrayList<Object> equipement = new ArrayList<Object>();
		
		equipement.add(nomEquipement());
		equipement.add(proprieteEquipement());
		equipement.add(statEquipement());
		equipement.add(getAttaque());
		equipement.add(getDefense());
		equipement.add(getMagie());
		
		return equipement;
	}

}
