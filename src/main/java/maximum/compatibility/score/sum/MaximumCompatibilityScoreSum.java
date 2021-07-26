package maximum.compatibility.score.sum;

import java.util.Arrays;

/**
 * @author hum
 */
public class MaximumCompatibilityScoreSum {
    int[][] students;
    int[][] memtors;
    int[] order = new int[9];
    int m, n;
    int res = 0;
    int[][] dif = new int[9][9];

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        n = students.length;
        m = students[0].length;
        this.students = students;
        this.memtors = mentors;
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int k = 0; k < m; k++) {
                    if (students[i][k] == mentors[j][k]) {
                        cnt++;
                    }
                }
                dif[i][j] = cnt;
            }
        }
        int lim = 1;
        for (int i = 1; i <= n; i++) {
            lim *= i;
        }
        int cnt = 0;
        do {
            int tmp = 0;
            System.out.println(Arrays.toString(order));
            for (int i = 0; i < n; i++) {
                tmp += dif[i][order[i]];
            }
            System.out.println(tmp);
            res = Math.max(res, tmp);
            cnt++;
            nextPermutation(order, n);
        } while (cnt < lim);
        return res;
    }

    public void nextPermutation(int[] order, int len) {
        int i = len - 2;
        while (i >= 0 && order[i] >= order[i + 1]) {
            i--;
        }
        if (i >= 0) {
            for (int j = len - 1; j > i; j--) {
                if (order[j] > order[i]) {
                    int temp = order[j];
                    order[j] = order[i];
                    order[i] = temp;
                    break;
                }
            }
        }
        int left = i + 1;
        int right = len - 1;
        while (left < right) {
            int temp = order[left];
            order[left] = order[right];
            order[right] = temp;
            left++;
            right--;
        }
    }
}
