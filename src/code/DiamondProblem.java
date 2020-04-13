package code;

public class DiamondProblem {

    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 2}, {2, 4, 7}, {9, 0, 2}, {9, 0, 2}};
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= i && j < n; j++) {
                System.out.println(i - j + ":" + j + "=" + matrix[i - j][j]);
            }
        }
        System.out.println("---------");
        for (int i = m - 1; i > 0; i--) {
            for (int j = 1; j <= i && j + m - 1 - i < n; j++) {
                int x = m - j;
                int y = j + m - 1 - i;
                System.out.println(x + ":" + y + "=" + matrix[x][y]);
            }
        }
    }

}
