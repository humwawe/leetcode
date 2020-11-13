package minimum.deletions.to.make.character.frequencies.unique;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public int minDeletions(String s) {
        int[] a = new int[26];
        for (char c : s.toCharArray()) {
            a[c - 'a']++;
        }
        Set<Integer> h = new HashSet<Integer>();
        int res = 0;
        for (int i : a) {
            if (i != 0) {
                while (h.contains(i)) {
                    i--;
                    res++;
                }
                if (i != 0) {
                    h.add(i);
                }
            }
        }
        return res;
    }
}
