package minimum.domino.rotations.fo.equal.row;

/**
 * @author hum
 */
public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] a, int[] b) {
        int len = a.length;
        int result = Integer.MAX_VALUE;
        f:
        for (int i = 1; i <= 6; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                if (a[j] != i) {
                    if (b[j] != i) {
                        continue f;
                    } else {
                        count++;
                    }
                }
            }
            result = Math.min(result, count);
        }
        f2:
        for (int i = 1; i <= 6; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                if (b[j] != i) {
                    if (a[j] != i) {
                        continue f2;
                    } else {
                        count++;
                    }
                }
            }
            result = Math.min(result, count);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
