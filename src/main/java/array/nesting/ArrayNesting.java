package array.nesting;

public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int len = nums.length;
        boolean[] vis = new boolean[len];
        int result = 0;
        for (int i = 0; i < len; i++) {
            int count = 0;
            int j = i;
            if (vis[i]) {
                continue;
            }
            while (!vis[j]) {
                count++;
                vis[j] = true;
                j = nums[j];
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
