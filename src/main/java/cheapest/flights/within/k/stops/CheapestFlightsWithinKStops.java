package cheapest.flights.within.k.stops;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class CheapestFlightsWithinKStops {
    int result = Integer.MAX_VALUE;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] graph = new int[n][n];
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }



        helper(graph, src, dst, k, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void helper(int[][] graph, int src, int dst, int k, int sum) {
        if (sum > result) {
            return;
        }
        if (src == dst) {
            result = Math.min(result, sum);
            return;
        }
        if (k < 0) {
            return;
        }
        for (int i = 0; i < graph[src].length; i++) {
            if (graph[src][i] != 0) {
                helper(graph, i, dst, k - 1, sum + graph[src][i]);
            }
        }
    }
}
