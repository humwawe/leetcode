package squares.of.a.sorted.array;

/**
 * @author hum
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] a) {
        int len = a.length;
        int l = 0;
        int r = len - 1;
        int[] result = new int[len];
        for (int i = len - 1; i > 0; i--) {
            int x = a[l] * a[l];
            int y = a[r] * a[r];
            if (x >= y) {
                result[i] = x;
                l++;
            } else {
                result[i] = y;
                r--;
            }
        }
        return result;
    }
}
