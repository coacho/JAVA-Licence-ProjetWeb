package rpg;

import java.util.ArrayList;

public interface JoueurInterface {
	
	public static Joueur CreationPersonage() {
		return null;
	}
	
	public static Joueur display() {
		return null;
	}

	public static ArrayList<Object> JoueurStats(int index) {
		return Joueur.getJoueurStats(index);
	}
	

}
