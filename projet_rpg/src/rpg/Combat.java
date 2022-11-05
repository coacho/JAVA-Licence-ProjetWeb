package rpg;

import java.util.ArrayList;
import java.util.Scanner;

public class Combat {

	public static ArrayList<Object> mStats = new  ArrayList<Object>();
	public static ArrayList<Object> jStats = new  ArrayList<Object>();
	boolean monstreMort = false;
	boolean	joueurMort = false;
	boolean finCombat = false;
	private static int jPv;
	private static int mPv;
	private static int jAttaque;
	private static int mAttaque;
	private static int jMana;
	private static int mMana;
	Scanner scan = new Scanner(System.in);
	
	
	private void getStats(Joueur j, Monstre m) {
		
		jStats = getStatsJ(j);
		mStats = getStatsM(m);
		
		jPv = getPv(jStats);
		mPv = getPv(mStats);
		jAttaque = getAttaque(jStats);
		mAttaque = getAttaque(mStats);
		jMana = getMana(jStats);
		mMana = getMana(mStats);
		
	}
	
	void startCombat(Joueur j, Monstre m) {
		
		getStats(j,m);
		System.out.println("==============");
		System.out.print("You encounter an Unknown Monster,");
		System.out.println();
		monsterMenu(m);
		//centralMenu();
		
		while ( finCombat == false ) {
			centralMenu();
		}
		endCombatMenu(jPv, mPv);
		
		if(joueurMort == true){
			System.out.println("joueurmort");
			
		}
		else if(monstreMort == true) {
			killMonstre(m);
		}

	}
	
	private void monsterMenu(Monstre m){
		System.out.println("==============");
		System.out.println(m.getNomMonstre() +" - " + m.getClasseMonstre());
		System.out.println("pv: " + m.getPvMonstre());
		System.out.println("loot: " + m.getLootMonstre().nom);
		System.out.println("xp: " + m.getXpMonstre());
		System.out.println("mana: " + m.getManaMonstre());
		System.out.println("attaque: " + m.getAttaqueMonstre());
		System.out.println("==============");
	}
	
	private void centralMenu() {
		String input;
		
		System.out.println("==============");
		System.out.println("1 - attack");
		System.out.println("2 - inventory");
		System.out.println("3 - flee");
		System.out.println("==============");
		
		input = scan.nextLine();
		switch(input) {
		  case "1":
			  clashCombat();
			  break;
		  case "2":
			  Inventaire.menuInventaire();
			  break;
		  case "3":
			  fleeMenu();
			  break;
		default:
		}
	}
	
	private void fleeMenu() {
		System.out.println("This is not a fight you flee..");	
	}
	
	private void endCombatMenu(int jPv, int mPv) {
		
		if(jPv <= 0) {
			System.out.println("===================");
			System.out.println("Le joueur est mort");
			System.out.println("===================");
			monstreMort = false;
			joueurMort = true;
		}
		else if(mPv <= 0){
		System.out.println("===================");
		System.out.println("Le monstre est mort");	
		System.out.println("===================");
		monstreMort = true;
		joueurMort = false;
		}
	}
	
	private boolean clashCombat() {
		finCombat = false;
		jPv = jPv - mAttaque;
		System.out.println("Le joueur attaque avec equipement:+Equipement+ ----- attaque:"+jAttaque+" ------ pv:" + jPv);
		mPv = mPv - jAttaque;
		System.out.println("Le Monstre attaque avec equipement:+Equipement+ - attaque:"+mAttaque+" - pv:" + mPv);
			
		if(jPv <= 0 || mPv <= 0){
			finCombat = true;
				
		}
		return finCombat;
	}
	
	private Monstre killMonstre(Monstre m) {
		Monstre.killMonstre(m);
		return m = null;
	}
	/*
	private Joueur killJoueur(Joueur j) {
		Joueur.killJoueur(j);
		return j = null;
	}
	*/
	private ArrayList<Object> getStatsJ(Joueur j) {
		
		for(int i=0; i<7 ;i++) {
		jStats.add(j.getNomJoueur());
		jStats.add(j.getClasseJoueur());
		jStats.add(j.getPvJoueur());
		jStats.add(j.getArgentJoueur());
		jStats.add(j.getXpJoueur());
		jStats.add(j.getManaJoueur());
		jStats.add(j.getAttaqueJoueur());
		}
		return jStats;
	}
	
	
	private ArrayList<Object> getStatsM(Monstre m) {

		
		for(int i=0; i<7 ;i++) {
		mStats.add(m.getNomMonstre());
		mStats.add(m.getClasseMonstre());
		mStats.add(m.getPvMonstre());
		mStats.add(m.getLootMonstre());
		mStats.add(m.getXpMonstre());
		mStats.add(m.getManaMonstre());
		mStats.add(m.getAttaqueMonstre());
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
