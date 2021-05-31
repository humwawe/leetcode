package process.tasks.using.servers;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class ProcessTasksUsingServers {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>((x, y) -> {
            if (servers[x] == servers[y]) {
                return x - y;
            }
            return servers[x] - servers[y];
        });
        PriorityQueue<int[]> priorityQueue2 = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        for (int i = 0; i < servers.length; i++) {
            priorityQueue2.add(new int[]{i, 0});
        }
        int[] res = new int[tasks.length];
        int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (time < i) {
                time = i;
            }
            while (!priorityQueue2.isEmpty() && priorityQueue2.peek()[1] <= time) {
                int[] poll = priorityQueue2.poll();
                priorityQueue1.add(poll[0]);
            }
            if (priorityQueue1.isEmpty()) {
                time = priorityQueue2.peek()[1];
                while (!priorityQueue2.isEmpty() && priorityQueue2.peek()[1] <= time) {
                    int[] poll = priorityQueue2.poll();
                    priorityQueue1.add(poll[0]);
                }
            }
            res[i] = priorityQueue1.poll();
            priorityQueue2.add(new int[]{res[i], time + tasks[i]});
        }
        return res;
    }
}
