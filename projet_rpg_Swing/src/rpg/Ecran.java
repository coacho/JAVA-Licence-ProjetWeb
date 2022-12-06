package rpg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Ecran {

	
	private JFrame ecran = new JFrame("RPG/20");
	private Map mapCurrent;
	private Joueur joueurCurrent;
	
	private EcranDirection ecranDirection = new EcranDirection();
	private EcranTexte ecranTexte = new EcranTexte();
    private EcranMap ecranMap = new EcranMap();
    
    public Ecran(Map map,Joueur joueur) {
    	 
    	mapCurrent = map;
    	joueurCurrent = joueur;
    	
    	EventQueue.invokeLater(new Runnable() {
            
    		@Override
            public void run() {

            }
        });
    }

	@SuppressWarnings("unused")
	public void initEcran() {
		
		ecran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ecran.setLayout(new BorderLayout());
	       
        mapPanel newMap = new mapPanel();
        textePanel newTexte = new textePanel();
        directionPanel newDirection = new directionPanel();
        
        ecran.getContentPane().setBackground(Color.BLACK);
        ecran.getContentPane().setForeground(Color.BLACK);
        ecran.setLocationRelativeTo(null);
		ecran.pack();
        ecran.setResizable(true);
        ecran.setVisible(true);
    
	}
	
	private class directionPanel extends JPanel {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public directionPanel() {
			initDirectionPanel(mapCurrent, joueurCurrent);
		}
		
		private void initDirectionPanel(Map map, Joueur j) {
	    	
	        JPanel directionPanel = new JPanel();
	        
	        directionPanel = ecranDirection.EcranDirection(map,j);
	        directionPanel.setBackground(Color.BLACK);
	        ecran.add(directionPanel,BorderLayout.EAST);
	    }
    }
	private class mapPanel extends JPanel {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public mapPanel() {
			initMapPanel();
		}
		
		private void initMapPanel() {
	    	
	        JPanel mapPanel = new JPanel();
	        
	        mapPanel = ecranMap.EcranMap(mapCurrent);
	        mapPanel.setBackground(Color.BLACK);
	        ecran.add(mapPanel,BorderLayout.NORTH);
	    }
    }
	private class textePanel extends JPanel {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public textePanel() {
			initTextePanel();
		}
		
		private void initTextePanel() {
	    	
	        JPanel textePanel = new JPanel();
	        
            textePanel = ecranTexte.EcranTexte();
            textePanel.setBackground(Color.BLACK);
	        ecran.add(textePanel,BorderLayout.WEST);
            }
    }
    
   

}
