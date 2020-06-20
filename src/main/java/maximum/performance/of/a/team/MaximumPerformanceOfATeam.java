package maximum.performance.of.a.team;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class MaximumPerformanceOfATeam {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<Engineer> list = new ArrayList<>();
        PriorityQueue<Engineer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.speed));
        for (int i = 0; i < n; i++) {
            Engineer engineer = new Engineer(speed[i], efficiency[i]);
            list.add(engineer);

        }
        list.sort((a, b) -> b.efficiency - a.efficiency);
        long sum = 0;
        int mod = (int) (1e9 + 7);
        long result = 0;
        for (int i = 0; i < n; i++) {
            Engineer engineer = list.get(i);
            int e = engineer.efficiency;
            priorityQueue.add(engineer);
            sum += engineer.speed;
            if (priorityQueue.size() > k) {
                Engineer poll = priorityQueue.poll();
                sum -= poll.speed;
            }
            result = Math.max(result, e * sum);

        }
        return (int) (result % mod);
    }

    class Engineer {
        int speed;
        int efficiency;

        public Engineer(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }
    }
}
