package sort.an.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hum
 */
public class SortAnArray {
    public List<Integer> sortArray(int[] nums) {
        Arrays.sort(nums);
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
    }
}
