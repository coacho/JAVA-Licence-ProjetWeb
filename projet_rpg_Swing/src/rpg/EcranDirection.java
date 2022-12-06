package rpg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

public class EcranDirection extends Manette{
	
	
	public JPanel EcranDirection(Map map, Joueur joueur) {
		
		PanelDirection newPanelDirection =  new PanelDirection();
		JPanel newPanel = new JPanel();
		newPanel = newPanelDirection.PanelDirection(map, joueur);
		return newPanel;
		
	}
	
	 private class PanelDirection extends JPanel {

        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

			public JPanel PanelDirection(Map map, Joueur joueur) {

				JPanel newJpan = new JPanel();
				
				newJpan.setLayout(new GridBagLayout());
	            GridBagConstraints gbc = new GridBagConstraints();
	            gbc.gridx = 1;
	            gbc.gridy = 0;

	            newJpan.add(new InputDirection(KeyEvent.VK_UP, 0,map,joueur), gbc);

	            gbc.gridy = 2;
	            newJpan.add(new InputDirection(KeyEvent.VK_DOWN, 0,map,joueur), gbc);
	           
	            gbc.gridy = 1;
	            gbc.gridx = 1;
	            newJpan.add(new InputDirection(KeyEvent.VK_ENTER, 0,map,joueur), gbc);
	           
	            gbc.gridx = 0;
	            gbc.gridy = 1;
	            newJpan.add(new InputDirection(KeyEvent.VK_LEFT, 0,map,joueur), gbc);

	            gbc.gridx = 2;
	            newJpan.add(new InputDirection(KeyEvent.VK_RIGHT, 0,map,joueur), gbc);
				
	            newJpan.setBackground(Color.BLACK);
	            
	            return newJpan;

	        }


	    }

	 private class InputDirection extends JPanel {

	        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public InputDirection(int keyCode, int modifier, Map map, Joueur joueur) {

	            setBorder(new LineBorder(Color.DARK_GRAY));
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
	                    setBackground(Color.BLACK);
	                    Manette.setKey(keyCode);
	                    Manette.waitForKey(map, joueur);
//	                    
	                    //Ecran refreshEcranGlob = new Ecran(map, joueur);
	                    
	                    //refreshEcranGlob.initEcran();
	                    }
	            });

	        }

	        @Override
	        public Dimension getPreferredSize() {
	            return new Dimension(30, 30);
        	}    
        }
}
