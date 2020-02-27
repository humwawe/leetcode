package minimum.cost.to.hire.k.workers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class MinimumCostToHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int len = quality.length;
        Worker[] workers = new Worker[len];
        for (int i = 0; i < len; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers, Comparator.comparingDouble(Worker::getRadio));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        double result = Integer.MAX_VALUE;
        int sum = 0;
        for (Worker worker : workers) {
            priorityQueue.add(worker.quality);
            sum += worker.quality;
            if (priorityQueue.size() > k) {
                sum -= priorityQueue.poll();
            }
            if (priorityQueue.size() == k) {
                result = Math.min(result, sum * worker.getRadio());
            }
        }
        return result;
    }

    class Worker {
        int quality;
        int wage;

        public Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
        }

        public double getRadio() {
            return (double) wage / quality;
        }
    }
}
