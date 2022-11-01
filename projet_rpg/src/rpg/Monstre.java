package rpg;

import java.util.ArrayList;

public class Monstre extends GenererMonstre implements MonstreInterface {

	static String nom;
	static String classe;
	static int pv;
	static ArrayList<Object> loot;
	static int xp;
	static int mana;
	static int attaque;

	private Monstre(String nom, String classe, int pv, ArrayList<Object> loot, int xp, int mana, int attaque){
		super.nom = nom;
		super.classe = classe;
		super.pv = pv;
		super.loot = loot;
		super.xp = xp;
		super.mana = mana;
		super.attaque = attaque;
			
		}
	
	
	public static Monstre creationMonstre() {
		/*nomMonstre();
		lootMonstre();
		pvMonstre();
		attaqueMonstre();
	*/
		Monstre newMonstre = new Monstre(nom,classe,pv,loot,xp,mana,attaque);
		return newMonstre;
		
	}
	
	public static ArrayList <Object> getMonstreStats(int index) {
		
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
	}
	
}
