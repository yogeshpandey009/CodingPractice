package code;

public class FibonacciDemo {

    public static void main(String... args) {

	// printFibonacciSeriesUpto(21);
	System.out.println(printFibonacciNumUsingRec(4));

    }

    public static void printFibonacciSeriesUpto(int n) {
	int n1 = 0;
	int n2 = 1;
	int nxt = n1 + n2;
	System.out.println(0);
	while (nxt <= n) {
	    System.out.println(nxt);
	    nxt = n1 + n2;
	    ;
	    n1 = n2;
	    n2 = nxt;
	}
    }

    public static int printFibonacciNumUsingRec(int n) {
	if (n == 0 || n == 1) {
	    return n;
	}
	return (printFibonacciNumUsingRec(n - 1) + printFibonacciNumUsingRec(n - 2));
    }

}
