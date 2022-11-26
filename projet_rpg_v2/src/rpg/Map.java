package rpg;

import java.util.ArrayList;
import java.util.Random;

public class Map extends CreateMap{

	
	private Map() {
		
		super.mapSize = mapSize;
		super.grille = grille;
		
		super.positionSortie = positionSortie;
		super.positionJoueur = positionJoueur;
		super.positionMonstre = positionMonstre;
		super.positionObstacle = positionObstacle;
		super.positionAllObstacle = positionAllObstacle;
		super.listeMonstre = listeMonstre;
		//super.postionInterdite = positionInterdire;
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
		
		for (int o = 0; o < (h+l) ; o++) {
			newMap.positionObstacle = newObstacle(newMap);
		}
		
		return newMap;
	}
	
    protected static ArrayList<String>[] remplirMap(Map map) {
    	
       int xS = map.positionSortie.getPositionX();
       int yS = map.positionSortie.getPositionY();
    	
       int xJ = map.positionJoueur.getPositionX();
       int yJ = map.positionJoueur.getPositionY();
       
       int xM = map.positionMonstre.getPositionX();
       int yM = map.positionMonstre.getPositionY();

       int lmap = map.mapSize.getPositionX();
	   int hmap = map.mapSize.getPositionY();

       ArrayList<Integer> pointeurList = new ArrayList<Integer>();
       Position pointeur = new Position(0,0);

       mouvMonstres(map);
       
	   for (int height = 0; height < hmap ; height++) {
			for(int i = 0; i < lmap ; i++) {
				
				pointeur = new Position(i,height);	
				
				map.grille[i].set(height, null);
				
				if(map.grille[i].get(height) == null ) {
					map.grille[i].set(height, ".");
					}
				
				for(int iO = 0; iO < map.positionAllObstacle.size() ; iO++) {
				    ArrayList<Integer> pointeurP = pointeur.getPosition();
					pointeurList = map.positionAllObstacle.get(iO).getPosition();
					if(pointeurList.equals(pointeurP)) {
						map.grille[i].set(height, "x");
					}
				}
				
				for(int iM = 0; iM < map.listeMonstre.size(); iM++) {
					ArrayList<Integer> pointeurP = pointeur.getPosition();  
				    pointeurList = map.listeMonstre.get(iM).position.getPosition();
						if(pointeurList.equals(pointeurP)) {
							map.grille[i].set(height, "m");
						}
				}

				if(i == xS && height == yS) {
					map.grille[i].set(height, "o");
					}
				if(i == xJ && height == yJ) {
					map.grille[i].set(height, "i");
					}
		   }
	   }  
	   
		return map.grille;
	   
    }
    
    private static Position newObstacle(Map map) {
	
	Position newObstacle = new Position(0,0);
	map.positionObstacle = newObstacle.positionObstacle();
	map.positionAllObstacle.add(map.positionObstacle);
	
	return map.positionObstacle;
	
    }
    
    public static Position deplacerJoueur(int x, int y, Map map) {
    	
    	for(int iO = 0; iO < map.positionAllObstacle.size() ; iO++) {
    		if(map.positionAllObstacle.get(iO).getPosition().get(0) == x && map.positionAllObstacle.get(iO).getPosition().get(1) == y) {
				if(map.mapSize.getPositionX()> x && map.mapSize.getPositionY() > y) {
				x = map.positionJoueur.getPositionX();
				y = map.positionJoueur.getPositionY();
				}
			}
    	}
    	
    	map.positionJoueur.setPositionX(x);
    	map.positionJoueur.setPositionY(y);
    	
    	return map.positionJoueur;
    }
    
    
    private static ArrayList<Monstre> mouvMonstres(Map map) {
        
    	for(int iM = 0; iM < map.listeMonstre.size(); iM++) {
    	
        	int max = 1;
            int min = -1;
            
    		Random rand = new Random();
        	int randAxe = (int)(Math.random()*(max-min+1)+min);
        	int randMouv = rand.nextInt(2) * 2 - 1;    	

        	
        	int xJ = map.positionJoueur.getPositionX();
            int yJ = map.positionJoueur.getPositionY();
    		
    		int xM = map.listeMonstre.get(iM).position.getPositionX();
	 	    int yM = map.listeMonstre.get(iM).position.getPositionY();
	 	    
	 	   map.positionMonstre = map.listeMonstre.get(iM).position;		
	 	    
	 	    int distanceX = xJ - xM;
	 	    int distanceY = yJ - yM;
	 	  
	 	    if(yM + randMouv >= 0 && xM + randMouv >= 0 && xM + randMouv < map.mapSize.getPositionX() && yM + randMouv < map.mapSize.getPositionY()) {
		 	    	if(distanceX > 0 || distanceY > 0 ) {
		 	    		if(randAxe == 0) {
		 	    			map.positionMonstre.setPositionX(xM + randMouv);
		 	    			map.positionMonstre.setPositionY(yM);
		 	    		}
		 	    		else if(randAxe == 1) {
		 	    			map.positionMonstre.setPositionY(yM + randMouv);
		 	    			map.positionMonstre.setPositionX(xM);
		 	    		}
		 	    	}
		 	    	else if(distanceX+distanceY >= 4 && distanceX+distanceY < 0 || distanceX+distanceY > -4) {
		 	    		if(distanceX == 2) {
		 	    			map.positionMonstre.setPositionX(xM + 1);
		 	    			map.positionMonstre.setPositionY(yM);
		 	    		}
		 	    		else if(distanceX == -2) {
		 	    			map.positionMonstre.setPositionX(xM - 1);
		 	    			map.positionMonstre.setPositionY(yM);
		 	    		}
		 	    		else if(distanceY == 2) {
		 	    			map.positionMonstre.setPositionY(yM + randMouv);
		 	    			map.positionMonstre.setPositionX(xM);
		 	    		}
		 	    		else if(distanceY == -2) {
		 	    			map.positionMonstre.setPositionY(yM + randMouv);
		 	    			map.positionMonstre.setPositionX(xM);
		 	    		}
		 	    	
		 	    	}
		 	    	
		 	    }

		   for(int iO = 0; iO < map.positionAllObstacle.size() ; iO++) {
	    		if(map.positionAllObstacle.get(iO).getPositionX() == map.positionMonstre.getPositionX() && map.positionAllObstacle.get(iO).getPositionY() == map.positionMonstre.getPositionY()) {
	    			if(map.positionMonstre.getPositionX() == 0 && map.positionMonstre.getPositionY() == map.mapSize.getPositionY() ) {
		    			map.positionMonstre.setPositionX(xM);
		    			map.positionMonstre.setPositionY(yM);
		    			map.listeMonstre.get(iM).position = map.positionMonstre;
		    			mouvMonstres(map);
	    			}
				}
	    	}

			map.listeMonstre.get(iM).position = map.positionMonstre;
    	}
    
    	return map.listeMonstre;    	
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
	
	public ArrayList<Monstre> setListMonstre(Monstre m) {
		listeMonstre.add(m);
		return listeMonstre;} 
	
	/*
	public String getgraphikSortie() {return graphikSortie;} 
	public String getgraphikJoueur() {return graphikJoueur;} 
	public String getgraphikMonstre() {return graphikMonstre;} 
	public String getgraphikObstacle() {return graphikObstacle;}  
	*/


}
