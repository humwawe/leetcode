package seat.reservation.manager;

import java.util.TreeSet;

/**
 * @author hum
 */
public class SeatReservationManager {
    TreeSet<Integer> set = new TreeSet<>();

    public SeatReservationManager(int n) {
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }
    }

    public int reserve() {
        return set.pollFirst();
    }

    public void unreserve(int seatNumber) {
        set.add(seatNumber);
    }
}
