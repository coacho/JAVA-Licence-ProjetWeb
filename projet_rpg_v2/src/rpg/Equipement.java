package rpg;

import java.util.ArrayList;

public class Equipement extends GenererEquipement implements EquipementInterface{

	String nom;
	String propriete;
	int attaque;
	int defense;
	int magie;
	boolean equip = false;
	
	private Equipement() {
		
		super.nom = nom;
		super.propriete = propriete;
		super.attaque = attaque;
		super.defense = defense;
		super.magie = magie;
		super.equip = equip;
		
	}
	
	static Equipement creationEquipement() {
		
		ArrayList<Object> equipement = new ArrayList<Object>();
		equipement = generate();
		
		String nom = equipement.get(0).toString();
		String propriete = equipement.get(1).toString();
		int attaque = (int) equipement.get(3);
		int defense = (int) equipement.get(4);
		int magie = (int) equipement.get(5);
		
		Equipement newEquipement = new Equipement();
		
		newEquipement.nom = nom;
		newEquipement.propriete = propriete;
		newEquipement.attaque = attaque;
		newEquipement.defense = defense;
		newEquipement.magie = magie;
		
		return newEquipement;
		
	}

	public String getNomEquipement() {return nom;}
	public String getPropEquipement() {return propriete;}
	public int getAtaqueEquipement() {return attaque;}
	public int getDefenseEquipement() {return defense;}
	public int getMagieEquipement() {return magie;}
	
}
