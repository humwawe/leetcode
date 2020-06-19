package count.all.balid.pickup.and.delivery.options;

/**
 * @author hum
 */
public class CountAllValidPickupAndDeliveryOptions {
    int mod = (int) (1e9 + 7);

    public int countOrders(int n) {
        if (n == 1) {
            return 1;
        }
        return (int) (long) countOrders(n - 1) % mod * n * (2 * n - 1) % mod;
    }
}
