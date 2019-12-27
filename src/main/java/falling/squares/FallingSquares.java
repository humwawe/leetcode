package falling.squares;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class FallingSquares {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> result = new ArrayList<>();
        int len = positions.length;
        int[] height = new int[len];
        height[0] = positions[0][1];
        int max = height[0];
        result.add(max);
        for (int i = 1; i < len; i++) {
            int start = positions[i][0];
            int end = positions[i][0] + positions[i][1];
            height[i] = positions[i][1];
            int h = positions[i][1];
            for (int j = i - 1; j >= 0; j--) {
                if (start >= positions[j][0] + positions[j][1] || end <= positions[j][0]) {
                    continue;
                }
                height[i] = Math.max(height[i], height[j] + h);
            }
            max = Math.max(max, height[i]);
            result.add(max);
        }
        return result;
    }
}
