package find.all.anagrams.in.a.String;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] target = new int[26];
        int[] source = new int[26];
        for (char c : p.toCharArray()) {
            target[c - 'a']++;
        }
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            int tmp = s.charAt(j) - 'a';
            source[tmp]++;
            while (source[tmp] > target[tmp] && i <= j) {
                source[s.charAt(i) - 'a']--;
                i++;
            }
            if (j - i == p.length() - 1) {
                result.add(i);
            }
            j++;
        }
        return result;
    }
}
