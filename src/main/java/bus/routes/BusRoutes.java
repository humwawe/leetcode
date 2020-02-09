package bus.routes;

import java.util.*;

/**
 * @author hum
 */
public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int s, int t) {
        if (t == s) {
            return 0;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                graph.putIfAbsent(routes[i][j], new ArrayList<>());
                graph.get(routes[i][j]).add(i);
            }
        }
        Set<Integer> vis = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(s);
        int result = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curStop = queue.poll();
                List<Integer> busList = graph.get(curStop);
                for (int bus : busList) {
                    if (!vis.contains(bus)) {
                        vis.add(bus);
                        for (int stop : routes[bus]) {
                            if (stop == t) {
                                return result;
                            }
                            queue.offer(stop);
                        }
                    }
                }
            }
            result++;
        }
        return -1;
    }
}
