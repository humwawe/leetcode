package maximum.number.of.non.overlapping.substrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author hum
 */
public class MaximumNumberOfNonOverlappingSubstrings {
    public List<String> maxNumOfSubstrings(String s) {
        int[][] tmp = new int[26][2];
        for (int i = 0; i < 26; i++) {
            tmp[i][0] = (int) 1e8;
            tmp[i][1] = -(int) 1e8;
        }
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            tmp[c - 'a'][0] = Math.min(tmp[c - 'a'][0], i);
            tmp[c - 'a'][1] = Math.max(tmp[c - 'a'][1], i);
        }
        for (int i = 0; i < 26; i++) {
            int l = tmp[i][0];
            int r = tmp[i][1];
            int x = l;
            int y = l;
            while (x < r || y > l) {
                while (x < r) {
                    l = Math.min(l, tmp[s.charAt(x) - 'a'][0]);
                    r = Math.max(r, tmp[s.charAt(x) - 'a'][1]);
                    x++;
                }
                while (y > l) {
                    l = Math.min(l, tmp[s.charAt(y) - 'a'][0]);
                    r = Math.max(r, tmp[s.charAt(y) - 'a'][1]);
                    y--;
                }
            }
            tmp[i][0] = l;
            tmp[i][1] = r;
        }
        Integer[] idx = new Integer[26];
        for (int i = 0; i < 26; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, Comparator.comparingInt(a -> tmp[a][1]));
        List<String> result = new ArrayList<>();
        int end = -1;
        for (int i = 0; i < 26; i++) {
            if (tmp[idx[i]][0] == (int) 1e8) {
                continue;
            }
            if (tmp[idx[i]][0] > end) {
                result.add(s.substring(tmp[idx[i]][0], tmp[idx[i]][1] + 1));
                end = tmp[idx[i]][1];
            }
        }
        return result;
    }
}
