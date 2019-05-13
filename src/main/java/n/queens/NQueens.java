package n.queens;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        int[][] visit = new int[n][n];
        List<List<String>> results = new ArrayList<>();
        helper(0, n, visit, results);
        return results;

    }

    private void helper(int i, int n, int[][] visit, List<List<String>> results) {
        if (i == n) {
            List<String> result = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                StringBuilder str = new StringBuilder();
                for (int k = 0; k < n; k++) {
                    if (visit[j][k] == 1) {
                        str.append("Q");
                    } else {
                        str.append(".");
                    }
                }
                result.add(str.toString());
            }
            results.add(result);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (visit[i][j] == 0) {
                visit[i][j] = 1;
                for (int row = i + 1; row < n; row++) {
                    visit[row][j] -= 1;
                }
                int left = j - 1;
                for (int row = i + 1; row < n && left >= 0; row++, left--) {
                    visit[row][left] -= 1;
                }
                int right = j + 1;
                for (int row = i + 1; row < n && right < n; row++, right++) {
                    visit[row][right] -= 1;
                }

                helper(i + 1, n, visit, results);

                visit[i][j] = 0;
                for (int row = i + 1; row < n; row++) {
                    visit[row][j] += 1;
                }
                left = j - 1;
                for (int row = i + 1; row < n && left >= 0; row++, left--) {
                    visit[row][left] += 1;
                }
                right = j + 1;
                for (int row = i + 1; row < n && right < n; row++, right++) {
                    visit[row][right] += 1;
                }
            }
        }
    }
}
