package code;

// https://app.codility.com/demo/results/training2BZA66-9NK/
public class Ladder {
    int MAX = (1 << 30);

    public int[] solution(int[] A, int[] B) {
        int[] res = new int[A.length];
        int[] dp = new int[A.length + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= A.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MAX;
        }

        for (int i = 0; i < A.length; i++) {
            res[i] = dp[A[i]] % (1 << B[i]);
        }
        return res;
    }

    /*
    https://app.codility.com/demo/results/trainingNTAABW-AZA/
    // StackOverflowError
    int countSteps(int n) {
        if (dp[n] != null) return dp[n];
        int c = (countSteps(n - 1) + countSteps(n - 2)) % MAX;
        dp[n] = c;
        return c;
    }
    */
}
