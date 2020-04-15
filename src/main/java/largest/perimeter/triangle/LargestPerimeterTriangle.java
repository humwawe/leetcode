package largest.perimeter.triangle;

import java.util.Arrays;

/**
 * @author hum
 */
public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] a) {
        Arrays.sort(a);
        for (int i = a.length - 1; i >= 2; i--) {
            if (a[i - 2] + a[i - 1] > a[i]) {
                return a[i - 2] + a[i - 1] + a[i];
            }
        }
        return 0;
    }
}
