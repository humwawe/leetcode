package word.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class WordSubsets {
    public List<String> wordSubsets(String[] a, String[] b) {
        List<String> result = new ArrayList<>();
        int[] res = new int[26];
        for (String s : b) {
            int[] tmp = new int[26];
            for (char c : s.toCharArray()) {
                tmp[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                res[i] = Math.max(res[i], tmp[i]);
            }
        }
        for (String s : a) {
            int[] tmp = new int[26];
            for (char c : s.toCharArray()) {
                tmp[c - 'a']++;
            }
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (tmp[i] < res[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(s);
            }
        }
        return result;
    }
}
