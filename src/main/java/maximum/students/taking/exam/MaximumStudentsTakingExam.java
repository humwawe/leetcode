package maximum.students.taking.exam;

import java.util.Arrays;

/**
 * @author hum
 */
public class MaximumStudentsTakingExam {
    public int maxStudents(char[][] seats) {
        int row = seats.length;
        int col = seats[0].length;
        int[] cnt = new int[1 << col];
        for (int state = 0; state < 1 << col; state++) {
            for (int i = 0; i < col; i++) {
                if ((state >> i & 1) == 1) {
                    cnt[state]++;
                }
            }
        }

        int[][] dp = new int[row + 1][1 << col];
        for (int i = 0; i <= row; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= row; i++) {
            f:
            for (int state = 0; state < 1 << col; state++) {
                for (int j = 0; j < col; j++) {
                    if ((state >> j & 1) == 1 && (state >> j + 1 & 1) == 1) {
                        continue f;
                    }
                    if (seats[i - 1][col - 1 - j] == '#' && (((state >> j) & 1) == 1)) {
                        continue f;
                    }
                }
                f2:
                for (int prev = 0; prev < 1 << col; prev++) {
                    int t = state | prev;
                    for (int j = 0; j < col; j++) {
                        if ((t >> j & 1) == 1 && (t >> j + 1 & 1) == 1) {
                            continue f2;
                        }
                    }
                    if (dp[i - 1][prev] != -1) {
                        dp[i][state] = Math.max(dp[i][state], dp[i - 1][prev] + cnt[state]);
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < 1 << col; i++) {
            result = Math.max(result, dp[row][i]);
        }
        return result;
    }
}
