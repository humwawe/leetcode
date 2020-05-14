package height.checker;

import java.util.Arrays;

/**
 * @author hum
 */
public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] o = heights.clone();
        Arrays.sort(o);
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != o[i]) {
                result++;
            }
        }
        return result;
    }
}
