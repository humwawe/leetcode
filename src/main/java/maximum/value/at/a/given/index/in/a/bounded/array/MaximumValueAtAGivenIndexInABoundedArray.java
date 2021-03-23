package maximum.value.at.a.given.index.in.a.bounded.array;

/**
 * @author hum
 */
public class MaximumValueAtAGivenIndexInABoundedArray {
    public int maxValue(int n, int index, int maxSum) {
        int l = 1;
        int r = (int) 1e9;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (helper(mid, index + 1) + helper(mid, n - index) - mid <= maxSum) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private long helper(long v, long len) {
        if (v >= len) {
            long a1 = v - len + 1;
            return a1 * len + len * (len - 1) / 2;
        } else {
            long a1 = 1;
            long res = 0;
            res += a1 * v + v * (v - 1) / 2;
            res += len - v;
            return res;
        }
    }
}
