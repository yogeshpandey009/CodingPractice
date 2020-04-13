package code;

public class FindWord {

    public static void main(String... args) {
        FindWord f = new FindWord();
        // char[][] board = new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C',
        // 'S'}, {'A', 'D', 'E', 'E'}};
        // String word = "ABCCED";
        // char[][] board = new char[][] {{'A', 'B'}};
        // String word = "BA";
        // char[][] board = new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C',
        // 'S'}, {'A', 'D', 'E', 'E'}};
        // String word = "SEE";
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";
        System.out.println(f.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        char c = word.charAt(0);
        boolean found = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (c == board[i][j]) {
                    XY pos = new XY(i, j);
                    visited[i][j] = true;
                    found = check_rec(board, word.substring(1, word.length()),
                            visited, pos);
                    if (found == true) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return found;
    }

    public boolean check_rec(char[][] board, String word, boolean[][] visited,
                             XY curr) {
        if (word.length() == 0)
            return true;
        visited = visited.clone();
        int i = 0;
        while (i != 4) {
            XY nxt = findPos(board, word, visited, curr, i);
            if (nxt.x != -1) {
                visited[nxt.x][nxt.y] = true;
                if (check_rec(board, word.substring(1, word.length()), visited,
                        nxt)) {
                    return true;
                }
                visited[nxt.x][nxt.y] = false;
            }
            i++;
        }
        return false;

        /*
         * XY nxt = findPos(board, word, visited, curr); if(nxt.x != -1) {
         * visited[nxt.x][nxt.y] = true; if(check_rec(board, word.substring(1,
         * word.length()), visited, nxt)) { return true; }else { return
         * check_rec(board, word, visited, curr); } }
         */

    }

    public XY findPos(char[][] board, String word, boolean[][] visited,
                      XY curr, int i) {
        int x = curr.x;
        int y = curr.y;
        char c = word.charAt(0);
        if (i == 0 && x >= 1 && board[x - 1][y] == c
                && visited[x - 1][y] == false) {
            return new XY(x - 1, y);
        } else if (i == 1 && y >= 1 && board[x][y - 1] == c
                && visited[x][y - 1] == false) {
            return new XY(x, y - 1);
        } else if (i == 2 && x < board.length - 1 && board[x + 1][y] == c
                && visited[x + 1][y] == false) {
            return new XY(x + 1, y);
        } else if (i == 3 && y < board[0].length - 1 && board[x][y + 1] == c
                && visited[x][y + 1] == false) {
            return new XY(x, y + 1);
        }
        return new XY();
    }

    class XY {
        int x = -1;
        int y = -1;

        XY() {

        }

        XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
