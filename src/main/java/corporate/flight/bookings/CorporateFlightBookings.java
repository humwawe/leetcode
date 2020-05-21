package corporate.flight.bookings;

/**
 * @author hum
 */
public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        int[] tmp = new int[n + 5];
        for (int[] booking : bookings) {
            tmp[booking[0]] += booking[2];
            tmp[booking[1] + 1] -= booking[2];
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += tmp[i + 1];
            result[i] = sum;
        }
        return result;

    }
}
