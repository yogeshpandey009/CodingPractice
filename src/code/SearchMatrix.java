package code;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;// rows
        if (m == 0)
            return false;
        int n = matrix[0].length;// cols
        return searchMatrixHelper(matrix, 0, 0, m - 1, n - 1, target);
    }

    private boolean searchMatrixHelper(int[][] matrix, int x, int y, int x2,
                                       int y2, int target) {
        if (x >= 0 && y >= 0 && x2 <= matrix.length && y2 <= matrix[0].length
                && x <= x2 && y <= y2) {
            // System.out.println(" x " + x + " y " + y + " x2 " + x2 + " y2 " +
            // y2);
            if (x == x2 && y == y2)
                return target == matrix[x][y];
            int mid_x = (x + x2) / 2;
            int mid_y = (y + y2) / 2;
            // System.out.println(" mid_x " + mid_x + " mid_y " + mid_y);
            // if(mid_x >= matrix.length || mid_y >= matrix[0].length) return
            // false;
            if (target == matrix[mid_x][mid_y]) {
                return true;
            } else if (target < matrix[mid_x][mid_y]) {
                return (searchMatrixHelper(matrix, x, y, mid_x, mid_y, target)
                        || searchMatrixHelper(matrix, mid_x + 1, y, x2,
                        mid_y - 1, target) || searchMatrixHelper(
                        matrix, x, mid_y + 1, mid_x - 1, y2, target));
            } else {
                return (searchMatrixHelper(matrix, mid_x + 1, mid_y + 1, x2,
                        y2, target)
                        || searchMatrixHelper(matrix, mid_x + 1, y, x2, mid_y,
                        target) || searchMatrixHelper(matrix, x,
                        mid_y + 1, mid_x, y2, target));
            }
        }
        return false;
    }
}