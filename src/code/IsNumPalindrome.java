package code;

public class IsNumPalindrome {

    public boolean isPalindrome(int x) {
	if (x < 0)
	    return false;
	int div = 1;
	while (x / div >= 10) {
	    div *= 10;
	}
	while (x != 0) {
	    int left_most = x / div;
	    int right_most = x % 10;
	    if (left_most != right_most)
		return false;
	    x = x % div;
	    x = x / 10;
	    div = div / 100;
	}
	return true;
    }

    /*
     * public boolean isPalindrome(int x) { if(x < 0) return false; int
     * num_digits = 1; int n = x; while(n/10 != 0) { n = n/10; num_digits++; }
     * int div = (int)Math.pow(10,num_digits-1); while(x!=0 && num_digits != 1)
     * { int left_most = x/div; int right_most = x%10; x=x%div; x=x/10;
     * num_digits=num_digits-2; div = (int)Math.pow(10,num_digits-1);
     * if(left_most != right_most) return false; } return true; }
     */
}
