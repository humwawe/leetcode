package online.majority.element.in.subarray;

import java.util.*;

/**
 * @author hum
 */
public class OnlineMajorityElementInSubarray {
    Map<Integer, List<Integer>> map = new HashMap<>();
    List<int[]> list = new ArrayList<>();

    public OnlineMajorityElementInSubarray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
        for (Integer i : map.keySet()) {
            list.add(new int[]{i, map.get(i).size()});
        }
        list.sort((a, b) -> b[1] - a[1]);
        System.out.println(map);
        System.out.println(list);
    }

    public int query(int left, int right, int threshold) {
        int remain = right - left + 1;
        for (int[] l : list) {
            int k = l[0];
            List<Integer> li = map.get(k);
            boolean f = false;
            int p1 = Collections.binarySearch(li, left);
            if (p1 < 0) {
                p1 = ~p1;
            }
            int p2 = Collections.binarySearch(li, right);
            if (p2 < 0) {
                p2 = ~p2;
                f = true;
            }
            int c = 0;
            if (f) {
                c = p2 - p1;
            } else {
                c = p2 - p1 + 1;
            }
            if (c >= threshold) {
                return k;
            } else {
                remain -= c;
            }
            if (remain < threshold) {
                return -1;
            }
        }
        return -1;
    }
}
