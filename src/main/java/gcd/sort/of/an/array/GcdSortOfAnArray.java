package gcd.sort.of.an.array;

import java.util.*;

/**
 * @author hum
 */
public class GcdSortOfAnArray {
    int N = (int) (1e5 + 5);
    int[] p = new int[N];

    public boolean gcdSort(int[] nums) {
        for (int i = 0; i < N; i++) {
            p[i] = i;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int x = nums[i];
            for (int j = 2; j * j <= x; j++) {
                boolean f = false;
                while (x % j == 0) {
                    x /= j;
                    f = true;
                }
                if (f) {
                    p[find(nums[i])] = find(j);
                }
            }
            if (x != 1) {
                p[find(nums[i])] = find(x);
            }
        }
        Map<Integer, List<Integer>> num = new HashMap<>();
        Map<Integer, List<Integer>> idx = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int x = find(nums[i]);
            if (!num.containsKey(x)) {
                num.put(x, new ArrayList<>());
                idx.put(x, new ArrayList<>());
            }
            num.get(x).add(nums[i]);
            idx.get(x).add(i);
        }
        int[] res = new int[len];
        for (Integer integer : num.keySet()) {
            List<Integer> i = num.get(integer);
            List<Integer> j = idx.get(integer);
            Collections.sort(i);
            Collections.sort(j);
            for (int k = 0; k < j.size(); k++) {
                res[j.get(k)] = i.get(k);
            }
        }

        for (int i = 1; i < len; i++) {
            if (res[i] < res[i - 1]) {
                return false;
            }
        }
        return true;
    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
