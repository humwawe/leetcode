package number.of.ways.to.reorder.array.to.get.same.bst;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class NumberOfWaysToReorderArrayToGetSameBst {
    int N = 1005;
    long[][] c = new long[N][N];
    int mod = (int) (1e9 + 7);

    public int numOfWays(int[] nums) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    c[i][j] = 1;
                } else {
                    c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % mod;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return (helper(list) + mod - 1) % mod;

    }

    private int helper(List<Integer> nums) {
        int len = nums.size();
        if (len <= 1) {
            return 1;
        }
        List<Integer> l = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            if (nums.get(i) > nums.get(0)) {
                r.add(nums.get(i));
            } else {
                l.add(nums.get(i));
            }
        }
        return (int) ((c[len - 1][l.size()] * helper(l) % mod) * helper(r) % mod);
    }
}


