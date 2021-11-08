package minimized.maximum.of.products.distributed.to.any.store;

/**
 * @author hum
 */
public class MinimizedMaximumOfProductsDistributedToAnyStore {
    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1;
        int r = (int) 1e5;
        while (l < r) {
            int mid = l + r >> 1;
            int cnt = 0;
            for (int quantity : quantities) {
                cnt += (quantity + mid - 1) / mid;
            }
            if (cnt <= n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
