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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;


public class EcranMap{


	private ArrayList<String>[] grille;

	public JPanel EcranMap(Map map) {
		
		PanelMap newPanelMap =  new PanelMap();
		JPanel newPanel = new JPanel();
		newPanel = newPanelMap.PanelMap(map);
		return newPanel;
		
	}
	
	private class PanelMap extends JPanel {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public JPanel PanelMap(Map map) {
				
			JPanel ecranGrille = new JPanel();

			grille = map.grille;
		
			JPanel grillePanel = new JPanel();
			
			StringBuilder grilleArea = new StringBuilder();
	
			
			for(Object obj: grille) {
				if(grilleArea.length() > 0) {
					grilleArea.append("\n");
				}
				grilleArea.append(String.valueOf(obj));
			}
			
			JTextArea textGrilleArea = new JTextArea(grilleArea.toString()); // longueur
			
//			textGrilleArea.setFont(textGrilleArea.getFont().deriveFont(12f)); 
//			textGrilleArea.setForeground(Color.lightGray);			
//			textGrilleArea.setBackground(Color.BLACK);
			textGrilleArea.add(new InputDirection(KeyEvent.VK_UP,0, map));
			textGrilleArea.setEditable(false); 
			textGrilleArea.setActionMap(null); 
			
		    grillePanel.add(textGrilleArea);
		    grillePanel.setForeground(Color.lightGray);		
		    grillePanel.setBackground(Color.BLACK);
		    grillePanel.setVisible(true);
		   
		    
		    ecranGrille.add(grillePanel,BorderLayout.NORTH);
		    //ecranGrille.add(new InputDirection(KeyEvent.VK_UP,0, map));
			   
		    
		    
//		    new InputDirection(KeyEvent.VK_UP,0, map);
//		    new InputDirection(KeyEvent.VK_DOWN,0, map);
//		    new InputDirection(KeyEvent.VK_LEFT,0, map);
//		    new InputDirection(KeyEvent.VK_RIGHT,0, map);
//		    
//		    new InputDirection(KeyEvent.VK_ENTER,0, map);

		    return ecranGrille;

		}	 
		
		private class InputDirection extends JPanel {

	        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public InputDirection(int keyCode, int modifier, Map map) {
				
			    Font poulet = new Font("Roboto", Font.BOLD, 12);
				setFont(poulet); 
				setForeground(Color.lightGray);			
				setBackground(Color.BLACK);
				
				
	            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
	            ActionMap am = getActionMap();

	            im.put(KeyStroke.getKeyStroke(keyCode, modifier, false), "keyPressed");
	            im.put(KeyStroke.getKeyStroke(keyCode, modifier, true), "keyReleased");

	            
	            am.put("keyPressed", new AbstractAction() {
	                /**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
	                public void actionPerformed(ActionEvent e) {
	                    setBackground(Color.LIGHT_GRAY);
					}
	            });

	            am.put("keyReleased", new AbstractAction() {
	                /**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
	                public void actionPerformed(ActionEvent e) {
			            
						am.put("keyPressed", new AbstractAction() {
			                /**
							 * 
							 */
							private static final long serialVersionUID = 1L;

							@Override
			                public void actionPerformed(ActionEvent e) {
			                    setBackground(Color.LIGHT_GRAY);
			                    
							}
			            });

			            am.put("keyReleased", new AbstractAction() {
			                /**
							 * 
							 */
							private static final long serialVersionUID = 1L;

							@Override
			                public void actionPerformed(ActionEvent e) {
			                 
								grille = map.grille;
								
								new JPanel();
								
								StringBuilder grilleArea = new StringBuilder();
						
								
								for(Object obj: grille) {
									if(grilleArea.length() > 0) {
										grilleArea.append("\n");
									}
									grilleArea.append(String.valueOf(obj));
								}
								
								new JTextArea(grilleArea.toString());
								
							}
			            });
	                    }
	            });
				
		
				}
			}
	}

	
}
