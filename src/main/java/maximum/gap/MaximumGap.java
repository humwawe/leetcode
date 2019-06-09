package maximum.gap;

import java.util.BitSet;

/**
 * @author hum
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        BitSet bitSet = new BitSet();
        for (int num : nums) {
            bitSet.set(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int result = 0;
        int start = min;
        while (start < max) {
            int j = bitSet.nextSetBit(start + 1);
            result = Math.max(result, j - start);
            start = j;
        }
        return result;
    }
}
