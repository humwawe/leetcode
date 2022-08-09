package task.scheduler.II;

import java.util.HashMap;
import java.util.Map;

/**
 * @author PF-2CRL0N
 */
public class TaskSchedulerII {
  public long taskSchedulerII(int[] tasks, int space) {
    Map<Integer, Long> map = new HashMap<>();
    long res = 0;
    for (int task : tasks) {
      if (map.containsKey(task)) {
        res = Math.max(res, map.get(task) + space);
      }
      res++;
      map.put(task, res);
    }
    return res;
  }
}
