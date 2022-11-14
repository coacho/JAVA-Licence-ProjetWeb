package rpg;

import java.util.ArrayList;

public class Monstre extends GenererMonstre implements MonstreInterface {

	private Monstre(){
		super.nom = nom;
		super.classe = classe;
		super.pv = pv;
		super.loot = loot;
		super.xp = xp;
		super.mana = mana;
		super.attaque = attaque;
		super.position = position;	
		}
	
	static Monstre creationMonstre() {
		
		ArrayList<Object> monstre = new ArrayList<Object>();
		monstre = generate();
		
		String nom = monstre.get(0).toString();
		String classe = monstre.get(1).toString();
		int pv = (int) monstre.get(2);
		Equipement loot = (Equipement) monstre.get(3);
		int xp = (int) monstre.get(4);
		int mana = (int) monstre.get(5);
		int attaque = (int) monstre.get(6);
		Position newPosition = new Position(0,0);
		
		Monstre newMonstre = new Monstre();
		
		newMonstre.nom = nom;
		newMonstre.classe = classe;
		newMonstre.pv = pv;
		newMonstre.loot = loot;
		newMonstre.xp = xp;
		newMonstre.mana = mana;
		newMonstre.attaque = attaque;
		newMonstre.position = newPosition.positionMonstre();
		
		return newMonstre;
		
	}
	
	final static Monstre killMonstre(Monstre m) {
		m.nom = "";
		m.classe = "";
		m.loot = null;
		m.xp = 0;
		m.mana = 0;
		m.attaque = 0;
		return m = null;
	}
	
	public String getNomMonstre() {return nom;}
	public String getClasseMonstre() {return classe;}
	public int getPvMonstre() {return pv;}
	public Equipement getLootMonstre() {return loot;}
	public int getXpMonstre() {return xp;}
	public int getManaMonstre() {return mana;}
	public int getAttaqueMonstre() {return attaque;}
	public Position getpositionX() {return position;}
	public Position getpositionY() {return position;}
	
	/*
	 * public static ArrayList <Object> getMonstreStats(int index) {
		
		String mNom = Monstre.nom;
		String mClasse = Monstre.classe;
		int mPv = Monstre.pv;
		ArrayList<Object> mLoot = Monstre.loot;
		int mXp = Monstre.xp;
		int mMana = Monstre.mana;
		int mAttaque = Monstre.attaque;
				
		ArrayList <Object> statMonstre = new ArrayList <Object>();
		
		statMonstre.add(mNom);
		statMonstre.add(mClasse);
		statMonstre.add(mPv);
		statMonstre.add(mLoot);
		statMonstre.add(mXp);
		statMonstre.add(mMana);
		statMonstre.add(mAttaque);
		
		
		return statMonstre;
		
	}*/
	
}
