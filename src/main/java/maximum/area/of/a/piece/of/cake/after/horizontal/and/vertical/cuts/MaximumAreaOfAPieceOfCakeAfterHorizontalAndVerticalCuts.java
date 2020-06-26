package maximum.area.of.a.piece.of.cake.after.horizontal.and.vertical.cuts;

import java.util.Arrays;

/**
 * @author hum
 */
public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int row = horizontalCuts.length;
        int col = verticalCuts.length;
        int prev = 0;
        long t1 = 0;
        long t2 = 0;
        for (int i = 0; i < row; i++) {
            t1 = Math.max(t1, horizontalCuts[i] - prev);
            prev = horizontalCuts[i];
        }
        t1 = Math.max(t1, h - horizontalCuts[row - 1]);
        prev = 0;
        for (int i = 0; i < col; i++) {
            t2 = Math.max(t2, verticalCuts[i] - prev);
            prev = verticalCuts[i];
        }
        t2 = Math.max(t2, w - verticalCuts[col - 1]);
        int mod = (int) (1e9 + 7);
        return (int) ((t1 * t2) % mod);
    }
}
