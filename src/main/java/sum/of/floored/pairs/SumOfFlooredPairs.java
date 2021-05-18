package sum.of.floored.pairs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class SumOfFlooredPairs {
    int N = (int) (1e5 + 5);

    public int sumOfFlooredPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] sum = new int[N];
        for (int num : nums) {
            sum[num]++;
        }
        for (int i = 1; i < N; i++) {
            sum[i] += sum[i - 1];
        }
        long res = 0;
        int mod = (int) (1e9 + 7);
        for (int num : nums) {
            for (int i = 1; i * num < N; i++) {
                int l = i * num;
                int r = Math.min(N - 1, (i + 1) * num - 1);
                res = (res + (sum[r] - sum[l - 1]) * i) % mod;
            }
        }
        return (int) (res % mod);
    }
}
