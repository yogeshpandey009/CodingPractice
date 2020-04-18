package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SquareDance {

    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private void solve(int[][] grid, int r, int c, long score) {
        int[][][] neighbors = computeNeighbors(r, c);
        long prev = score;
        boolean[][] removed = new boolean[r+1][c+1];
        boolean[] visited_rows = new boolean[r+2];
        boolean[] visited_cols = new boolean[c+2];

        while (true) {
            //printNeighbors(neighbors, grid, r, c);
            int[][][] new_neighbors = copy(neighbors, visited_rows, visited_cols);
            long round = 0;
            for (int i = 1; i <= r; i++) {
                if (visited_rows[i]) continue;
                for (int j = 1; j <= c; j++) {
                    if (visited_cols[j]) continue;
                    if (removed[i][j]) continue;
                    int sum = 0;
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        Integer neighbor = getNeighbor(grid, neighbors, i, j, k);
                        if (neighbor != null) {
                            sum += neighbor;
                            count++;
                        }
                    }
                    if (grid[i][j] * count < sum) {
                        removed[i][j] = true;
                        int top = new_neighbors[i][j][0];
                        int bottom = new_neighbors[i][j][1];
                        int left = new_neighbors[i][j][2];
                        int right = new_neighbors[i][j][3];
                        new_neighbors[top][j][1] = bottom;
                        new_neighbors[bottom][j][0] = top;
                        new_neighbors[i][left][3] = right;
                        new_neighbors[i][right][2] = left;
                        if (top == 0 && bottom == r + 1) {
                            visited_cols[j] = true;
                        }
                        if (left == 0 && right == c + 1) {
                            visited_rows[i] = true;
                        }

                    } else {
                        round += grid[i][j];
                    }
                }
            }
            if (prev == round) {
                break;
            }
            prev = round;
            score += round;
            neighbors = new_neighbors;
        }

        System.out.println(score);
    }

    private Integer getNeighbor(int[][] grid, int[][][] neighbors, int i, int j, int n) {
        if(n == 0 || n == 1) { // top or bottom
            int row = neighbors[i][j][n];
            if (row == 0 || row == grid.length - 1) return null;
            return grid[row][j];
        }
        // left or right
        int col = neighbors[i][j][n];
        if (col == 0 || col == grid[0].length - 1) return null;
        return grid[i][neighbors[i][j][n]];
    }

    void printNeighbors(int[][][] neighbors, int[][] grid, int r, int c) {
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                System.out.println("    " + grid[neighbors[i][j][0]][j]);
                System.out.println(grid[i][neighbors[i][j][2]] + "  " + grid[i][j] + "  " + grid[i][neighbors[i][j][3]]);
                System.out.println("    " + grid[neighbors[i][j][1]][j]);
            }
        }
    }

    private int[][][] computeNeighbors(int r, int c) {
        int[][][] neighbors = new int[r + 2][c + 2][4];

        for (int i = 0; i <= r + 1; i++) {
            for (int j = 0; j <= c + 1; j++) {
                neighbors[i][j] = new int[]{
                        i-1, i+1, j-1, j+1 // top, bottom, left, right
                };
            }
        }
        return neighbors;
    }

    private int[][][] copy(int[][][] org, boolean[] visited_rows, boolean[] visited_cols) {
        int[][][] clone = new int[org.length][org[0].length][4];
        for (int i = 0; i < org.length; i++) {
            if (visited_rows[i]) continue;
            for (int j = 0; j < org[0].length; j++) {
                if (visited_cols[j]) continue;
                clone[i][j] = org[i][j].clone();
            }
        }
        return clone;
    }

    private void run() throws Exception {
        int t = sc.nextInt();
        for (int n = 1; n <= t; n++) {

            int r = sc.nextInt();
            int c = sc.nextInt();
            int[][] grid = new int[r + 2][c + 2];

            long score = 0;
            for (int i = 1; i <= r; i++) {
                for (int j = 1; j <= c; j++) {
                    grid[i][j] = sc.nextInt();
                    score += grid[i][j];
                }
            }

            System.out.print("Case #" + n + ": ");

            solve(grid, r, c, score);
        }
        sc.close();
        System.out.close();
    }

    public static void main(String args[]) throws Exception {
        new SquareDance().run();
    }
}
