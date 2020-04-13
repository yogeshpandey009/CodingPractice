package code;

public class FrogDP {

    public static void main(String[] args) {

        // int X = 7;
        // int D = 3;
        // int[] A = new int[] { 1, 3, 1, 4, 2, 5 };
        int X = 11;
        int D = 3;
        int[] A = new int[]{1, 5, 8, 2, 1};
        System.out.println(findMinTime(A, X, D));
    }

    public static int findMinTime(int[] A, int X, int D) {
        if (X <= D) {
            return 0;
        }
        int len = A.length;
        int[] dp = new int[X + 1];
        for (int i = 0; i < X + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < len; i++) {
            dp[A[i]] = Math.min(dp[A[i]], i);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= X - D; i++) {
            min = Integer.MAX_VALUE;
            int j = i + D - 1;
            while (j > i - 1) {
                min = Math.min(min, dp[j]);
                j--;
            }
            if (dp[i + D] != Integer.MAX_VALUE) {
                dp[i + D] = Math.max(min, dp[i + D]);
            }
        }
        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        return min;
    }
}
