package valid.tic.tac.toe.state;

/**
 * @author hum
 */
public class ValidTicTacToeState {
    public boolean validTicTacToe(String[] board) {
        int xCount = 0, oCount = 0;
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X') {
                    xCount++;
                }
                if (c == 'O') {
                    oCount++;
                }
            }
        }

        if (oCount != xCount && oCount != xCount - 1) {
            return false;
        }
        if (win(board, 'X') && oCount != xCount - 1) {
            return false;
        }
        if (win(board, 'O') && oCount != xCount) {
            return false;
        }
        return true;
    }

    private boolean win(String[] board, char c) {
        for (int i = 0; i < 3; ++i) {
            if (c == board[0].charAt(i) && c == board[1].charAt(i) && c == board[2].charAt(i)) {
                return true;
            }
            if (c == board[i].charAt(0) && c == board[i].charAt(1) && c == board[i].charAt(2)) {
                return true;
            }
        }
        return (c == board[0].charAt(0) && c == board[1].charAt(1) && c == board[2].charAt(2)) || (c == board[0].charAt(2) && c == board[1].charAt(1) && c == board[2].charAt(0));
    }
}
