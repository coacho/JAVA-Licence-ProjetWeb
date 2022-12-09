package rpg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;


public class EcranMap extends JPanel {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String>[] grille;

	public JPanel EcranMap(Map map) {
		
		EcranMap newPanel = new EcranMap();
		PanelMap newPanelMap =  new PanelMap();
		newPanel = newPanelMap.PanelMap(map);
		return newPanel;
		
	}
	
	private class PanelMap extends JPanel {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public StringBuilder setMap(Map map) {
			
			grille = map.grille;
			
			StringBuilder grilleArea = new StringBuilder();
			
			for(Object obj: grille) {
				if(grilleArea.length() > 0) {
					grilleArea.append("\n");
				}
				grilleArea.append(String.valueOf(obj.toString()));
			}
			return grilleArea;	
		}
		
		public EcranMap PanelMap(Map map) {
				
			EcranMap ecranGrille = new EcranMap();
			JPanel grillePanel = new JPanel();
			
			JTextArea textGrilleArea = new JTextArea(setMap(map).toString()); 			
		
//			new Font("Serif",Font.BOLD,30);
//			Font poulet = new Font("Roboto", Font.BOLD, 12);
	
			textGrilleArea.setFont(textGrilleArea.getFont().deriveFont(12f)); 
			textGrilleArea.setForeground(Color.lightGray);			
			textGrilleArea.setBackground(Color.BLACK);
			
			textGrilleArea.setEditable(false);
			textGrilleArea.validate();
			textGrilleArea.setVisible(true);
			textGrilleArea.setActionMap(null); 
			
		    grillePanel.add(textGrilleArea);
		    grillePanel.setForeground(Color.lightGray);		
		    grillePanel.setBackground(Color.BLACK);
		    grillePanel.setVisible(true);
		    
		    ecranGrille.add(grillePanel,BorderLayout.NORTH);
		    ecranGrille.validate();
		    
		    return ecranGrille;

		}	 
			}
}