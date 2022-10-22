package rpg;

public class Equipement extends GenererEquipement implements EquipementInterface{

	static String nom;
	static String propriete;
	static int attaque;
	static int defense;
	static int magie;
	
	private Equipement(String nom, String propriete, int attaque, int defense, int magie) {
		
		super.nom = nom;
		super.propriete = propriete;
		super.attaque = attaque;
		super.defense = defense;
		super.magie = magie;
		
	}
	
	static Equipement creationEquipement() {
		nomEquipement();
		proprieteEquipement();
		statEquipement();
		getAttaque();
		getDefense();
		getMagie();
		Equipement newEquipement = new Equipement(nom,propriete,attaque,defense,magie);
		return newEquipement;
		
	}
}
