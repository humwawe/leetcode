package minimum.difference.in.sums.after.removal.of.elements;

import java.util.PriorityQueue;

/**
 * @author hum
 */
public class MinimumDifferenceInSumsAfterRemovalOfElements {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        long[] min = new long[3 * n];
        long[] max = new long[3 * n];

        PriorityQueue<Integer> asc = new PriorityQueue<>();
        PriorityQueue<Integer> desc = new PriorityQueue<>((a, b) -> b - a);

        long sumFirst = 0;
        long sumSecond = 0;
        for (int i = 0; i < 3 * n; i++) {
            int l = i;
            int r = 3 * n - 1 - i;
            int left = nums[l], right = nums[r];

            sumFirst += left;
            desc.add(left);
            sumSecond += right;
            asc.add(right);

            if (i >= n) {
                sumFirst -= desc.poll();
                sumSecond -= asc.poll();
            }
            min[l] = sumFirst;
            max[r] = sumSecond;
        }

        long res = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            res = Math.min(res, min[i] - max[i + 1]);
        }

        return res;
    }

}
