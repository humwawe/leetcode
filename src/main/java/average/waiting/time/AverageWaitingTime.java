package average.waiting.time;

/**
 * @author hum
 */
public class AverageWaitingTime {
    public double averageWaitingTime(int[][] customers) {
        int len = customers.length;
        double res = 0;
        int end = 0;
        for (int[] customer : customers) {
            end = Math.max(end, customer[0]) + customer[1];
            res += end - customer[0];
        }
        return res / len;
    }
}
