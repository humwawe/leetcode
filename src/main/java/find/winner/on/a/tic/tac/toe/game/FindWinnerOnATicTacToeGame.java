package find.winner.on.a.tic.tac.toe.game;

/**
 * @author hum
 */
public class FindWinnerOnATicTacToeGame {
    public String tictactoe(int[][] moves) {
        int len = moves.length;
        int[][] mat = new int[3][3];
        for (int i = 0; i < len; i++) {
            int x = moves[i][0];
            int y = moves[i][1];
            if (i % 2 == 0) {
                mat[x][y] = 1;
            } else {
                mat[x][y] = -1;
            }

            if (helper(mat, moves[i][0], moves[i][1])) {
                if (i % 2 == 0) {
                    return "A";
                } else {
                    return "B";
                }
            }
        }
        if (len == 9) {
            return "Draw";
        } else {
            return "Pending";
        }
    }

    private boolean helper(int[][] mat, int x, int y) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            count += mat[x][i];
        }
        if (count == 3 || count == -3) {
            return true;
        }
        count = 0;
        for (int i = 0; i < 3; i++) {
            count += mat[i][y];
        }
        if (count == 3 || count == -3) {
            return true;
        }
        count = 0;
        for (int i = 0; i < 3; i++) {
            count += mat[i][i];
        }
        if (count == 3 || count == -3) {
            return true;
        }
        count = 0;
        for (int i = 0; i < 3; i++) {
            count += mat[i][2 - i];
        }
        if (count == 3 || count == -3) {
            return true;
        }
        return false;
    }
}
