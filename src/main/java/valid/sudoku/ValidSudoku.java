package valid.sudoku;

/**
 * @author hum
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] column = new int[9][9];
        int[][] square = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
//                int num = Character.getNumericValue(board[i][j]) - 1;
                if (board[i][j] == '.') {
                    continue;
                }
                int num = (board[i][j] - '0') - 1;
                if (row[i][num] == 1 || column[j][num] == 1 || square[i / 3 * 3 + j / 3][num] == 1) {
                    return false;
                }
                row[i][num] = 1;
                column[j][num] = 1;
                square[i / 3 * 3 + j / 3][num] = 1;
            }
        }

        return true;
    }
}
