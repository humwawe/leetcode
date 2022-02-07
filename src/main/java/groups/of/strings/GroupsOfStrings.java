package groups.of.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class GroupsOfStrings {
    public int[] groupStrings(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        n = words.length;
        p = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
            size[i] = 1;
        }

        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long w = helper(words[i]);
            if (map.containsKey(w)) {
                union(i, map.get(w));
            }
            map.put(w, i);
            for (int j = 0; j < words[i].length(); j++) {
                long tmp = w - (1 << (words[i].charAt(j) - 'a'));
                if (map.containsKey(tmp)) {
                    union(i, map.get(tmp));
                }
                map.put(tmp, i);
            }
        }

        int[] res = new int[2];
        for (int i = 0; i < n; i++) {
            if (p[i] == i) {
                res[0]++;
            }
            res[1] = Math.max(res[1], size[i]);
        }
        return res;
    }

    private long helper(String word) {
        long res = 0;
        for (int i = 0; i < word.length(); i++) {
            res |= (1 << (word.charAt(i) - 'a'));
        }
        return res;
    }

    int n;
    int[] p;
    int[] size;

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    void union(int a, int b) {
        if (find(a) == find(b)) {
            return;
        }
        size[find(b)] += size[find(a)];
        p[find(a)] = find(b);
    }
}
