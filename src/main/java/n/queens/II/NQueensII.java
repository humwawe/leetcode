package n.queens.II;

/**
 * @author hum
 */
public class NQueensII {
    private int result;

    public int totalNQueens(int n) {
        int[][] visit = new int[n][n];
        helper(0, n, visit);
        return result;

    }

    private void helper(int i, int n, int[][] visit) {
        if (i == n) {
            result++;
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

                helper(i + 1, n, visit);

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
