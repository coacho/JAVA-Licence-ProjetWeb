package rpg;

import java.util.ArrayList;

public class Position implements PositionInterface {

	private int x;
	private int y;
	
	private static int mapLenght;
	private static int mapHeight;
	
	Position(int x, int y) {
	this.x = x;
	this.y = y;
	}
	
	public Position positionMonstre() {

	    int maxh = mapHeight-1;
	    int maxl = mapLenght-1;
	    	
	    y =  (int)(Math.random()*(maxl+1));
		x = (int)(Math.random()*(maxh+1));
		
		return new Position(this.x,this.y);
	}
	

	public Position positionJoueur() {
		
		y = mapHeight-1;
		x = mapLenght-1;

		return new Position(this.y,this.x);
	}


	public Position positionObstacle() {

		int maxh = mapHeight;
		int maxl = mapLenght;
		
		y =  (int)(Math.random()*(maxl+1));
		x = (int)(Math.random()*(maxh+1));
		
		if(x<=0 || y<=0) {
		x = x <= 0 ? x : x++;
		y = y <= 0 ? y : y++;
		}
		
		return new Position(this.x,this.y);
		
	}

	public Position positionSortie() {
		return new Position(0,0);
	}

	public int getMapLenght() {
		mapLenght = setMapLenght(mapLenght);
		return mapLenght;
	}

	public static int setMapLenght(int l) {
		mapLenght = l;
		return mapHeight;
	}
	
	public int getMapHeight() {
		mapHeight = setMapHeight(mapHeight);
		return mapHeight;
	}
	public static int setMapHeight(int h) {
		mapHeight = h;
		return mapHeight;
	}
	public int setPositionX(int x) {
		this.x = x;
		return this.x;	
	}
	public int setPositionY(int y) {
		this.y = y;
		return this.y;	
	}
	public int getPositionX() {
		return this.x;	
	}
	public int getPositionY() {
		return this.y;	
	}
	public ArrayList<Integer> getPosition(){
		ArrayList<Integer> positionXY = new ArrayList<Integer>();
		positionXY.add(this.x);
		positionXY.add(this.y);
		return positionXY;
	}
	@Override
 	public int mapLenght() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int mapHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ArrayList<String>[] grille() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Position mapSize() {
		mapHeight = getMapHeight();
		mapLenght = getMapLenght();
		
		return new Position(mapHeight,mapLenght);
	}


}
