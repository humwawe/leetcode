package find.common.characters;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class FindCommonCharacters {
    public List<String> commonChars(String[] a) {
        int len = a.length;
        int[][] t = new int[len][26];
        for (int i = 0; i < len; i++) {
            for (char c : a[i].toCharArray()) {
                t[i][c - 'a']++;
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int count = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                count = Math.min(count, t[j][i]);
            }
            while (count-- > 0) {
                result.add(String.valueOf((char) ('a' + i)));
            }
        }
        return result;
    }
}
