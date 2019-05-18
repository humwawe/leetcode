package word.search;

/**
 * @author hum
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        }
        if (board.length == 0 || (board.length == 1 && board[0].length == 0)) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, word, used, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    private boolean helper(char[][] board, String word, boolean[][] used, int i, int j) {

        if (word.isEmpty()) {
            return true;
        }

        if ((i < 0 || i >= board.length || j < 0 || j >= board[0].length || used[i][j] || board[i][j] != word.charAt(0))) {
            return false;
        }
        used[i][j] = true;
        boolean result = helper(board, word.substring(1), used, i, j - 1) ||
                helper(board, word.substring(1), used, i, j + 1) ||
                helper(board, word.substring(1), used, i - 1, j) ||
                helper(board, word.substring(1), used, i + 1, j);
        used[i][j] = false;
        return result;
    }
}
