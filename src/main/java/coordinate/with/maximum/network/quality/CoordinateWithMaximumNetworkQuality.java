package coordinate.with.maximum.network.quality;

/**
 * @author hum
 */
public class CoordinateWithMaximumNetworkQuality {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int N = 55;
        int max = 0;
        int[] res = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int[] tower : towers) {
                    int x = tower[0];
                    int y = tower[1];
                    double q = tower[2];
                    double d = dist(x, y, i, j);
                    if (d > radius) {
                        continue;
                    }
                    sum += (int) (q / (1 + d));
                }
                if (sum > max) {
                    max = sum;
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    private double dist(int x, int y, int i, int j) {
        return Math.sqrt((x - i) * (x - i) + (y - j) * (y - j));
    }
}
