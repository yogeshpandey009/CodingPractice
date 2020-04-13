package code;

public class MaxStep {

    static int maxStep(int n, int k, int start) {
	int max = 0;
	for (int i = start; i <= n; i++) {
	    if (i != k)
		max = Math.max(maxStep(n, k - i, i + 1) + i, max);
	}
	return max;
    }

    public static void main(String[] args) {
	System.out.println(maxStep(1, 0, 1));
    }
}
