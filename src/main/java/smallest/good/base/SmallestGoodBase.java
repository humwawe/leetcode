package smallest.good.base;

/**
 * @author hum
 */
public class SmallestGoodBase {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        for (int m = (int) (Math.log(num + 1) / Math.log(2)); m >= 2; m--) {
            long left = 2, right = (long) Math.pow(num, 1.0 / (m - 1)) + 1;
            while (left < right) {
                long mid = left + (right - left) / 2, sum = 0;
                for (int j = 0; j < m; j++) {
                    sum = sum * mid + 1;
                }
                if (sum == num) {
                    return String.valueOf(mid);
                } else if (sum < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return String.valueOf(num - 1);
    }

}
