package code;

public class CountContChar {

    public static void main(String args[]) {
	String input = "aabbaabcdde";
	StringBuffer sb = new StringBuffer();
	if (input.length() != 0) {
	    char first = input.charAt(0);
	    int count = 1;
	    for (int i = 1; i < input.length(); i++) {
		if (first != input.charAt(i)) {
		    sb.append(first + "" + count);
		    first = input.charAt(i);
		    count = 1;
		} else {
		    count++;
		}
	    }
	    sb.append(first + "" + count);
	}
	System.out.println(sb.toString());
    }
}
