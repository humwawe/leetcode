package four.divisors;

/**
 * @author hum
 */
public class FourDivisors {
    public int sumFourDivisors(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int count = 0;
            for (int j = 1; j <= Math.sqrt(nums[i]); j++) {
                if (nums[i] % j == 0) {
                    int other = nums[i] / j;
                    if (other != j) {
                        count += 2;
                        sum += other + j;
                    } else {
                        count += 1;
                        sum += j;
                    }
                }
            }
            if (count == 4) {
                result += sum;
            }
        }
        return result;
    }
}
