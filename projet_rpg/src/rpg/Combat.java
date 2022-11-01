package rpg;

import java.util.ArrayList;
import java.util.Scanner;

public class Combat {
	
	public static ArrayList<Object> jStats ;
	public static ArrayList<Object> mStats;
	boolean finCombat = false;
	private static int jPv;
	private static int mPv;
	private static int jAttaque;
	private static int mAttaque;
	private static int jMana;
	private static int mMana;
	
	
	private void getStats() {
		
		jStats = getStatsJ();
		mStats = getStatsM();
		
		jPv = getPv(jStats);
		mPv = getPv(mStats);
		jAttaque = getAttaque(jStats);
		mAttaque = getAttaque(mStats);
		jMana = getMana(jStats);
		mMana = getMana(mStats);
		
	}
	void startCombat(Joueur j, Monstre m) {
		
		getStats();
		System.out.print("You encounter an Unknown Monster,");
		monsterMenu();
		//centralMenu();
		
		while ( finCombat == false ) {
			centralMenu();
		}
		endCombatMenu(jPv, mPv);
	}
	
	private void monsterMenu(){
		System.out.println("==============");	
		Monstre.displayMonstre();
		System.out.println("==============");
	}
	
	private void centralMenu() {
		String input;
		
		System.out.println("==============");
		System.out.println("1 - attack");
		System.out.println("2 - inventory");
		System.out.println("3 - flee");
		
		try (Scanner scan = new Scanner(System.in)) {
			input = scan.nextLine();
		}
		switch(input) {
		  case "1":
			  clashCombat();
			  break;
		  case "2":
			  System.out.println("buy our lootbox and get a chance to acces to awsome inventory system");
			  break;
		  case "3":
			  fleeMenu();
			  break;
		default:
			
			
		}

		
	}
	
	private void inventaireMenu() {
		
		
	}
	
	private void fleeMenu() {
		System.out.println("This is not a fight you flee..");	
	}
	
	private void endCombatMenu(int jPv, int mPv) {
		if(jPv <= 0) {
			System.out.println("Le joueur est mort");
		}
		else if(mPv <= 0){
		System.out.println("===================");
		System.out.println("Le monstre est mort");	
		System.out.println("===================");
		}
	}
	
	
	private boolean clashCombat() {
		finCombat = false;
		//while ( jPv >= 0 && mPv >= 0 ) {
			System.out.println("Le joueur attaque avec equipement:+Equipement+ ----- attaque:"+jAttaque+" ------ pv:" + jPv);
			System.out.println("Le Monstre attaque avec equipement:+Equipement+ - attaque:"+mAttaque+" - pv:" + mPv);
			jPv = jPv - mAttaque;
			mPv = mPv - jAttaque;
		//}
			if(jPv <= 0 || mPv <= 0){
				finCombat = true;
				
			}
			return finCombat;
	}
	
	
	private ArrayList<Object> getStatsJ() {
		
		for(int i=0; i<7 ;i++) {
		jStats = Joueur.getJoueurStats(i);
		}
		return jStats;
	}
	
	private ArrayList<Object> getStatsM() {
		
		for(int i=0; i<7 ;i++) {
		mStats = Monstre.getMonstreStats(i);
		}
		return mStats;
	}
	
	private int getMana(ArrayList<Object> stats) {
		int mana = (int) stats.get(5);
		return mana;
		
	}
	
	private int getAttaque(ArrayList<Object> stats) {
		int attaque = (int) stats.get(6);
		return attaque;
		
	}	
	private int getDefense() {
		//defense = (int) statIn.get(2);
		return 0;
		
	}
	private int getPv(ArrayList<Object> stats) {
		int pv = (int) stats.get(2);
		return pv;
		
	}
	
	
}
