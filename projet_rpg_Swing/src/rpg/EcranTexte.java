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
	
    	JPanel grillePanel = new JPanel();
		
		StringBuilder grilleArea = new StringBuilder();

		
		for(Object obj: grille) {
			if(grilleArea.length() > 0) {
				grilleArea.append("\n");
			}
			grilleArea.append(String.valueOf("__________"));
		}
		
		JTextArea textGrilleArea = new JTextArea(grilleArea.toString());
		
		textGrilleArea.setFont(textGrilleArea.getFont().deriveFont(12f)); 	
		textGrilleArea.setForeground(Color.lightGray);			
		textGrilleArea.setBackground(Color.BLACK);
		textGrilleArea.setEditable(false); 
		
		
	    grillePanel.add(textGrilleArea);
	    grillePanel.setForeground(Color.lightGray);		
	    grillePanel.setBackground(Color.BLACK);
	    grillePanel.setVisible(true);
	    ecranGrille.add(grillePanel,BorderLayout.NORTH);
		
	    return ecranGrille;
	    
	    }
	
}
