package rpg;

import java.util.ArrayList;
import java.util.Collection;

public abstract class CreateMap {

	protected Position mapSize= new Position(0,0);
	protected String player;
	protected ArrayList<String>[] grille;
	protected ArrayList<Position> positionAllObstacle = new ArrayList<Position>();
	protected ArrayList<Monstre> listeMonstre = new ArrayList<Monstre>();
	protected Position positionObstacle = new Position(0,0);
	protected Position positionMonstre = new Position(0,0);
	protected Position positionJoueur = new Position(0,0);
	protected Position positionSortie = new Position(0,0);


	public static ArrayList<String>[] generateGrille(int h, int l) {
		ArrayList<String>[] grille;
		grille = createGrille(h,l);
		return grille;
	}

	private static ArrayList<String>[] createGrille(int h, int l){

		@SuppressWarnings("unchecked")
		ArrayList<String>[] grille = new ArrayList[h];
		Collection<String> ligne = new ArrayList<String>();

		for (int lenght = 0; lenght < l; lenght++) {
			ligne.add(null);
			}
		
		for (int height = 0; height < h; height++) {
			for (int lenght = height; lenght < h;lenght++) {
			grille[lenght] = new ArrayList<String>(ligne);
				}
			}
		
		return grille;
	}
	
	
	public Position setmapSize(int h, int l) {
		
		mapSize = new Position(h,l);
		Position.setMapHeight(h);
		Position.setMapLenght(l);

		return mapSize;
	}
	

	public Position getObstaclePosition(){
		positionObstacle = setObstaclePosition(positionObstacle);
		return positionObstacle;
	}
	public Position setObstaclePosition(Position obstacleNew){
		obstacleNew = obstacleNew.positionObstacle();
		return obstacleNew;
	}
	
	public ArrayList<Position> getAllObstaclePosition(){
		positionAllObstacle = setAllObstaclePosition(positionObstacle);
		return positionAllObstacle;	
	}
	public ArrayList<Position> setAllObstaclePosition(Position obstacleNew){
		positionAllObstacle.add(obstacleNew); 
		return positionAllObstacle;	
	}

/*
	@SuppressWarnings("unused")
	private Position getMonstrePosition() {
		positionMonstre = setMonstrePosition(mapSize);
		return positionMonstre;
	}
	private  Position setMonstrePosition(Position monstreNew) {
		positionMonstre = monstreNew.positionMonstre();
		return positionMonstre;
	}
	@SuppressWarnings("unused")
	private Position getJoueurPosition() {
		positionJoueur = setJoueurPosition(positionJoueur);
		return positionJoueur;
	}

	private Position setJoueurPosition(Position joueurNew) {
		positionJoueur = joueurNew.positionJoueur();
	}
s*/
	public int mapLenght(int l) {
		return Position.setMapLenght(l);
	}
	
	public int mapHeight(int h) {
		return Position.setMapHeight(h);
	}

}
