package rpg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;


public class Ecran extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4119800958928217134L;
	private JFrame ecran = new JFrame("RPG/20");
	private Map mapCurrent;
	private Joueur joueurCurrent;
	
	private JPanel ecranMap;
	private JPanel ecranDirection;
	private JPanel ecranTexte;

	private InputDirection actionENTER;
	private InputDirection actionUP;
	private InputDirection actionDOWN;
	private InputDirection actionLEFT;
	private InputDirection actionRIGHT;

	
    public Ecran(Map map,Joueur joueur) {
    	
    	this.mapCurrent = map;
    	this.joueurCurrent = joueur;
    	
    	EventQueue.invokeLater(new Runnable() {
            
    		@Override
            public void run() {

            }
        });
    }

	public void initEcran() {
		
		ecran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ecran.setLayout(new BorderLayout());

        actionENTER = new InputDirection(KeyEvent.VK_ENTER, 0,mapCurrent,joueurCurrent, this);
        actionUP = new InputDirection(KeyEvent.VK_UP, 0,mapCurrent,joueurCurrent,this);
        actionDOWN = new InputDirection(KeyEvent.VK_DOWN, 0,mapCurrent,joueurCurrent,this);
        actionLEFT = new InputDirection(KeyEvent.VK_LEFT, 0,mapCurrent,joueurCurrent,this);
        actionRIGHT = new InputDirection(KeyEvent.VK_RIGHT, 0,mapCurrent,joueurCurrent,this);
		
	    ecranMap = new mapPanel().initMapPanel();
        ecranDirection = new directionPanel().initDirectionPanel(mapCurrent, joueurCurrent);
        ecranTexte = new textePanel().initTextePanel();
        
        ecran.getRootPane().setBackground(Color.BLACK);  
        ecran.getRootPane().setBackground(Color.BLACK);  
		
        ecran.setBackground(Color.BLACK);
        ecran.setForeground(Color.BLACK);
        
        ecran.setLocationRelativeTo(null);
		ecran.pack();
        ecran.setResizable(true);
        ecran.setVisible(true);
        ecran.validate();
        
	}

	private class directionPanel extends JPanel {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		JPanel directionPanel = new JPanel();

		
		private JPanel initDirectionPanel(Map map, Joueur j) {

			
			JPanel newJpan = new JPanel();
			
			newJpan.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            newJpan.add(actionUP, gbc);

            gbc.gridy = 2;
            newJpan.add(actionDOWN, gbc);
           
            gbc.gridy = 1;
            gbc.gridx = 1;
            newJpan.add(actionENTER, gbc);
           
            gbc.gridx = 0;
            gbc.gridy = 1;
            newJpan.add(actionLEFT, gbc);

            gbc.gridx = 2;
            newJpan.add(actionRIGHT, gbc);
			
            newJpan.setBackground(Color.BLACK);
            
	        directionPanel.add(newJpan);
	        directionPanel.setBackground(Color.BLACK);
	        
	        ecran.add(directionPanel,BorderLayout.EAST);
	        
			return directionPanel;
	    }
    }
	
	private class mapPanel extends JPanel {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		JPanel mapPanel = new JPanel();
	
		private JPanel initMapPanel() {
	    	
			mapPanel = new EcranMap().EcranMap(mapCurrent);
	        mapPanel.setBackground(Color.BLACK);
	        mapPanel.setVisible(true);
	        mapPanel.validate();
	        
	        ecran.add(mapPanel,BorderLayout.NORTH);
			return mapPanel;
	    }
		
    }
	private class textePanel extends JPanel {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	
		JPanel textePanel = new JPanel();
        
		private JPanel initTextePanel() {
	    	
            textePanel = new EcranTexte().EcranTexte();
            textePanel.setBackground(Color.BLACK);
            textePanel.setVisible(true);
            textePanel.validate();
            
            ecran.add(textePanel,BorderLayout.WEST);
			return textePanel;

		}
    }

	private class InputDirection extends JPanel {

        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public InputDirection(int keyCode, int modifier, Map map, Joueur joueur, Ecran ecran) {

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
					
					ecran.invalidate();
					
					Manette.setKey(keyCode);
                    Manette.waitForKey(map, joueur);
					
                    ecran.ecranMap.setVisible(false);
                    ecran.ecranDirection.setVisible(false);
                    
					ecranMap = new mapPanel().initMapPanel();
					ecranDirection = new directionPanel().initDirectionPanel(map, joueur);
					
					ecran.ecranDirection.setVisible(true);
					ecran.ecranMap.setVisible(true);
			        ecran.setLayout(getLayout());
					ecran.validate();
                    }
            });

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(30, 30);
    	}    
        
    }
	

}
