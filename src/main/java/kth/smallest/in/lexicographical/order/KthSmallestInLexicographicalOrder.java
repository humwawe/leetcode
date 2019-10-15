package kth.smallest.in.lexicographical.order;

/**
 * @author hum
 */
public class KthSmallestInLexicographicalOrder {
    public int findKthNumber(int n, int k) {
        long cur = 1;
        while (k > 1) {
            long gap = helper(cur, cur + 1, n);
            if (gap < k) {
                k -= gap;
                cur = cur + 1;
            } else {
                k -= 1;
                cur = cur * 10;
            }
        }
        return (int) cur;
    }

    private long helper(long cur, long next, int n) {
        long gap = 0;
        while (cur <= n) {
            gap += Math.min(n + 1, next) - cur;
            cur *= 10;
            next *= 10;
        }
        return gap;
    }
}
