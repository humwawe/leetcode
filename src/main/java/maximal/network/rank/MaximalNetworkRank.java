package maximal.network.rank;

/**
 * @author hum
 */
public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connected = new boolean[n][n];
        int[] size = new int[n];
        for (int[] road : roads) {
            size[road[0]]++;
            size[road[1]]++;
            connected[road[0]][road[1]] = true;
            connected[road[1]][road[0]] = true;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int t = size[i] + size[j];
                if (connected[i][j]) {
                    t--;
                }
                max = Math.max(max, t);
            }
        }
        return max;
    }
}
