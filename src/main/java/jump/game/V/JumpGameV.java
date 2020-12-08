package jump.game.V;

/**
 * @author hum
 */
public class JumpGameV {
    Integer[] memo;
    int d;
    int inf = (int) 1e9;

    public int maxJumps(int[] arr, int d) {
        int len = arr.length;
        this.d = d;
        memo = new Integer[len];
        for (int i = 0; i < len; i++) {
            if (memo[i] == null) {
                helper(arr, i);
            }
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            result = Math.max(result, memo[i]);
        }
        return result;
    }

    private int helper(int[] arr, int i) {
        if (i >= arr.length || i < 0) {
            return -inf;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        int res = 1;
        for (int j = i - 1; j >= 0 && i - j <= d; j--) {
            if (arr[j] < arr[i]) {
                res = Math.max(res, helper(arr, j) + 1);
            } else {
                break;
            }
        }
        for (int j = i + 1; j < arr.length && j - i <= d; j++) {
            if (arr[j] < arr[i]) {
                res = Math.max(res, helper(arr, j) + 1);
            } else {
                break;
            }

        }
        return memo[i] = res;
    }
}
