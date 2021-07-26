package the.number.of.the.smallest.unoccupied.chair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author hum
 */
public class TheNumberOfTheSmallestUnoccupiedChair {
    public int smallestChair(int[][] times, int targetFriend) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        int n = times.length;
        int[][] t = new int[n][3];
        for (int i = 0; i < n; i++) {
            treeSet.add(i);
            t[i][0] = times[i][0];
            t[i][1] = times[i][1];
            t[i][2] = i;
        }
        Arrays.sort(t, Comparator.comparingInt(x -> x[0]));
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        for (int i = 0; i < n; i++) {
            int now = t[i][0];
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[0] <= now) {
                treeSet.add(priorityQueue.poll()[1]);
            }
            if (t[i][2] == targetFriend) {
                return treeSet.pollFirst();
            }
            priorityQueue.add(new int[]{t[i][1], treeSet.pollFirst()});
        }
        return -1;
    }
}
