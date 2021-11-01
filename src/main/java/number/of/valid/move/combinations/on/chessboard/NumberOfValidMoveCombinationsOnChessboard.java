package number.of.valid.move.combinations.on.chessboard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class NumberOfValidMoveCombinationsOnChessboard {
    String[] pieces;
    int[][] positions;
    int len;
    int res = 0;
    int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    List<int[]> paths = new ArrayList<>();

    public int countCombinations(String[] pieces, int[][] positions) {
        this.pieces = pieces;
        this.positions = positions;
        len = pieces.length;
        dfs(0);
        return res;
    }

    private void dfs(int u) {
        if (u == len) {
            if (check()) {
                res++;
            }
            return;
        }
        int x = positions[u][0];
        int y = positions[u][1];
        paths.add(new int[]{0, 0});
        dfs(u + 1);
        paths.remove(paths.size() - 1);
        for (int i = 0; i < 8; i++) {
            if ("rook".equals(pieces[u]) && i % 2 != 0) {
                continue;
            }
            if ("bishop".equals(pieces[u]) && i % 2 == 0) {
                continue;
            }
            int nx = x;
            int ny = y;
            for (int j = 1; ; j++) {
                nx += dx[i];
                ny += dy[i];
                if (nx < 1 || ny < 1 || nx > 8 || ny > 8) {
                    break;
                }
                paths.add(new int[]{i, j});
                dfs(u + 1);
                paths.remove(paths.size() - 1);
            }
        }
    }

    private boolean check() {
        int[][] pos = new int[5][2];
        for (int i = 0; i < len; i++) {
            pos[i][0] = positions[i][0];
            pos[i][1] = positions[i][1];
        }
        for (int t = 1; ; t++) {
            boolean f = true;
            for (int i = 0; i < len; i++) {
                if (paths.get(i)[1] < t) {
                    continue;
                }
                f = false;
                pos[i][0] += dx[paths.get(i)[0]];
                pos[i][1] += dy[paths.get(i)[0]];
            }
            if (f) {
                break;
            }
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (pos[i][0] == pos[j][0] && pos[i][1] == pos[j][1]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
