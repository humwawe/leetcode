package create.maximum.number;

import java.util.Stack;

/**
 * @author hum
 */
public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] result = new int[k];

        int len = Math.min(m, k);

        for (int i = 0; i <= len; i++) {
            int[] n1 = helper(nums1, i);
            if (k - i > nums2.length) {
                continue;
            }
            int[] n2 = helper(nums2, k - i);
            int[] temp = merge(n1, n2);
            for (int j = 0; j < k; j++) {
                if (temp[j] == result[j]) {
                    continue;
                } else if (temp[j] > result[j]) {
                    result = temp;
                    break;
                }
                break;
            }
        }
        return result;


    }

    private int[] merge(int[] n1, int[] n2) {
        int[] res = new int[n1.length + n2.length];
        int index1 = 0;
        int index2 = 0;
        int j = 0;
        while (index1 < n1.length && index2 < n2.length) {
            if (n1[index1] > n2[index2]) {
                res[j++] = n1[index1++];
            } else if (n1[index1] < n2[index2]) {
                res[j++] = n2[index2++];
            } else {
                if (getNextStep(n1, n2, index1, index2)) {
                    res[j++] = n1[index1++];
                } else {
                    res[j++] = n2[index2++];
                }

            }
        }
        while (index1 < n1.length) {
            res[j++] = n1[index1++];
        }
        while (index2 < n2.length) {
            res[j++] = n2[index2++];
        }
        return res;

    }

    private boolean getNextStep(int[] n1, int[] n2, int index1, int index2) {
        if (index1 == n1.length) {
            return false;
        }
        if (index2 == n2.length) {
            return true;
        }
        if (n1[index1] > n2[index2]) {
            return true;
        }
        if (n1[index1] < n2[index2]) {
            return false;
        }
        return getNextStep(n1, n2, index1 + 1, index2 + 1);
    }

    private int[] helper(int[] nums, int len) {
        if (len == 0) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums[i] && nums.length - i > len - stack.size()) {
                stack.pop();
            }
            if (stack.size() < len) {
                stack.push(nums[i]);
            }

        }
        int l = stack.size();
        int[] res = new int[l];
        for (int i = l - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
