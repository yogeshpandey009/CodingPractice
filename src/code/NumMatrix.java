package code;

public class NumMatrix {
    int[][] dp;

    public NumMatrix(int[][] matrix) {
        if (matrix.length != 0) {
            dp = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = matrix[i][j];
                    } else if (i == 0) {
                        dp[i][j] = matrix[i][j] + dp[i][j - 1];
                    } else if (j == 0) {
                        dp[i][j] = matrix[i][j] + dp[i - 1][j];
                    } else {
                        dp[i][j] = matrix[i][j] + dp[i - 1][j] + dp[i][j - 1]
                                - dp[i - 1][j - 1];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // [[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]],sumRegion(2,1,4,3),sumRegion(1,1,2,2),sumRegion(1,2,2,4)
        NumMatrix numMatrix = new NumMatrix(new int[][]{{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}});
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        // System.out.println(numMatrix.sumRegion(1,1,2,2));
        // System.out.println(numMatrix.sumRegion(1,2,2,4));
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (dp != null) {
            int top = 0;
            int left = 0;
            int top_left = 0;
            if (row1 == 0 && col1 == 0) {
            } else if (row1 == 0) {
                left = dp[row2][col1 - 1];
            } else if (col1 == 0) {
                top = dp[row1 - 1][col2];
            } else {
                top = dp[row1 - 1][col2];
                left = dp[row2][col1 - 1];
                top_left = dp[row1 - 1][col1 - 1];
            }
            System.out.println(top);
            System.out.println(left);
            System.out.println(top_left);
            System.out.println(dp[row2][col2]);
            return dp[row2][col2] - top - left + top_left;
        }
        return 0;
    }
}

// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);