package minimum.number.of.refueling.stops;

import java.util.PriorityQueue;

/**
 * @author hum
 */
public class MinimumNumberOfRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int current = 0;
        int result = 0;
        for (int i = 0; i < stations.length; i++) {
            if (startFuel >= stations[i][0]) {
                queue.add(stations[i][1]);
            } else {
                if (queue.isEmpty()) {
                    return -1;
                } else {
                    Integer poll = queue.poll();
                    startFuel += poll;
                    result++;
                    i--;
                }
            }
        }
        if (startFuel >= target - current) {
            return result;
        }
        while (!queue.isEmpty()) {
            startFuel += queue.poll();
            result++;
            if (startFuel >= target - current) {
                return result;
            }
        }
        return -1;
    }
}
