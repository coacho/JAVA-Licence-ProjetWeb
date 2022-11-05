package rpg;

import java.util.ArrayList;
import java.util.Collection;

abstract class Map {

	private static int mapLenght;
	private static int mapHeight;
	private static ArrayList<String>[] map;
	
	private static ArrayList<String>[] createMap(int l, int h){
		
		//mapLenght =  l;
		mapHeight = h;
		
		ArrayList<String>[] map = new ArrayList[mapHeight];
		Collection<String> ligne = new ArrayList<String>();

		for (mapLenght = 0; mapLenght < l; mapLenght++) {
			ligne.add(null);
			}
		
		for (int height = 0; height < mapHeight; height++) {
			for (int lenght = height; lenght< mapHeight;lenght++) {
			map[lenght] = new ArrayList<String>(ligne);
			}
			}

		return map;

	}
	
	private static ArrayList<String>[] remplirMap(ArrayList<String>[] map, int x,int y, String grathiK, int h, int l){
		for (mapHeight = 0; mapHeight < h ; mapHeight++) {
			for(int i = 0; i<map.length;i++) {
				if(map[i].get(mapHeight) == null) {
					map[i].set(mapHeight, ".");
					
					}
				if(i == x-1 && mapHeight == y-1) {
					map[i].set(mapHeight, grathiK);
					
					}	
				}
			
			}
		return map;
	}

	private static void displayMap(ArrayList<String>[] map,int l, int h) {
		  
		String ligne = "";
		for (mapHeight = 0; mapHeight < h ; mapHeight++) {
			ligne = "";
			//System.out.println(map[mapHeight]);
			for(int i = 0; i < l ;i++) {
				ligne = ligne + " " +map[i].get(mapHeight);
				
	            }
	            System.out.println(ligne);
	        }
	}

	
	public static void generateMap(String grathoK, int h, int l, int x,int y) {
		displayMap(remplirMap(createMap(h,l),x,y,"i",h,l),l,h);
	}
	
}
