package smallest.string.with.swaps;

import java.util.*;

/**
 * @author hum
 */
public class SmallestStringWithSwaps {
    int[] p;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();
        p = new int[len];
        for (int i = 0; i < len; i++) {
            p[i] = i;
        }
        for (List<Integer> pair : pairs) {
            int a = pair.get(0);
            int b = pair.get(1);
            p[find(a)] = find(b);
        }
        char[] res = new char[len];
        Map<Integer, List<Integer>> map1 = new HashMap<>();
        Map<Integer, List<Character>> map2 = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int idx = find(i);
            if (!map1.containsKey(idx)) {
                map1.put(idx, new ArrayList<>());
                map2.put(idx, new ArrayList<>());
            }
            map1.get(idx).add(i);
            map2.get(idx).add(s.charAt(i));
        }
        for (Integer integer : map1.keySet()) {
            List<Integer> list = map1.get(integer);
            List<Character> list2 = map2.get(integer);
            Collections.sort(list2);
            for (int i = 0; i < list.size(); i++) {
                res[list.get(i)] = list2.get(i);
            }
        }
        return String.valueOf(res);
    }

    int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
