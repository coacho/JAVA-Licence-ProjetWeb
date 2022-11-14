package rpg;

import java.util.ArrayList;

public class Map extends CreateMap {

	
	private Map() {
		
		super.mapSize = mapSize;
		//super.mapLenght = mapLenght;
		super.grille = grille;
		
		super.positionSortie = positionSortie;
		super.positionJoueur = positionJoueur;
		super.positionMonstre = positionMonstre;
		super.positionObstacle = positionObstacle;
		super.positionAllObstacle = positionAllObstacle;
		/*	
		super.graphikSortie = graphikSortie;
		super.graphikJoueur = graphikJoueur;
		super.graphikMonstre = graphikMonstre;
		super.graphikObstacle = graphikObstacle;
	 	*/		
	}
 
	public static Map newMap(int h, int l) {
		ArrayList<String>[] grille;
		grille = generateGrille(h, l);
		
		Map newMap = new Map();
		newMap.setmapSize(h, l);
		
		newMap.grille = grille;
		
		return newMap;
	}
	
    protected static  ArrayList<String>[] remplirMap(Map map) {
	
	   newObstacle(map);
 	   deplacerMonstre(map);
 	   
       int xS = map.positionSortie.getPositionX();
       int yS = map.positionSortie.getPositionY();
    	
       int xJ = map.positionJoueur.getPositionX();
       int yJ = map.positionJoueur.getPositionY();
       
       int xM = map.positionMonstre.getPositionX();
       int yM = map.positionMonstre.getPositionY();
       
       int xO = map.positionObstacle.getPositionX();
       int yO = map.positionObstacle.getPositionY();
       
       int lmap = map.mapSize.getPositionX();
	   int hmap = map.mapSize.getPositionY();
	
	   
	   for (int height = 0; height < hmap ; height++) {
			for(int i = 0; i < lmap ; i++) {
				
				if(map.grille[i].get(height) != "." && map.grille[i].get(height) != "x" ) {
					map.grille[i].set(height, ".");
					}
				
				if(i == xS && height == yS) {
					map.grille[i].set(height, "o");
					}
				if(i == xO && height == yO) {
					map.grille[i].set(height, "x");
				}
				if(i == xM && height == yM && map.grille[i].get(height) != "x" ) {
					map.grille[i].set(height, "m");
					}
				
				if(i == xJ && height == yJ && map.grille[i].get(height) != "x" ) {
					map.grille[i].set(height, "i");
					}
				
			}
	   }
	   
	
		return map.grille;
	   
   }
/*
    protected static  Position déplacerJoueur(Map map, Position p) {
	   int lmap = map.mapSize.getPositionX();
	   int hmap = map.mapSize.getPositionY();
		
	   
	   for (int height = 0; height < hmap ; height++) {
			for(int i = 0; i < lmap ; i++) {
				
				if(map.grille[i].get(height) == "i") {
					map.grille[i].set(height, ".");
					}
				if(p.getPositionX() == map.positionMonstre.getPositionX() && p.getPositionY() == map.positionMonstre.getPositionY()) {
					System.out.println("bagarre!!");//debug
					}
				if(i == p.getPositionX() && height == p.getPositionY()) {
				//map.grille[i].set(height, "i");
				map.positionJoueur.setPositionX(i);
				map.positionJoueur.setPositionY(height);
				}
		 }
	   }
	   
	   
	   return map.positionJoueur;
   }
*/	private static Position newObstacle(Map map) {
	
	Position newObstacle = new Position(0,0);
	
	newObstacle = map.positionObstacle.positionObstacle();
	map.setObstaclePosition(newObstacle);
	
	map.positionAllObstacle.add(map.positionObstacle);
	
	return map.positionObstacle;
	

	}
    
    
    private static Position deplacerMonstre(Map map) {
	   
       int max = 1;
       int min = 0;
       
       int randomMouv = (int)(Math.random()*(max-min+1)+min);
       int randomAxe = (int)(Math.random()*(max-min+1)+min);
       
	   int xJ = map.positionJoueur.getPositionX();
       int yJ = map.positionJoueur.getPositionY();
       
       int xM = map.positionMonstre.getPositionX();
       int yM = map.positionMonstre.getPositionY();
    
	   int distanceX = xJ - xM;
	   int distanceY = yJ - yM;

	   if(distanceX <= 2 || distanceX >= -2 || distanceY <= 2 || distanceY >= -2)
	   if(randomAxe == 1) {
		   if(distanceX <= 2 || distanceX >= -2) {
					if(distanceY <= 0) {
						if(xJ <= xM) {
							map.positionMonstre.setPositionX(xM-1);
								
						}else if(xJ > xM){
							map.positionMonstre.setPositionX(xM+1);
						}
					}
				}
	   }else if(randomAxe ==0) {
			if(distanceY <= 2 || distanceY >= -2) {
				if(distanceX <= 0) {
					if(yJ <= yM) {
						map.positionMonstre.setPositionY(yM-1);
							
					}else if(yJ > yM){
						map.positionMonstre.setPositionY(yM+1);
					}
				}		   
			}
		}
		if(distanceY > 2 && distanceX > 2 || distanceY > -2 && distanceX > -2) {
			if(randomAxe == 1) {
				if(randomMouv == 1) {
					if(xM < map.mapSize.getPositionX()) {
					map.positionMonstre.setPositionX(xM+1);
					}
					else if(xM == map.mapSize.getPositionX()){
						map.positionMonstre.setPositionX(xM-1);
					}
				}
				else {
					if(xM > 0) {
					map.positionMonstre.setPositionX(xM-1);
					}
					else if(xM <= 0) {
					map.positionMonstre.setPositionX(xM+1);
					}
				}
			}
			else if(randomAxe == 0) {
				if(randomMouv == 1) {
					if(yM < map.mapSize.getPositionY()) {
					map.positionMonstre.setPositionY(yM+1);
					}
					else if(yM == map.mapSize.getPositionY()){
						map.positionMonstre.setPositionY(yM-1);
					}
				}
				else {
					if(yM > 0) {
					map.positionMonstre.setPositionY(yM-1);
					}
					else if(yM <= 0) {
					map.positionMonstre.setPositionY(yM+1);
					}
				}

			}
		}
  
		return map.positionMonstre;
   }


