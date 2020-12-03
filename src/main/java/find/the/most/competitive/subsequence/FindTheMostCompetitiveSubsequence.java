package find.the.most.competitive.subsequence;

import java.util.Stack;

/**
 * @author hum
 */
public class FindTheMostCompetitiveSubsequence {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && stack.size() + len - i > k && stack.peek() > nums[i]) {
                stack.pop();
            }
            stack.push(nums[i]);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = stack.get(i);
        }
        return res;
    }
}
