package find.the.town.judge;

/**
 * @author hum
 */
public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        boolean[] p = new boolean[n + 1];
        int[] count = new int[n + 1];
        for (int[] ints : trust) {
            p[ints[0]] = true;
            count[ints[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (p[i]) {
                continue;
            }
            if (count[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
