package minimum.numbers.of.function.calls.to.make.target.array;

/**
 * @author hum
 */
public class MinimumNumbersOfFunctionCallsToMakeTargetArray {
    public int minOperations(int[] nums) {
        int count = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            count += Integer.bitCount(num);
        }
        count += Integer.toBinaryString(max).length() - 1;
        return count;
    }
}
