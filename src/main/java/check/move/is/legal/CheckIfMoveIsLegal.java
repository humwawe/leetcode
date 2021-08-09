package check.move.is.legal;

/**
 * @author hum
 */
public class CheckIfMoveIsLegal {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
        int row = board.length;
        int col = board[0].length;
        for (int[] f : fs) {
            int x = rMove + f[0];
            int y = cMove + f[1];
            boolean flag = false;
            while (x >= 0 && x < row && y >= 0 && y < col && board[x][y] != color && board[x][y] != '.') {
                x += f[0];
                y += f[1];
                flag = true;
            }
            if (x >= 0 && x < row && y >= 0 && y < col && board[x][y] == color) {
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }
}
