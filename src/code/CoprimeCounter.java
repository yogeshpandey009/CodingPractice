package code;

public class CoprimeCounter {

    public static void main(String[] args) {

	System.out.println("sadasds:" + String.format("%.2f", 1.091555));
	int input[] = new int[] { 7, 3, 10 };

	for (int i = 0; i < input.length; i++) {
	    int count = 1;
	    for (int j = 2; j <= input[i]; j++) {
		if (gcd(j, input[i]) == 1) {
		    count++;
		}
	    }
	    System.out.println(count);
	}

    }

    public static int gcd(int N, int M) {
	if (N % M == 0)
	    return M;
	else
	    return gcd(M, N % M);
    }

}
