package sudoku.solver;

/**
 * @author hum
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] column = new int[9][9];
        int[][] square = new int[9][9];
        int[] index = new int[82];
        int size = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    index[size++] = i * 10 + j;
                    continue;
                }
                int num = (board[i][j] - '0') - 1;
                row[i][num] = 1;
                column[j][num] = 1;
                square[i / 3 * 3 + j / 3][num] = 1;
            }
        }
        index[size] = -1;
        helper(row, column, square, board, 0, index);


    }

    private boolean helper(int[][] row, int[][] column, int[][] square, char[][] board, int x, int[] index) {
        int i = index[x] / 10;
        int j = index[x] % 10;
        for (int num = 0; num < 9; num++) {
            if (row[i][num] != 1 && column[j][num] != 1 && square[i / 3 * 3 + j / 3][num] != 1) {
                board[i][j] = (char) (num + 1 + '0');
                if (index[x + 1] == -1) {
                    return true;
                }
                row[i][num] = 1;
                column[j][num] = 1;
                square[i / 3 * 3 + j / 3][num] = 1;
                if (helper(row, column, square, board, x + 1, index)) {
                    return true;
                } else {
                    board[i][j] = '.';
                    row[i][num] = 0;
                    column[j][num] = 0;
                    square[i / 3 * 3 + j / 3][num] = 0;
                }

            }
        }
        return false;
    }

}
