package surrounded.regions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class SurroundedRegions {
    private int[] moveX = new int[]{-1, 0, 1, 0};
    private int[] moveY = new int[]{0, 1, 0, -1};
    private Map<Integer, Boolean> map = new HashMap<>();
    private boolean isCaptured;

    public void solve(char[][] board) {
        if (board.length == 0 || (board.length == 1 && board[0].length == 0)) {
            return;
        }
        int[][] visit = new int[board.length][board[0].length];
        int index = 1;
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[i].length - 1; j++) {
                if (board[i][j] == 'O' && visit[i][j] == 0) {
                    visit[i][j] = index;
                    isCaptured = true;
                    helper(board, i, j, index, visit);
                    map.put(index, isCaptured);
                    index++;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (map.getOrDefault(visit[i][j], false)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void helper(char[][] board, int x, int y, int index, int[][] visit) {
        for (int k = 0; k < 4; k++) {
            int newX = x + moveX[k];
            int newY = y + moveY[k];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && board[newX][newY] == 'O' && visit[newX][newY] == 0) {
                if (isCaptured && (newX == 0 || newY == 0 || newX == board.length - 1 || newY == board[0].length - 1)) {
                    isCaptured = false;
                }
                visit[newX][newY] = index;
                helper(board, newX, newY, index, visit);
            }
        }
    }
}
