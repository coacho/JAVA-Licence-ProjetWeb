
public class LecteurReverse extends Reader implements LecteurFichierInterface {

	public LecteurReverse(String file) {
		super.file = file;
	}
	
	public void display() {
		for(int i=super.content.length()-1; i>= 0; i--) {
			if(content.charAt(i) != '\n') {
				System.out.print(super.content.charAt(i));
			}
		}
		System.out.println();
	}

	@Override
	public void read() {
		super.read(file);
	}

}
