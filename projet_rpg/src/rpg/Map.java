package rpg;

import java.util.ArrayList;
import java.util.Collection;

public class Map {

	private static String statusOut;
	private static int mapLenght;
	private static int mapHeight;
	private static String player;
	private static ArrayList<String>[] map;
	private static ArrayList<ArrayList<Integer>> positionAllObstacle = new ArrayList<ArrayList<Integer>>();
	private static ArrayList<Integer> positionObstacle = new ArrayList<Integer>();
	private static ArrayList<Integer> positionMonstre = new ArrayList<Integer>();
	private static ArrayList<Integer> positionJoueur = new ArrayList<Integer>();
	private static ArrayList<Integer> positionSortie = new ArrayList<Integer>();
	
	public static void generateMap(String grathoK, int h, int l) {
		setPlayer(grathoK);
		createMap(h,l);
	}
	
	public static void setMap(Joueur j, Monstre m) {
		remplirMap(j,m);
		displayMap();
		checkEvent(j,m);
	}
	
	@SuppressWarnings("unchecked")
	private static ArrayList<String>[] createMap(int l, int h){
		
		setmapHeight(h);
		setmapLenght(l);
		
		mapHeight = getmapHeight();
		mapLenght = getmapLenght();
		
		ArrayList<String>[] map = new ArrayList[mapHeight];
		Collection<String> ligne = new ArrayList<String>();

		for (int lenght = 0; lenght < mapLenght+1; lenght++) {
			ligne.add(null);
			}
		
		for (int height = 0; height < h; height++) {
			for (int lenght = height; lenght < mapHeight;lenght++) {
			map[lenght] = new ArrayList<String>(ligne);
				}
			}
		setMap(map);
		return map;

	}
	
	private static ArrayList<String>[] remplirMap(Joueur j , Monstre m){
		player = getPlayer();
		map = getMap();
		positionMonstre = getMonstrePosition(m);
		positionJoueur = getJoueurPosition(j);
		positionObstacle = getObstaclePosition();
		positionSortie = getSortiePosition();
		
		for (int height = 0; height < mapHeight ; height++) {
			for(int i = 0; i < mapLenght ; i++) {
				if(i == 0 && height == 0) {
					map[i].set(height, "o");
					}
				if(map[i].get(height) == null) {
					map[i].set(height, ".");
					}
				if(map[i].get(height) == player) {
					map[i].set(height, ".");
					}
				if(map[i].get(height) == "m") {
					map[i].set(height, ".");
					}
				if(map[i].get(height) == "x") {
					map[i].set(height, "x");
					}
				if(i == positionJoueur.get(0) && height == positionJoueur.get(1)) {
					if(map[i].get(height) != "x" ) {
						map[i].set(height, player);
						setJoueurPosition(i,height);
					}
					}
				if(i == positionObstacle.get(0) && height == positionObstacle.get(1)) {
					map[i].set(height, "x");
					}
				if(i == positionMonstre.get(0) && height == positionMonstre.get(1)) {
					map[i].set(height, "m");
					//setMonstrePosition(height,i,m);
					}
				if(positionJoueur == positionMonstre) {
					map[i].set(height, "i/vs/m");
				}
				}
			}
		return map;
	}
	
	private static String checkEvent(Joueur j, Monstre m) {
		positionSortie.add(0,0);
		positionSortie.add(1,0);
		player = getPlayer();
		map = getMap();
		
		positionMonstre = getMonstrePosition(m);
		positionJoueur = getJoueurPosition(j);
		setStatusOut("");
		statusOut = getStatusOut();
		
		if(positionMonstre.get(0) == positionJoueur.get(0) && positionMonstre.get(1) == positionJoueur.get(1)) {
			setStatusOut("bagarre");
		}
		/*if(positionAllObstacle.contains(positionJoueur.get(0)) && positionAllObstacle.contains(positionJoueur.get(1))) {
			setStatusOut("obstacle");
			System.out.println("obstacle");
		}*/
		if(positionSortie.get(0) == positionJoueur.get(0) && positionSortie.get(1) == positionJoueur.get(1)) {
			System.out.println("WIN");
			Manette.gameStatus = false;
		}
		return statusOut;
	}

	protected static void displayMap() {
		map = getMap();
		String ligne = "";
		for (int height = 0; height < mapHeight ; height++) {
			ligne = "";
			for(int i = 0; i < mapLenght ;i++) {
				ligne = ligne + " " +map[i].get(height);
	            }
	            System.out.println(ligne);
	        }
	}

	
	protected static int getmapHeight() {
		return mapHeight;
	}
	protected static int getmapLenght() {
		return mapHeight;
	}
	
	private static  ArrayList<Integer> getSortiePosition(){
	positionSortie = setSortiePosition(positionSortie);
		return positionSortie;
	}
	private static  ArrayList<Integer> setSortiePosition(ArrayList<Integer> positionSortie){
		positionSortie = PositionMap.setPositionSortie();
		return positionSortie;
	}
	
	private static  ArrayList<Integer> getObstaclePosition(){
		positionObstacle = setObstaclePosition(positionObstacle);
		return positionObstacle;
	}
	private static  ArrayList<Integer> setObstaclePosition(ArrayList<Integer> obstacleNew){
		obstacleNew = PositionMap.setPositionObstacle();
		positionAllObstacle.add(obstacleNew);
		return obstacleNew;
	}
	
	private static ArrayList<String>[] getMap(){
		return map;
	}
	private static ArrayList<String>[] setMap(ArrayList<String>[] tempMap){
		map = tempMap;
		return map;
	}
	private static String setPlayer(String grathoK) {
		player = grathoK;
		return grathoK;
	}
	private static String getPlayer() {
		return player;
	}
	
	private static ArrayList<Integer> getMonstrePosition(Monstre m) {
		positionMonstre = m.position;
		return positionMonstre;
	}
	private static ArrayList<Integer> setMonstrePosition(int xm,int ym,Monstre m) {
		m.position.set(0,xm);
		m.position.set(1,ym);
		return positionMonstre;
	}
	private static ArrayList<Integer> getJoueurPosition(Joueur j) {
		positionJoueur = j.position;
		return positionJoueur;
	}
	private static ArrayList<Integer> setJoueurPosition(int x,int y) {
		positionJoueur.set(0,x);
		positionJoueur.set(1,y);
		return positionJoueur;
	}
	private static int setmapHeight(int h) {
		mapHeight = h;
		return mapHeight;
	}
	private static int setmapLenght(int l) {
		mapHeight = l;
		return mapHeight;
	}

	
	public static String getStatusOut() {
		return statusOut;
	}

	private static void setStatusOut(String statusOut) {
		Map.statusOut = statusOut;
	}
	
	
}
