package four.sum.II;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length;
        Map<Integer, Integer> abMap = new HashMap<>();
        Map<Integer, Integer> cdMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int tmp = A[i] + B[j];
                abMap.put(tmp, abMap.getOrDefault(tmp, 0) + 1);
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int tmp = C[i] + D[j];
                cdMap.put(tmp, cdMap.getOrDefault(tmp, 0) + 1);
            }
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : abMap.entrySet()) {
            int key = integerIntegerEntry.getKey();
            if (cdMap.containsKey(-key)) {
                result += abMap.get(key) * cdMap.get(-key);
            }
        }
        return result;
    }
}
