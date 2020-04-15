package odd.even.jump;

import java.util.TreeMap;

/**
 * @author hum
 */
public class OddEvenJump {
    int oddEvenJumps(int[] a) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int len = a.length;
        boolean[][] dp = new boolean[len][2];
        dp[len - 1][0] = true;
        dp[len - 1][1] = true;
        map.put(a[len - 1], len - 1);
        int result = 1;
        for (int i = len - 2; i >= 0; i--) {
            Integer integer = map.ceilingKey(a[i]);
            if (integer == null) {
                dp[i][0] = false;
            } else {
                dp[i][0] = dp[map.get(integer)][1];
            }
            integer = map.floorKey(a[i]);
            if (integer == null) {
                dp[i][1] = false;
            } else {
                dp[i][1] = dp[map.get(integer)][0];
            }
            if (dp[i][0]) {
                result++;
            }
            map.put(a[i], i);
        }
        return result;
    }
}
