package game.of.life;

/**
 * @author hum
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] newBoard = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = 0;
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        int x = i + k;
                        int y = j + l;
                        if (x == i && y == j) {
                            continue;
                        }
                        if (x < row && x >= 0 && y < col && y >= 0) {
                            if (board[x][y] == 1) {
                                count++;
                            }
                        }
                    }
                }
                newBoard[i][j] = board[i][j];
                if (board[i][j] == 0) {
                    if (count == 3) {
                        newBoard[i][j] = 1;
                    }
                } else if (count < 2) {
                    newBoard[i][j] = 0;
                } else if (count > 3) {
                    newBoard[i][j] = 0;
                } else {
                    newBoard[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            System.arraycopy(newBoard[i], 0, board[i], 0, col);
        }
    }
}
