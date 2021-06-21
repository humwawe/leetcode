package find.a.peak.element.II;

/**
 * @author hum
 */
public class FindAPeakElementII {
    public int[] findPeakGrid(int[][] mat) {
        int row = mat.length;
        int l = 0;
        int r = row - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            System.out.println(mid);
            int[] maxUp = mid == 0 ? new int[]{-1, 0} : getMax(mat[mid - 1]);
            int[] maxBottom = mid == row - 1 ? new int[]{-1, 0} : getMax(mat[mid + 1]);
            int[] cur = getMax(mat[mid]);
            if (cur[0] >= Math.max(maxUp[0], maxBottom[0])) {
                return new int[]{mid, cur[1]};
            } else if (maxUp[0] >= Math.max(cur[0], maxBottom[0])) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return new int[]{l, getMax(mat[l])[1]};
    }

    private int[] getMax(int[] v) {
        int idx = 0;
        int max = -2;
        for (int i = 0; i < v.length; i++) {
            if (v[i] > max) {
                max = v[i];
                idx = i;
            }
        }
        return new int[]{max, idx};
    }
}
