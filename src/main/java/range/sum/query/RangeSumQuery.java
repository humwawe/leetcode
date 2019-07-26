package range.sum.query;

/**
 * @author hum
 */
public class RangeSumQuery {

    int[] sum;

    public RangeSumQuery(int[] nums) {
        int len = nums.length;
        sum = new int[len + 1];
        sum[0] = 0;
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
