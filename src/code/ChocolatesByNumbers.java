package code;

public class ChocolatesByNumbers {
    public static void main(String[] args) {
	solution(10, 4);
    }

    public static int solution(int N, int M) {
	if (N == 0 || M == 0)
	    return 0;
	return N / gcd(N, M);
    }

    public static int gcd(int N, int M) {
	if (N % M == 0)
	    return M;
	else
	    return gcd(M, N % M);
    }
}
