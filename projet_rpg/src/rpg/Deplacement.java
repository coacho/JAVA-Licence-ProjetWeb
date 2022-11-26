package rpg;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Deplacement extends JPanel  {

	
		   private static final int PREF_W = 400;

		   public void ArrowTest() {
		      setFocusable(true);
		      requestFocusInWindow();

		      addKeyListener(new KeyAdapter() {

		         @Override
		         public void keyTyped(KeyEvent e) {
		            myKeyEvt(e, "keyTyped");
		         }

		         @Override
		         public void keyReleased(KeyEvent e) {
		            myKeyEvt(e, "keyReleased");
		         }

		         @Override
		         public void keyPressed(KeyEvent e) {
		            myKeyEvt(e, "keyPressed");
		         }

		         private void myKeyEvt(KeyEvent e, String text) {
		            int key = e.getKeyCode();
		            System.out.println("TEST");

		            if (key == KeyEvent.VK_KP_LEFT || key == KeyEvent.VK_LEFT)
		            {
		                System.out.println(text + " LEFT");
		                //Call some function
		            }
		            else if (key == KeyEvent.VK_KP_RIGHT || key == KeyEvent.VK_RIGHT)
		            {
		                System.out.println(text + " RIGHT");
		                //Call some function
		            }
		         }
		      });
		   }
	}
