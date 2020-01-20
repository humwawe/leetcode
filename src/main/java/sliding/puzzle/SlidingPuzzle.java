package sliding.puzzle;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author hum
 */
public class SlidingPuzzle {
    int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    Set<String> vis = new HashSet<>();

    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        Queue<String> queue = new ArrayDeque<>();
        String start = toStr(board);
        queue.add(start);
        vis.add(start);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(target)) {
                    return result;
                }
                int x = 0;
                int y = 0;
                int[][] newBoard = toBoard(poll);
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (newBoard[j][k] == 0) {
                            x = j;
                            y = k;
                        }
                    }
                }
                int tmp = newBoard[x][y];
                for (int[] f : fs) {
                    int newX = x + f[0];
                    int newY = y + f[1];
                    if (newX >= 0 && newX < 2 && newY >= 0 && newY < 3) {
                        newBoard[x][y] = newBoard[newX][newY];
                        newBoard[newX][newY] = tmp;
                        String s = toStr(newBoard);
                        if (!vis.contains(s)) {
                            queue.add(s);
                            vis.add(s);
                        }
                        newBoard[newX][newY] = newBoard[x][y];
                        newBoard[x][y] = tmp;
                    }
                }
            }
            result++;
        }
        return -1;
    }

    private int[][] toBoard(String poll) {
        int[][] board = new int[2][3];
        for (int i = 0; i < poll.length(); i++) {
            board[i / 3][i % 3] = poll.charAt(i) - '0';
        }
        return board;
    }

    private String toStr(int[][] board) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                stringBuilder.append(board[i][j]);
            }
        }
        return stringBuilder.toString();
    }
}
