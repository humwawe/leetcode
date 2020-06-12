package greatest.sum.divisible.by.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class GreatestSumDivisibleByThree {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int num : nums) {
            sum += num;
            if (num % 3 == 1) {
                list1.add(num);
            } else if (num % 3 == 2) {
                list2.add(num);
            }
        }
        if (sum % 3 == 0) {
            return sum;
        } else if (sum % 3 == 1) {
            int res = 0;
            if (list2.size() >= 2) {
                res = Math.max(res, sum - list2.get(0) - list2.get(1));
            }
            if (list1.size() >= 1) {
                res = Math.max(res, sum - list1.get(0));
            }
            return res;
        } else {
            int res = 0;
            if (list2.size() >= 1) {
                res = Math.max(res, sum - list2.get(0));
            }
            if (list1.size() >= 2) {
                res = Math.max(res, sum - list1.get(0) - list1.get(1));
            }
            return res;
        }
    }
}
