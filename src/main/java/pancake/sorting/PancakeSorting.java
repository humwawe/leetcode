package pancake.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class PancakeSorting {
    public List<Integer> pancakeSort(int[] a) {
        int len = a.length - 1;
        List<Integer> list = new ArrayList<>();
        while (len > 0) {
            int start = 0, end = len, max = -1, index = 0;
            for (int i = start; i <= end; i++) {
                if (a[i] > max) {
                    max = a[i];
                    index = i;
                }
            }
            if (index == end) {
                len--;
                continue;
            }
            for (int i = 0; i < (index + 1) / 2; i++) {
                int tmp = a[i];
                a[i] = a[index - i];
                a[index - i] = tmp;
            }
            list.add(index + 1);
            for (int i = 0; i < (end + 1) / 2; i++) {
                int tmp = a[i];
                a[i] = a[end - i];
                a[end - i] = tmp;
            }
            list.add(end + 1);
            len--;
        }
        return list;
    }
}
