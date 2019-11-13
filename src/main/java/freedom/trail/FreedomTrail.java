package freedom.trail;

/**
 * @author hum
 */
public class FreedomTrail {
    public int findRotateSteps(String ring, String key) {
        int len = key.length();
        int[][] memo = new int[len][ring.length()];
        return helper(ring, key, 0, 0, memo) + len;
    }

    private int helper(String ring, String key, int start, int index, int[][] memo) {
        if (start == key.length()) {
            return 0;
        }
        if (memo[start][index] != 0) {
            return memo[start][index];
        }
        int i, j;
        if (ring.charAt(index) == key.charAt(start)) {
            memo[start][index] = helper(ring, key, start + 1, index, memo);
            return memo[start][index];
        }
        for (i = index + 1; i != index; i++) {
            if (i == ring.length()) {
                i = 0;
            }
            if (ring.charAt(i) == key.charAt(start)) {

                break;
            }
        }
        for (j = index - 1; j != index; j--) {
            if (j < 0) {
                j = ring.length() - 1;
            }
            if (ring.charAt(j) == key.charAt(start)) {

                break;
            }
        }
        int dist1 = (i - index + ring.length()) % ring.length();
        int dist2 = (index - j + ring.length()) % ring.length();
        memo[start][index] = Math.min(dist1 + helper(ring, key, start + 1, i, memo), dist2 + helper(ring, key, start + 1, j, memo));
        return memo[start][index];
    }
}
