package find.servers.that.handled.most.number.of.requests;

import java.util.*;

/**
 * @author hum
 */
public class FindServersThatHandledMostNumberOfRequests {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int len = arrival.length;
        int[] cnt = new int[k];
        int max = 0;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            set.add(i);
        }
        for (int i = 0; i < len; i++) {
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[0] <= arrival[i]) {
                set.add(priorityQueue.poll()[1]);
            }
            int now = i % k;
            Integer ceiling = set.ceiling(now);
            if (ceiling != null) {
                cnt[ceiling]++;
                max = Math.max(cnt[ceiling], max);
                priorityQueue.add(new int[]{arrival[i] + load[i], ceiling});
                set.remove(ceiling);
            } else {
                Integer first = set.pollFirst();
                if (first != null) {
                    cnt[first]++;
                    max = Math.max(cnt[first], max);
                    priorityQueue.add(new int[]{arrival[i] + load[i], first});
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (cnt[i] == max) {
                res.add(i);
            }
        }
        return res;
    }
}
