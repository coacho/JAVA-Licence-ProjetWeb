package rpg;

import java.util.ArrayList;
import java.util.Random;

public class Map extends MapCreate{

	
	private Map() {
		
		super.mapSize = mapSize;
		super.grille = grille;
		
		super.positionSortie = positionSortie;
		super.positionJoueur = positionJoueur;
		super.positionMonstre = positionMonstre;
		super.positionObstacle = positionObstacle;
		super.positionAllObstacle = positionAllObstacle;
		super.listeMonstre = listeMonstre;
	
	}
	
	//crée une nouvelle map
	public static Map newMap(int h, int l) {
		ArrayList<String>[] grille;
 		grille = generateGrille(h, l);
		
		Map newMap = new Map();
		newMap.setmapSize(h, l);
		
		newMap.grille = grille;
		
		for (int o = 0; o < ((h+l)*2) ; o++) {
			newMap.positionObstacle = newObstacle(newMap);
		}
		
		return newMap;
	}
	
	//affiche la map en console
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
	
    protected void remplirMap() {
    	
       int xS = this.positionSortie.getPositionX();
       int yS = this.positionSortie.getPositionY();
    	
       int xJ = this.positionJoueur.getPositionX();
       int yJ = this.positionJoueur.getPositionY();
       
       int lmap = this.mapSize.getPositionX();
	   int hmap = this.mapSize.getPositionY();

       ArrayList<Integer> pointeurList = new ArrayList<Integer>();
       Position pointeur = new Position(0,0);

	   for (int height = 0; height < hmap ; height++) {
			for(int i = 0; i < lmap ; i++) {
				
				pointeur = new Position(i,height);	
				
				this.grille[i].set(height, null);
				
				if(this.grille[i].get(height) == null ) {
					this.grille[i].set(height, " ");
					}
				
				for(int iO = 0; iO < this.positionAllObstacle.size() ; iO++) {
				    ArrayList<Integer> pointeurP = pointeur.getPosition();
					pointeurList = this.positionAllObstacle.get(iO).getPosition();
					if(pointeurList.equals(pointeurP)) {
						this.grille[i].set(height, "x");
					}
				}
				
				for(int iM = 0; iM < this.listeMonstre.size(); iM++) {
					ArrayList<Integer> pointeurP = pointeur.getPosition();  
				    pointeurList = this.listeMonstre.get(iM).position.getPosition();
						if(pointeurList.equals(pointeurP)) {
							this.grille[i].set(height, "m");
						}
				}

				if(i == xS && height == yS) {
					this.grille[i].set(height, "o");
					}
				if(i == xJ && height == yJ) {
					this.grille[i].set(height, "i");
					}
		   }
	   }  
    }
    
    public static Position deplacerJoueur(int x, int y, Map map) {
    	
    	//Parcour la liste des obstacles et interdit leur position au joueur
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
    
    public static void playMonstre(Map map) {
    	
    	//parcour la liste de monstre et initie un déplacement
    	for(int iM = 0; iM < map.listeMonstre.size(); iM++) {
			map.listeMonstre = mouvMonstres(map,map.listeMonstre.get(iM));
		}
    }
    
    private static ArrayList<Monstre> mouvMonstres(Map map, Monstre monstre) {
        
    		int max = 1;
            int min = -1;
            
    		Random rand = new Random();
        	int randAxe = (int)(Math.random()*(max-min+1)+min);
        	int randMouv = rand.nextInt(2) * 2 - 1;    	

        	int xJ = map.positionJoueur.getPositionX();
            int yJ = map.positionJoueur.getPositionY();
    		
    		int xM = monstre.position.getPositionX();
	 	    int yM = monstre.position.getPositionY();
	 	   
	 	    int distanceX = xJ - xM;
	 	    int distanceY = yJ - yM;
	 	  
	 	    //génère un mouvement au monstre en fonction d'un axe random 1=x ou 0=y et d'un mouvement 1 ou -1
	 	    // si la distance en le X du joueur et le x du Montre et leurs y est <= 4  ou >-4 le monstre prend pour axe celui qui le rapproche le plus du joueur
	 	    if(yM + randMouv >= 0 && xM + randMouv >= 0 && xM + randMouv < map.mapSize.getPositionX() && yM + randMouv < map.mapSize.getPositionY()) {
		 	    	if(distanceX > 0 || distanceY > 0 ) {
		 	    		if(randAxe == 0) {
		 	    			 monstre.position.setPositionX(xM + randMouv);
		 	    			 monstre.position.setPositionY(yM);
		 	    		}
		 	    		else if(randAxe == 1) {
		 	    			 monstre.position.setPositionY(yM + randMouv);
		 	    			 monstre.position.setPositionX(xM);
		 	    		}
		 	    	}
		 	    	else if(distanceX+distanceY >= 4 && distanceX+distanceY < 0 || distanceX+distanceY > -4) {
		 	    		if(distanceX == 2) {
		 	    			 monstre.position.setPositionX(xM + 1);
		 	    			 monstre.position.setPositionY(yM);
		 	    		}
		 	    		else if(distanceX == -2) {
		 	    			 monstre.position.setPositionX(xM - 1);
		 	    			 monstre.position.setPositionY(yM);
		 	    		}
		 	    		else if(distanceY == 2) {
		 	    			 monstre.position.setPositionY(yM + randMouv);
		 	    			 monstre.position.setPositionX(xM);
		 	    		}
		 	    		else if(distanceY == -2) {
		 	    			 monstre.position.setPositionY(yM + randMouv);
		 	    			 monstre.position.setPositionX(xM);
		 	    		}
		 	    	}
		 	    	
		 	    }
	 	    
	 	    //parcour la liste des position d'Obstacle et les compare avec la position du monstre en cour
	 	   for(int iO = 0; iO < map.positionAllObstacle.size() ; iO++) {
	 		  
	 		  int vXO = map.positionAllObstacle.get(iO).getPositionX();
	 		  int vYO = map.positionAllObstacle.get(iO).getPositionY();
	 		  int vXM = monstre.position.getPositionX();
	 		  int vYM = monstre.position.getPositionY();
	 				  
		 	  if(vXO == vXM && vYO == vYM || -vXO == -vXM && -vYO == vYM) {
		 		 
		 		 //System.out.println(vXM+ -";"+ vYM + " || " + vXO +";" + vYO) ;
		 		 
		 		 monstre.position.setPositionX(xM);
			 	 monstre.position.setPositionY(yM);
			 	 Map.mouvMonstres(map, monstre);
			 	 
		 	  	}
	    	}
	    
    	return map.listeMonstre;    	
    }

    private static Position newObstacle(Map map) {
    	
    	//génère une liste d'obstacle avec une liste de positions
		Position newObstacle = new Position(0,0);
		map.positionObstacle = newObstacle.positionObstacle();
		map.positionAllObstacle.add(map.positionObstacle);
		
		return map.positionObstacle;
	
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
	//
	public ArrayList<Monstre> setListMonstre(Monstre m) {
		listeMonstre.add(m);
		return listeMonstre;} 
	
}
