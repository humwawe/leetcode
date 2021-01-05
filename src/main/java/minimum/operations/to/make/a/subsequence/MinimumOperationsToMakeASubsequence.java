package minimum.operations.to.make.a.subsequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class MinimumOperationsToMakeASubsequence {
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = target.length, m = arr.length;
        for (int i = 0; i < n; i++) {
            map.put(target[i], i + 1);
        }

        int[] tmp = new int[m + 1];
        int idx = 0;
        for (int value : arr) {
            if (map.containsKey(value)) {
                tmp[idx++] = map.get(value);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < idx; i++) {
            if (list.isEmpty() || tmp[i] > list.get(list.size() - 1)) {
                list.add(tmp[i]);
            } else {
                int l = 0, r = list.size() - 1;
                while (l < r) {
                    int mid = l + r >> 1;
                    if (list.get(mid) >= tmp[i]) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                list.set(l, tmp[i]);
            }
        }
        return n - list.size();
    }
}
