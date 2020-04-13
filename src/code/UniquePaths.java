package code;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
	int[][] dp = new int[m + 1][n + 1];
	for (int i = 1; i <= m; i++) {
	    dp[i][1] = 1;
	}
	for (int i = 2; i <= n; i++) {
	    dp[1][i] = 1;
	}
	return computeUniquePaths(m, n, dp);
    }

    private int computeUniquePaths(int m, int n, int[][] dp) {
	if (m <= dp.length && m >= 1 && n <= dp[0].length && n >= 1) {
	    if (dp[m][n] == 0) {
		dp[m][n] = computeUniquePaths(m - 1, n, dp)
			+ computeUniquePaths(m, n - 1, dp);
	    }
	    return dp[m][n];
	}
	return 0;
    }
}