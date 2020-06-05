package minimum.absolute.difference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i] - arr[i - 1]);
        }
        for (int i = 1; i < arr.length; i++) {
            if (min == arr[i] - arr[i - 1]) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(arr[i - 1]);
                tmp.add(arr[i]);
                result.add(tmp);
            }
        }
        return result;
    }
}
