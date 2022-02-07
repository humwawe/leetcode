package all.divisions.with.the.highest.score.of.a.binary.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class AllDivisionsWithTheHighestScoreOfABinaryArray {
    public List<Integer> maxScoreIndices(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        List<Integer> list = new ArrayList<>();
        int max = 0;
        int left = 0;
        int right = sum;
        for (int num : nums) {
            max = Math.max(max, left + right);
            list.add(left + right);
            if (num == 0) {
                left++;
            } else {
                right--;
            }
        }
        max = Math.max(max, left + right);
        list.add(left + right);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == max) {
                res.add(i);
            }
        }
        return res;
    }
}
