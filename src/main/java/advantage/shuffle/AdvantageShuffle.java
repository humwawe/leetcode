package advantage.shuffle;

import java.util.*;

/**
 * @author hum
 */
public class AdvantageShuffle {
    public int[] advantageCount(int[] a, int[] b) {
        Arrays.sort(a);
        List<Integer> list = new ArrayList<>();
        for (int i : a) {
            list.add(i);
        }
        int[] result = new int[a.length];
        for (int i = 0; i < b.length; i++) {
            int index = Collections.binarySearch(list, b[i] + 1);
            if (index < 0) {
                if (-index == list.size() + 1) {
                    index = 0;
                } else {
                    index = -index - 1;
                }
            }
            result[i] = list.get(index);
            list.remove(index);
        }
        return result;
    }
}
