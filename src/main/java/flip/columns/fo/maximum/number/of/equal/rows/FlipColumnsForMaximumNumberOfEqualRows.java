package flip.columns.fo.maximum.number.of.equal.rows;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class FlipColumnsForMaximumNumberOfEqualRows {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        for (int[] m : matrix) {
            if (m[0] == 1) {
                flip(m);
            }
            String string = Arrays.toString(m);
            map.put(string, map.getOrDefault(string, 0) + 1);
        }
        int result = 0;
        for (Integer value : map.values()) {
            result = Math.max(result, value);
        }
        return result;
    }

    void flip(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] ^= 1;
        }
    }
}
