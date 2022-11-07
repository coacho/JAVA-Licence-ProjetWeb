package rpg;

import java.util.ArrayList;


public class PositionMap extends Map{
	
	static ArrayList<Integer> positionMonstre = new ArrayList<Integer>();
	static ArrayList<Integer> positionJoueur = new ArrayList<Integer>();
	static ArrayList<Integer> positionObstacle = new ArrayList<Integer>();
	static ArrayList<Integer> positionSortie = new ArrayList<Integer>();
	
	private static ArrayList<Integer> positionMonstre() {
		
		int x;
		int y;

		int maxh = getmapHeight()-2;
		int maxl =  getmapLenght()-2;
		
		y =  (int)(Math.random()*(maxl+1));
		x = (int)(Math.random()*(maxh+1));
		positionMonstre.add(0,x);
		positionMonstre.add(1,y);
		return positionMonstre;
	}
	public static ArrayList<Integer> setPositionMonstre() {
		positionMonstre = positionMonstre();
		return positionMonstre;
	}
	public ArrayList<Integer> getPositionMonstre() {
		return positionMonstre;
	}
	
	private static ArrayList<Integer> positionJoueur() {
		
		int x =  getmapLenght()-1;
		int y = getmapHeight()-1;
		
		positionJoueur.add(x);
		positionJoueur.add(y);
		
		return positionJoueur;
	}
	public static ArrayList<Integer> setPositionJoueur() {
		positionJoueur = positionJoueur();
		return positionJoueur;
	}
	public ArrayList<Integer> getPositionJoueur() {
		return positionJoueur;
	}

	private static ArrayList<Integer> positionObstacle() {
			
			int x;
			int y;
	
			int maxh = getmapHeight()-2;
			int maxl =  getmapLenght()-2;
			
			y =  (int)(Math.random()*(maxl+1));
			x = (int)(Math.random()*(maxh+1));
			positionObstacle.add(0,x);
			positionObstacle.add(1,y);
			return positionObstacle;
		
	}
		public static ArrayList<Integer> setPositionObstacle() {
			positionObstacle = positionObstacle();
			return positionObstacle;
		}
		public ArrayList<Integer> getPositionObstacle() {
			return positionObstacle;
		}

	private static ArrayList<Integer> positionSortie() {
			positionSortie.add(0);
			positionSortie.add(0);
			return positionSortie;
	}
		public static ArrayList<Integer> setPositionSortie() {
			positionSortie = positionObstacle();
			return positionSortie;
		}
		public ArrayList<Integer> getPositionSortie() {
			return positionSortie;
		}
}
