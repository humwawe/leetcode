package find.k.closest.elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i = Arrays.binarySearch(arr, x);
        if (i < 0) {
            i = -i - 1;
        }
        int l = i;
        int r = i;

        while (r - l < k) {
            if (r == arr.length) {
                l--;
            } else if (l == -1) {
                r++;
            } else if (Math.abs(arr[l] - x) >= Math.abs(arr[r] - x)) {
                r++;
            } else {
                l--;
            }
        }
        List<Integer> result = new ArrayList<>();
        if (l == -1) {
            l++;
            r++;
        }
        for (int j = l; j < r; j++) {
            result.add(arr[j]);
        }
        return result;
    }
}
