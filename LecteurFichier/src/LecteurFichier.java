public class LecteurFichier extends Reader implements LecteurFichierInterface {

	public LecteurFichier(String file) {
		super.file = file;
	}
	
	public void display() {
		System.out.println(content);
	}

	@Override
	public void read() {
		super.read(file);		
	}


}
