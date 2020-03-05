package length.of.longest.fibonacci.subsequence;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class LengthOfLongestFibonacciSubsequence {
    public int lenLongestFibSubseq(int[] a) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : a) {
            set.add(i);
        }
        int len = a.length;
        for (int i = 0; i < len - result; i++) {
            for (int j = i + 1; j < len; j++) {
                int first = a[i];
                int second = a[j];
                int count = 2;
                int third = first + second;
                while (set.contains(third)) {
                    count++;
                    first = second;
                    second = third;
                    third = first + second;
                }
                result = Math.max(result, count);
            }
        }
        return result == 2 ? 0 : result;
    }
}
