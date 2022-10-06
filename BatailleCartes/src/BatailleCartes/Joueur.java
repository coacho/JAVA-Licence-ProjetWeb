package BatailleCartes;

import java.util.ArrayList;

public class Joueur {
	
	private Joueur() {
		
	}
	
	public static ArrayList<Carte> getJoueur() {
		ArrayList<Carte> CarteEnJeu = Carte.getCarteEnJeu();
		return  CarteEnJeu ;
	}
	
}
