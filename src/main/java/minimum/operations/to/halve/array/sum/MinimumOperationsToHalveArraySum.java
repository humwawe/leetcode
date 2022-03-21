package minimum.operations.to.halve.array.sum;

import java.util.PriorityQueue;

/**
 * @author hum
 */
public class MinimumOperationsToHalveArraySum {
  public int halveArray(int[] nums) {
    PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a));
    double sum = 0;
    for (int num : nums) {
      sum += (double) num;
      pq.add((double) num);
    }
    int res = 0;
    double decr = 0;
    while (decr < sum / 2) {
      double poll = pq.poll();
      decr += poll / 2;
      pq.add(poll / 2);
      res++;
    }
    return res;
  }
}
