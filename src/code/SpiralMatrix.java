package code;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();
        s.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8},
                {9, 10, 11, 12}});
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = 0;
        if (m > 0)
            n = matrix[0].length;
        List<Integer> arr = new ArrayList<>();
        int startI = 0, startJ = 0, endI = m - 1, endJ = n - 1;
        for (int k = 0; k <= Math.min(m, n) / 2; k++) {
            int i = startI;
            int j = startJ;
            for (j = startJ; j <= endJ; j++) {
                arr.add(matrix[i][j]);
            }
            j--;
            startI++;
            for (i = startI; i <= endI; i++) {
                arr.add(matrix[i][j]);
            }
            i--;
            endJ--;
            for (j = endJ; j >= startJ; j--) {
                arr.add(matrix[i][j]);
            }
            endI--;
            j++;
            for (i = endI; i >= startI; i--) {
                arr.add(matrix[i][j]);
            }
            startJ++;
            i++;
        }
        return arr;
    }
}
