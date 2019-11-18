package k.diff.pairs.in.an.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num - k)) {
                if (set2.contains(num - k)) {
                    continue;
                }
                result++;
                set2.add(num - k);
            }
            set.add(num);
        }
        System.out.println(set2);
        return result;
    }
}
