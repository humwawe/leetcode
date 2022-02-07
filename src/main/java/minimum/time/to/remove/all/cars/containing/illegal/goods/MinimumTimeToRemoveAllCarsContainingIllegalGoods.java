package minimum.time.to.remove.all.cars.containing.illegal.goods;

/**
 * @author hum
 */
public class MinimumTimeToRemoveAllCarsContainingIllegalGoods {
    public int minimumTime(String s) {
        int len = s.length();
        int[] sum = new int[len + 1];
        for (int i = 0; i < s.length(); i++) {
            sum[i + 1] += sum[i] + (s.charAt(i) - '0');
        }
        int max = 0;
        int res = (int) 1e8;
        for (int i = 0; i <= len; i++) {
            int t = 2 * sum[i] - i;
            res = Math.min(res, len + t - max);
            max = Math.max(t, max);
        }
        return res;
    }
}
