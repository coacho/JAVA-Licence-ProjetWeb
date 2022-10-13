
public class LecteurPalindrome extends Reader implements LecteurFichierInterface {

	public LecteurPalindrome(String file) {
		super.file = file;
	}
	
	public boolean palindrome(int begin, int end) {
    	if(begin == end) {
    		return true;
    	}
	    if(content.charAt(begin) == content.charAt(end)) {
	    	if(!palindrome(begin+1, end-1)) {
	            return true; 
	        }
	    }
	    else {
	        return false;
	    }
	    return false; 
	}
	
	public void display() {
		if(palindrome(0, super.content.length()-1)) {
			System.out.println("C'est un palindrome");
		}
		else {
			System.out.println("Ce n'est pas un palindrome");
		}
	}

	@Override
	public void read() {
		super.read(file);
	}
	
	

}