	protected static void displayMap(Map map) {
		int lmap = map.mapSize.getPositionX();
		int hmap = map.mapSize.getPositionY();
		
		String ligne = "";
		
		for (int height = 0; height < hmap ; height++) {
			ligne = "";
			for(int i = 0; i < lmap ;i++) {
				ligne = ligne + " " + map.grille[i].get(height);
	            }
	            System.out.println(ligne);
	        }
	}
	
	
	public static Map newPosition() {
		return newPosition();
	}
	
	public Position getPositionSortie() {
		positionSortie = setPositionSortie(positionSortie);
		return positionSortie;}
	public Position setPositionSortie(Position p) {
		positionSortie = p;
		return positionSortie;}
	
	public Position getPositionJoueur() {
		positionJoueur = setPositionJoueur(positionJoueur);
		return positionJoueur;} 
	public Position setPositionJoueur(Position p) {
		positionJoueur = p;
		return positionJoueur;} 
	
	public Position getPositionMonstre() {
		positionMonstre = setPositionMonstre(positionMonstre);
		return positionMonstre;} 
	public Position setPositionMonstre(Position p) {
		positionMonstre = p;
		return positionMonstre;} 
	
	public Position getpositionObstacle() {
		positionObstacle = setPositionObstacle(positionObstacle);
		return positionObstacle;} 
	public Position setPositionObstacle(Position p) {
		positionObstacle = p;
		return positionObstacle;} 
	
	/*
	public String getgraphikSortie() {return graphikSortie;} 
	public String getgraphikJoueur() {return graphikJoueur;} 
	public String getgraphikMonstre() {return graphikMonstre;} 
	public String getgraphikObstacle() {return graphikObstacle;}  
	*/


}
