package set.intersection.size.at.least.two;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hum
 */
public class SetIntersectionSizeAtLeastTwo {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int result = 0;
        int one = 0;
        int two = 0;
        for (int[] interval : intervals) {
            if (one < interval[0]) {
                one = interval[1];
                two = interval[1] - 1;
                result += 2;
            } else if (two < interval[0]) {
                two = one;
                one = interval[1];
                result += 1;
            }

        }
        return result;
    }
}
