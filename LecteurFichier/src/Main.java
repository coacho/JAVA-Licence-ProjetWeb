import java.util.Scanner;
public class Main {

	public static void main(String[] args){

		System.out.println("Entrer le chemin du fichier à tester : ");
		Scanner scan = new Scanner(System.in);
		String userInput = scan.nextLine();
		
		//LecteurFichier
		System.out.println("Lecture du fichier sans modifs: ");		LecteurFichierInterface lf = new LecteurFichier(userInput);
		lf.read();
		lf.display();
		System.out.println();
		
		//LecteurReverse
		System.out.println("Lecture du fichier à l'envers: ");
		LecteurFichierInterface lr = new LecteurReverse(userInput);
		lr.read();
		lr.display();
		System.out.println();
		
		//LecteurPalindrome
		System.out.println("Test du fichier si palindrome: ");
		LecteurFichierInterface lp = new LecteurPalindrome(userInput);
		lp.read();
		lp.display();
		
		/*//LecteurDiff
		System.out.println("*Diff*");
		LecteurFichierInterface ld = new LecteurDiff(userInput);
		ld.read();
		ld.display();
		*/
		
	}

}
