package longest.arithmetic.subsequence.of.given.difference;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class LongestArithmeticSubsequenceOfGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int result=0;
        for (int i : arr) {
            map.put(i, map.getOrDefault(i - difference, 0) + 1);
            result=Math.max(result,map.get(i));
        }
        return result;
    }
}
