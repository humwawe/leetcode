package partition.array.into.two.arrays.to.minimize.sum.difference;

import java.util.TreeSet;

/**
 * @author hum
 */
public class PartitionArrayIntoTwoArraysToMinimizeSumDifference {
    int n;
    int len;
    int res = (int) 1e9;
    int sum = 0;
    int[] nums;
    TreeSet<Integer>[] sets;

    public int minimumDifference(int[] nums) {
        len = nums.length;
        n = len / 2;
        for (int num : nums) {
            sum += num;
        }
        this.nums = nums;
        sets = new TreeSet[n + 1];
        for (int i = 0; i < n + 1; i++) {
            sets[i] = new TreeSet<>();
        }
        helper1(0, 0, 0);
        helper2(n, 0, 0);
        return res;
    }

    private void helper1(int i, int cnt, int s) {
        if (i == n) {
            sets[cnt].add(s);
            return;
        }
        helper1(i + 1, cnt + 1, s + nums[i]);
        helper1(i + 1, cnt, s);
    }

    private void helper2(int i, int cnt, int s) {
        if (i == len) {
            int t = n - cnt;
            int find = sum / 2 - s;
            Integer ceiling = sets[t].ceiling(find);
            if (ceiling != null) {
                res = Math.min(res, Math.abs(sum - 2 * (s + ceiling)));
            }
            Integer floor = sets[t].floor(find);
            if (floor != null) {
                res = Math.min(res, Math.abs(sum - 2 * (s + floor)));
            }
            return;
        }
        helper2(i + 1, cnt + 1, s + nums[i]);
        helper2(i + 1, cnt, s);
    }
}
