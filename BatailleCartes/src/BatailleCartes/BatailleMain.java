package BatailleCartes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BatailleMain{

	public static void main(String []args) {
		
		ArrayList<Carte> Jeux = Joueur.getJoueur();
		Collections.shuffle(Jeux);
	
		ArrayList<Carte> Paquet1, Paquet2, Joueur1, Joueur2, Victoire;
 		Paquet1 = new ArrayList<Carte>();
		Paquet2 = new ArrayList<Carte>();
		Joueur1 = new ArrayList<Carte>();
		Joueur2 = new ArrayList<Carte>();
		Victoire = new ArrayList<Carte>();

		int cpt_tour = 0;
		
		System.out.println("Taille Paquet:" + (Jeux).size());
		
		for (int i=0; i<(Jeux).size(); i++)	
		{
			if(i%2==0)
			{
				Paquet1.add((Jeux).get(i));
			}
			else
			{
				Paquet2.add((Jeux).get(i));
			}
		}	

		System.out.println("Taille du paquet de J1:" + Paquet1.size());
		System.out.println("Taille du paquet de J2:" + Paquet2.size());
		
		System.out.println("\nJoueur     Score");
		System.out.println("J1" + " - " + "J2" + " -> " + Paquet1.size() + "/" + Paquet2.size());
		System.out.println("");
		System.out.println("--------------------");
		System.out.println("--------------------");
		System.out.println("");
		
		int bataille = 0;
		String str;
		
		while(Paquet1.size() > 0 && Paquet2.size() > 0)
		{
			Joueur1.add(Paquet1.remove(0)); 
			Joueur2.add(Paquet2.remove(0)); 
			cpt_tour++;
			Joueur2.get(Joueur2.size()-1);
			Joueur1.get(Joueur1.size()-1);
			str = (Carte.getFace() + " -- VS -- " + Carte.getFace()); 
			
			if (bataille > 0)
			{
				bataille--;
				System.out.println(str + " -> Perdu");
			}
			else
			{
				Joueur1.get(Joueur1.size()-1);
				Joueur2.get(Joueur2.size()-1);
				if (Carte.getValeur() > Carte.getValeur())
				{
					Victoire.addAll(Joueur1);
					Victoire.addAll(Joueur2);
					Collections.shuffle(Victoire);
					Paquet1.addAll(Victoire);
					Joueur1.clear();
					Joueur2.clear();
					Victoire.clear();
					str = str + " -> " + Paquet1.size() + "/" + Paquet2.size();
				} else {
					Joueur1.get(Joueur1.size()-1);
					Joueur2.get(Joueur2.size()-1);
					if (Carte.getValeur() < Carte.getValeur())
					{
						Victoire.addAll(Joueur1);
						Victoire.addAll(Joueur2);
						Collections.shuffle(Victoire);
						Paquet2.addAll(Victoire);
						Joueur1.clear();
						Joueur2.clear();
						Victoire.clear();
						str = str + " -> " + Paquet1.size() + "/" + Paquet2.size();
					} else {
						Joueur1.get(Joueur1.size()-1);
						Joueur2.get(Joueur2.size()-1);
						if (Carte.getValeur() == Carte.getValeur())
						{
							bataille++;
							str = str + " -> Bataille";
						}
					}
				}
				System.out.println(str);
			}
		}
		
		if (Paquet1.size() == 0 && Paquet2.size() > 0)
		{
			System.out.println("\nLe Joueur2 gagne !");	
		}
		else if (Paquet1.size() > 0 && Paquet2.size() == 0)
		{
			System.out.println("\nLe Joueur1 gagne !");
		}
		else if (Paquet1.size() == 0 && Paquet2.size() == 0)
		{
			System.out.println("\nFin de partie!");	
		}
		
		System.out.println("Le jeu s'est terminer en " + cpt_tour + " tours.");
	}

}
