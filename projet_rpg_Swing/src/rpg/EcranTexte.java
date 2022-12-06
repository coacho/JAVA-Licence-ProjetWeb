package rpg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class EcranTexte {
	
	String ligne = "ligne";
	ArrayList<String> grille = new ArrayList<String>();

	JPanel ecranGrille = new JPanel();
	
	
	JPanel EcranTexte() {
			
		grille.add(ligne);
		grille.add(ligne);
		grille.add(ligne);
		grille.add(ligne);
	
    	//Panneau contenant ecran.grille
		JPanel grillePanel = new JPanel();
		//grillePanel.setLayout(new FlowLayout());
		
		//Instantiation ecran.grille dans une new TextArea
		StringBuilder grilleArea = new StringBuilder();

		
		for(Object obj: grille) {
			if(grilleArea.length() > 0) {
				grilleArea.append("\n");
			}
			grilleArea.append(String.valueOf("__________"));
		}
		
		JTextArea textGrilleArea = new JTextArea(grilleArea.toString()); // longueur
		
		textGrilleArea.setFont(textGrilleArea.getFont().deriveFont(12f)); // taille font	
		textGrilleArea.setForeground(Color.lightGray);			
		textGrilleArea.setBackground(Color.BLACK);
		textGrilleArea.setEditable(false); 
		textGrilleArea.setActionMap(null); //ne pas enlever!! fait planter les direction sans
		
		
	    grillePanel.add(textGrilleArea);
	    grillePanel.setForeground(Color.lightGray);		
	    grillePanel.setBackground(Color.BLACK);
	    grillePanel.setVisible(true);
	    ecranGrille.add(grillePanel,BorderLayout.NORTH);
		
	    return ecranGrille;
	    
	    }
	
}
