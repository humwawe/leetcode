package triangle;

import java.util.List;

/**
 * @author hum
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int[] nums = new int[triangle.size()];
        for (List<Integer> aTriangle : triangle) {
            for (int j = aTriangle.size() - 1; j >= 0; j--) {
                if (j == 0) {
                    nums[j] += aTriangle.get(j);
                } else if (j == aTriangle.size() - 1) {
                    nums[j] = nums[j - 1] + aTriangle.get(j);
                } else {
                    nums[j] = Math.min(nums[j - 1] + aTriangle.get(j), nums[j] + aTriangle.get(j));
                }

            }
        }
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (min > num) {
                min = num;
            }
        }
        return min;
    }
}
