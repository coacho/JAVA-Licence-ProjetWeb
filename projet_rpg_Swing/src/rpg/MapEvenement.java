package rpg;

public class MapEvenement {

	public static String checkEventMap(Map map, Joueur j) {
		
		String event = "";
		
		for(int iM = 0; iM < map.listeMonstre.size() ; iM++) {
		
			Monstre m = map.listeMonstre.get(iM);
				
			if(map.positionJoueur.getPosition().equals(m.position.getPosition()) ) {
				Combat newCombat = new Combat();
				newCombat.startCombat(j,m);
			 }
			
		}
		
		return event;	
	}
	
	
}
