package minimum.rounds.to.complete.all.tasks;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class MinimumRoundsToCompleteAllTasks {
  public int minimumRounds(int[] tasks) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int task : tasks) {
      map.put(task, map.getOrDefault(task, 0) + 1);
    }
    int res = 0;
    for (Integer value : map.values()) {
      if (value % 3 == 0) {
        res += value / 3;
      } else if (value % 3 == 1) {
        if (value == 1) {
          return -1;
        }
        res += (value - 1) / 3 + 1;
      } else {
        res += value / 3 + 1;
      }
    }
    return res;

  }
}
