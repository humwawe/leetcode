package minimum.absolute.difference.queries;

/**
 * @author hum
 */
public class MinimumAbsoluteDifferenceQueries {
    public int[] minDifference(int[] nums, int[][] queries) {
        int len = nums.length;
        int[][] cntSum = new int[len + 1][101];
        for (int i = 0; i < len; i++) {
            System.arraycopy(cntSum[i], 0, cntSum[i + 1], 0, 101);
            cntSum[i + 1][nums[i]]++;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int last = -1;
            int inf = 200;
            for (int j = 0; j <= 100; j++) {
                if (cntSum[r + 1][j] - cntSum[l][j] > 0) {
                    if (last != -1) {
                        inf = Math.min(inf, j - last);
                    }
                    last = j;
                }
            }
            if (inf != 200) {
                res[i] = inf;
            } else {
                res[i] = -1;
            }
        }
        return res;
    }
}
