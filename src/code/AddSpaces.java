package code;

public class AddSpaces {

    public static void main(String[] args) {
	addSpaces("abcde");
    }

    public static void addSpaces(String s) {
	System.out.println(s);
	for (int i = 1; i < s.length(); i++) {
	    System.out.println(s.substring(0, i) + " "
		    + s.substring(i, s.length()));
	    addSpacesHelper(s.substring(0, i) + " ", s.substring(i, s.length()));
	}
    }

    public static void addSpacesHelper(String s, String remS) {
	for (int i = 1; i < remS.length(); i++) {
	    System.out.println(s + remS.substring(0, i) + " "
		    + remS.substring(i, remS.length()));
	    addSpacesHelper(s + remS.substring(0, i) + " ",
		    remS.substring(i, remS.length()));
	}
    }
}
