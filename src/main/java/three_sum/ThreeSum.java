package three_sum;


import java.util.*;

/**
 * List
 *
 * @author hum
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        Set<List<Integer>> results = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int c = -nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == c) {
//                    List<Integer> result = new ArrayList<>();
//                    result.add(-c);
//                    result.add(nums[left]);
//                    result.add(nums[right]);
                    results.add(Arrays.asList(-c, nums[left], nums[right]));
                    left++;
                    right--;
                } else if (nums[left] + nums[right] > c) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return new ArrayList<>(results);
    }

}
