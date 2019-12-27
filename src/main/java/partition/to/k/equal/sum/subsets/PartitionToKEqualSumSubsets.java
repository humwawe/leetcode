package partition.to.k.equal.sum.subsets;

import java.util.*;

/**
 * @author hum
 */
public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int num : nums) {
            sum += num;
            list.add(num);
            list2.add(num);
        }
        if (sum % k != 0) {
            return false;
        }
        int num = sum / k;
        Collections.sort(list);
        Collections.sort(list2);
        Collections.reverse(list2);
        System.out.println(list);
        System.out.println(list2);
        boolean flag = true;
        for (int i = 0; i < k; i++) {
            Set<Integer> set = new HashSet<>();
            if (helper(list, num, 0, set)) {
                for (int j = list.size() - 1; j >= 0; j--) {
                    if (set.contains(j)) {
                        list.remove(j);
                    }
                }
            } else {
                flag = false;
                break;
            }
        }
        if (!flag) {
            for (int i = 0; i < k; i++) {
                Set<Integer> set = new HashSet<>();
                if (helper(list2, num, 0, set)) {
                    for (int j = list2.size() - 1; j >= 0; j--) {
                        System.out.println(set);
                        if (set.contains(j)) {
                            list2.remove(j);
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        return true;

    }

    private boolean helper(List<Integer> list, int num, int i, Set<Integer> set) {
        if (num == 0) {
            return true;
        }
        if (i == list.size()) {
            return false;
        }
        set.add(i);
        boolean f2 = helper(list, num - list.get(i), i + 1, set);
        if (!f2) {
            set.remove(i);
            return helper(list, num, i + 1, set);
        }
        return true;
    }
}
