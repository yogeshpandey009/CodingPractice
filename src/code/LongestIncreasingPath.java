package code;

public class LongestIncreasingPath {

    public int longestIncreasingPath(int[][] matrix) {
	int n = matrix.length;
	if (n == 0)
	    return 0;
	int m = matrix[0].length;
	int[][] dp = new int[n][m];
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < m; j++) {
		longestIncreasingPathHelper(matrix, i, j, dp, n, m);
	    }
	}
	int max = -1;
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < m; j++) {
		if (dp[i][j] > max) {
		    max = dp[i][j];
		}
	    }
	}
	return max;
    }

    public int longestIncreasingPathHelper(int[][] matrix, int i, int j,
	    int[][] dp, int n, int m) {
	if (dp[i][j] != 0)
	    return dp[i][j];
	int t = 0;
	int b = 0;
	int l = 0;
	int r = 0;
	if (i - 1 >= 0) {
	    if (matrix[i][j] < matrix[i - 1][j])
		l = longestIncreasingPathHelper(matrix, i - 1, j, dp, n, m);
	}
	if (j - 1 >= 0) {
	    if (matrix[i][j] < matrix[i][j - 1])
		t = longestIncreasingPathHelper(matrix, i, j - 1, dp, n, m);
	}
	if (j + 1 < m) {
	    if (matrix[i][j] < matrix[i][j + 1])
		b = longestIncreasingPathHelper(matrix, i, j + 1, dp, n, m);
	}
	if (i + 1 < n) {
	    if (matrix[i][j] < matrix[i + 1][j])
		r = longestIncreasingPathHelper(matrix, i + 1, j, dp, n, m);
	}
	dp[i][j] = Math.max(l, Math.max(t, Math.max(b, r))) + 1;
	return dp[i][j];
    }
}