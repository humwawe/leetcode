package total.cost.to.hire.k.workers;

import java.util.PriorityQueue;

/**
 * @author hum
 */
public class TotalCostToHireKWorkers {
  public long totalCost(int[] costs, int k, int candidates) {
    int n = costs.length;
    long res = 0;
    int i = -1;
    int j = n;
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x, y) -> {
      int d = x[0] - y[0];
      if (d == 0) {
        return x[1] - y[1];
      }
      return d;
    });
    int t = 0;
    while (i + 1 < j && t < candidates) {
      priorityQueue.add(new int[]{costs[i + 1], -(i + 1)});
      i++;
      t++;
    }
    t = 0;
    while (i < j - 1 && t < candidates) {
      priorityQueue.add(new int[]{costs[j - 1], (j - 1)});
      j--;
      t++;
    }

    for (int l = 0; l < k; l++) {
      int[] poll = priorityQueue.poll();
      res += poll[0];
      if (poll[1] <= 0) {
        if (i + 1 < j) {
          priorityQueue.add(new int[]{costs[i + 1], -(i + 1)});
          i++;
        }
      } else {
        if (i < j - 1) {
          priorityQueue.add(new int[]{costs[j - 1], j - 1});
          j--;
        }
      }
    }
    return res;
  }
}
