package car.pooling;

/**
 * @author hum
 */
public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] tmp = new int[1005];
        for (int[] trip : trips) {
            tmp[trip[1]] += trip[0];
            tmp[trip[2]] -= trip[0];
        }
        int sum = 0;
        for (int i = 0; i < tmp.length; i++) {
            sum += tmp[i];
            if (sum > capacity) {
                return false;
            }
        }
        return true;
    }
}
