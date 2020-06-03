package distance.between.bus.stops;

/**
 * @author hum
 */
public class DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        long sum = 0;
        long res = 0;
        for (int aDistance : distance) {
            sum += aDistance;
        }
        int l = Math.min(start, destination);
        int r = Math.max(start, destination);

        for (int i = l; i < r; i++) {
            res += distance[i];
        }
        return (int) Math.min(res, sum - res);
    }
}
