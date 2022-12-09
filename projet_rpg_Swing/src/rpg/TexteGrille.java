package rpg;

import java.util.ArrayList;
import java.util.Collection;

public class TexteGrille {


	public ArrayList<String>[] grille;
	public Collection<String> ligne;
	public int h ; //= Map.newPosition().positionJoueur.getPositionX(); 
	public int l ; //= Map.newPosition().positionJoueur.getPositionY();
	
	
	public TexteGrille(String ligneContent) {
		
		this.grille = createGrilleTexte(ligneContent);
	}

	@SuppressWarnings("unchecked")
	private ArrayList<String>[] createGrilleTexte(String ligneContent){

		h = 10;//Map.newPosition().positionJoueur.getPositionX(); 
		l = 10; //Map.newPosition().positionJoueur.getPositionY(); 
		
		grille = new ArrayList[h];
		ligne = new ArrayList<String>();

		for (int lenght = 0; lenght < l; lenght++) {
			ligne.add(ligneContent);
			}
		
		for (int height = 0; height < h; height++) {
			for (int lenght = height; lenght < h;lenght++) {
			grille[lenght] = new ArrayList<String>(ligne);
				}
			}
		
		return grille;
	}
	
	
	
	
}
