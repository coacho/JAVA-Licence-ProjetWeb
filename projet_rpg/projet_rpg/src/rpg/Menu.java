package rpg;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	static String ligneLimit = "";
	static String ligneInterieur = "";
	
	static List<String> limitHB = new ArrayList<>();
	static List<String> interieur = new ArrayList<>();
	
	
	public static void genererMenuVide(int taille) {
		
		int largeur = taille+1;
		int hauteur = taille;
		int lenghtMenu = 0;
		String contourText =" ";
		String text = "eee rrr aaa eeeeeeee";

		for(int i = 0; i <= largeur ; i++) {
			limitHB.add("--");
		}
		for(int i = 0; i <= largeur ; i++) {
			interieur.add("  ");
		}
		
		for(int h = 0; h < largeur;h++ ) {
		    for (int i = 0; i <= largeur; i++) {   
	        	ligneLimit = ligneLimit + limitHB.get(i);
		       }
		    if(h == largeur-1) {
	        	System.out.println(ligneLimit+"--");
			}
	    }
		
        for(int h = 0; h <= hauteur;h++ ) {
	        for (int i = 0; i <= largeur; i++) {
	        	ligneInterieur = ligneInterieur + interieur.get(h);
	        } 
	        if(h == hauteur) {
            	ligneInterieur = "|"+ligneInterieur+"|";
            	for(int hh = 0; hh< hauteur; hh++) {
            		if (hh % 2 ==  0) {
            			lenghtMenu = (ligneInterieur.length() - (text.length()));
            			for(int t = 0; t < lenghtMenu/2 ; t++)
            			{
            				if (contourText.length()*2 < lenghtMenu) {
            					contourText = contourText + " ";
            					}
            			}
            			System.out.println("|"+contourText + text + contourText+"|");
            		} else {
            			System.out.println(ligneInterieur);
            		}
        		}
            }
        }
        System.out.println(ligneLimit+"--");
	}
	

	
}
