package arranging.coins;

/**
 * @author hum
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        long left = 0;
        long right = 100000;
        while (left < right - 1) {
            long mid = left + (right - left) / 2;
            long count = mid * (mid + 1) / 2;
            if (count == n) {
                return (int) mid;
            }
            if (count > n) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if ((left + 1) * (left + 2) / 2 > n) {
            return (int) left;
        }
        return (int) left + 1;
    }
}
