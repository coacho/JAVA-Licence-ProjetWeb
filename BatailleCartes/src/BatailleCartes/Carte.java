package BatailleCartes;

import java.util.ArrayList;

public class Carte {

	private static int valeur;
	private static String face;
public static String couleur;
	private static ArrayList<Carte> CarteEnJeu = new ArrayList<Carte>();
	
	private Carte(String couleur, int valeur) {
		Carte.couleur = couleur;
		Carte.valeur= valeur;
	}
	
	static ArrayList<Carte> getCarteEnJeu() {
		int valeurs[] =  {2,3,4,5,6,7,8,9,10,11,12,13,14};
		String [] couleurs = {"coeur","carreau","treffle","pics"};	
		for(int refcolor=0; refcolor<4; refcolor++)
		{
			for(int refvaleur=0; refvaleur<13; refvaleur++) 
				{
				couleur = couleurs[refcolor];
				valeur = valeurs[refvaleur];
				Carte newCarte = new Carte(couleur,valeur); //Probleme instanciation newCarte prend pas couleur et valeur mais son adresse?!.
				CarteEnJeu.add(newCarte);
				System.out.println(newCarte); 
				System.out.println(couleur+" - "+ valeur +" - " + getFace() );
				}
			}
		
		;
		return CarteEnJeu;
	}

	protected static int getValeur() {
		return valeur;
	}
	
	
	protected static String getFace() {
	
			if (Carte.valeur == 11)
				face = "valet ";
			else if (Carte.valeur == 12)
				face = "dame ";
			else if (Carte.valeur == 13)
				face = "roi ";
			else if (Carte.valeur == 14)
				face = "as ";
			else
				face ="";
			return face;
	}


	
	
}
