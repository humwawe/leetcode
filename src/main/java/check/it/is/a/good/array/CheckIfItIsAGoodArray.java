package check.it.is.a.good.array;

/**
 * @author hum
 */
public class CheckIfItIsAGoodArray {
    public boolean isGoodArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = gcd(res, nums[i]);
        }
        return res == 1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
