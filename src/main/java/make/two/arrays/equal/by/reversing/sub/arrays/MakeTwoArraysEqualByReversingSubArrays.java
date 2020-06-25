package make.two.arrays.equal.by.reversing.sub.arrays;

import java.util.Arrays;

/**
 * @author hum
 */
public class MakeTwoArraysEqualByReversingSubArrays {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
}
