package rpg;

import java.util.ArrayList;

public class Equipement extends GenererEquipement implements EquipementInterface{

	String nom;
	String propriete;
	int attaque;
	int defense;
	int magie;
	
	private Equipement() {
		
		super.nom = nom;
		super.propriete = propriete;
		super.attaque = attaque;
		super.defense = defense;
		super.magie = magie;
		
	}
	
	static Equipement creationeEquipement() {
		
		String nom = generate().get(0).toString();
		String propriete = generate().get(1).toString();
		int attaque = (int) generate().get(3);
		int defense = (int) generate().get(4);
		int magie = (int) generate().get(5);
		
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
