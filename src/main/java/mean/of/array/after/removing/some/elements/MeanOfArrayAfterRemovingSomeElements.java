package mean.of.array.after.removing.some.elements;

import java.util.Arrays;

/**
 * @author hum
 */
public class MeanOfArrayAfterRemovingSomeElements {
    public double trimMean(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        int c = (int) (len * 0.05);
        double res = 0;
        for (int i = c; i < len - c; i++) {
            res += arr[i];
        }
        return res / (len - 2 * c);
    }
}
