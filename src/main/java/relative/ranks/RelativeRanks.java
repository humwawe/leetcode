package relative.ranks;

import java.util.PriorityQueue;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(new int[]{nums[i], i});
        }
        String[] result = new String[nums.length];
        int count = 0;
        String[] res = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        while (!priorityQueue.isEmpty()) {
            int[] ele = priorityQueue.poll();
            int index = ele[1];
            if (count < 3) {
                result[index] = res[count++];
            } else {
                result[index] = String.valueOf(++count);
            }

        }
        return result;
    }
}
