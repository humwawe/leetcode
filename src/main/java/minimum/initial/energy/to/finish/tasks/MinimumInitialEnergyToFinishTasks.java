package minimum.initial.energy.to.finish.tasks;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumInitialEnergyToFinishTasks {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (x, y) -> (y[1] - y[0]) - (x[1] - x[0]));
        int len = tasks.length;
        int res = 0;
        int t = 0;
        for (int[] task : tasks) {
            if (t < task[1]) {
                res += task[1] - t;
                t = task[1] - task[0];
            } else {
                t -= task[0];
            }
        }
        return res;
    }
}
