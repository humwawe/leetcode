package grumpy.bookstore.owner;

/**
 * @author hum
 */
public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int x) {
        int len = customers.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }
        for (int i = 0; i < x; i++) {
            if (grumpy[i] == 1) {
                sum += customers[i];
            }
        }
        int result = sum;
        for (int i = x; i < len; i++) {
            if (grumpy[i] == 1) {
                sum += customers[i];
            }
            if (grumpy[i - x] == 1) {
                sum -= customers[i - x];
            }
            result = Math.max(result, sum);
        }
        return result;
    }
}
