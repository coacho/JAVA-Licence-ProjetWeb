package rpg;

import java.awt.AWTException;
import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class RpgMain{

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {

		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
        
		
		Map map1 = Map.newMap(15,15);
		Monstre m1 = MonstreInterface.creationMonstre();
		map1.setListMonstre(m1);
		Monstre m2 = MonstreInterface.creationMonstre();
		map1.setListMonstre(m2);
		Joueur j1 = JoueurInterface.CreationPersonage();
		map1.setPositionJoueur(j1.position);
		Map.remplirMap(map1);
		
		Ecran newEcran = new Ecran(map1, j1);
		newEcran.initEcran();
		

	}

	

}
 