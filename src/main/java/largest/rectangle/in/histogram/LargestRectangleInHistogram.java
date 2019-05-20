package largest.rectangle.in.histogram;

/**
 * @author hum
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {

        return helper(heights, 0, heights.length - 1);

    }

    private int helper(int[] heights, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return heights[i];
        }
        int mid = i;
        for (int k = i; k <= j; k++) {
            if (heights[mid] > heights[k]) {
                mid = k;
            }
        }

        int left = helper(heights, i, mid - 1);
        int right = helper(heights, mid + 1, j);
        int now = (j - i + 1) * heights[mid];
        return Math.max(Math.max(left, right), now);
    }


}
