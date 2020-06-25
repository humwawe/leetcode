package course.schedule.IV;

import java.util.*;

/**
 * @author hum
 */
public class CourseScheduleIV {
    int[] h = new int[105];
    int[] e = new int[(int) (1e4 + 5)];
    int[] ne = new int[(int) (1e4 + 5)];
    int idx;
    Boolean[][] memo = new Boolean[105][105];

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        Arrays.fill(h, -1);
        idx = 0;
        for (int[] prerequisite : prerequisites) {
            add(prerequisite[1], prerequisite[0]);
        }
        int len = queries.length;
        List<Boolean> result = new ArrayList<>(len);

        for (int[] query : queries) {
            if (helper(query[1], query[0])) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }

    private boolean helper(int i, int j) {
        if (i == j) {
            return true;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        for (int k = h[i]; k != -1; k = ne[k]) {
            int next = e[k];
            if (helper(next, j)) {
                return memo[i][j] = true;
            }
        }
        return memo[i][j] = false;
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
