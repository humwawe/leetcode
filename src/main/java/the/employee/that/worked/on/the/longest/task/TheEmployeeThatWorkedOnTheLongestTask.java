package the.employee.that.worked.on.the.longest.task;

/**
 * @author hum
 */
public class TheEmployeeThatWorkedOnTheLongestTask {
  public int hardestWorker(int n, int[][] logs) {
    int res = (int) 1e8;
    int time = -1;
    int pre = 0;
    for (int[] log : logs) {
      int id = log[0];
      int l = log[1] - pre;
      if (l > time) {
        res = id;
        time = l;
      } else if (l == time) {
        res = Math.min(id, res);
      }
      pre = log[1];
    }
    return res;
  }
}
