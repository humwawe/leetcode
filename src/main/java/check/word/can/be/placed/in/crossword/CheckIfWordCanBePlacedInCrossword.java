package check.word.can.be.placed.in.crossword;

/**
 * @author hum
 */
public class CheckIfWordCanBePlacedInCrossword {
    public boolean placeWordInCrossword(char[][] board, String word) {
        int m = board.length, n = board[0].length, sLen = word.length();
        for (char[] row : board) {
            for (int j = 0; j < n; ++j) {
                if (row[j] == '#') {
                    continue;
                }
                int j0 = j;
                boolean ok1 = true, ok2 = true;
                for (; j < n && row[j] != '#'; ++j) {
                    if (j - j0 >= sLen || (row[j] != ' ' && row[j] != word.charAt(j - j0))) {
                        ok1 = false;
                    }
                    if (j - j0 >= sLen || (row[j] != ' ' && row[j] != word.charAt(sLen - 1 - j + j0))) {
                        ok2 = false;
                    }
                }
                if ((ok1 || ok2) && j - j0 == sLen) {
                    return true;
                }
            }
        }

        for (int j = 0; j < n; ++j) {
            for (int i = 0; i < m; ++i) {
                if (board[i][j] == '#') {
                    continue;
                }
                int i0 = i;
                boolean ok1 = true, ok2 = true;
                for (; i < m && board[i][j] != '#'; ++i) {
                    if (i - i0 >= sLen || (board[i][j] != ' ' && board[i][j] != word.charAt(i - i0))) {
                        ok1 = false;
                    }
                    if (i - i0 >= sLen || (board[i][j] != ' ' & board[i][j] != word.charAt(sLen - 1 - i + i0))) {
                        ok2 = false;
                    }
                }
                if ((ok1 || ok2) && i - i0 == sLen) {
                    return true;
                }
            }
        }
        return false;
    }
}
