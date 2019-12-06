package task.scheduler;

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] t = new int[26];
        for (char c : tasks)
            t[c - 'A']++;
        Arrays.sort(t);
        int max = t[25] - 1, idle = max * n;
        for (int i = 24; i >= 0 && t[i] > 0; i--) {
            idle -= Math.min(t[i], max);
        }
        return idle > 0 ? idle + tasks.length : tasks.length;
    }
}
