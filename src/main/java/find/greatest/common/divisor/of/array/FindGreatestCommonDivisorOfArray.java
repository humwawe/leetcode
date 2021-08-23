package find.greatest.common.divisor.of.array;

import java.util.Arrays;

/**
 * @author hum
 */
public class FindGreatestCommonDivisorOfArray {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int x = nums[0];
        int y = nums[nums.length - 1];
        return gcd(x, y);
    }

    int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
