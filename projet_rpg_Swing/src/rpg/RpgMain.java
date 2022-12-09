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
        
		Map map1 = Map.newMap(12,12);
		
		Monstre m1 = MonstreInterface.creationMonstre();
		map1.setListMonstre(m1);
		Monstre m2 = MonstreInterface.creationMonstre();
		map1.setListMonstre(m2);
		Monstre m3 = MonstreInterface.creationMonstre();
		map1.setListMonstre(m3);
		Monstre m4 = MonstreInterface.creationMonstre();
		map1.setListMonstre(m4);
		Monstre m5 = MonstreInterface.creationMonstre();
		map1.setListMonstre(m5);
		
		Joueur j1 = JoueurInterface.CreationPersonage();
		map1.setPositionJoueur(j1.position);
		
		map1.remplirMap();
		
		Ecran newEcran = new Ecran(map1, j1);
		newEcran.initEcran();
		

	}

	

}
 