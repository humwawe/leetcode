package form.array.by.concatenating.subarrays.of.another.array;

/**
 * @author hum
 */
public class FormArrayByConcatenatingSubarraysOfAnotherArray {
    public boolean canChoose(int[][] groups, int[] nums) {
        int n = nums.length, m = groups.length;
        int cnt = 0;
        for (int i = 0, j = 0; i < n && j < m; ) {
            if (check(groups[j], nums, i)) {
                i += groups[j].length;
                j++;
                cnt++;
            } else {
                i++;
            }
        }
        return cnt == m;

    }

    boolean check(int[] g, int[] nums, int i) {
        int j = 0;
        for (; j < g.length && i < nums.length; j++, i++) {
            if (g[j] != nums[i]) {
                return false;
            }
        }
        return j == g.length;
    }

}
