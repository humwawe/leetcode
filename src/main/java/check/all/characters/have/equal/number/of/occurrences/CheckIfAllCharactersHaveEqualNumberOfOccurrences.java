package check.all.characters.have.equal.number.of.occurrences;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class CheckIfAllCharactersHaveEqualNumberOfOccurrences {
    public boolean areOccurrencesEqual(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) {
                set.add(cnt[i]);
            }
        }
        return set.size() == 1;
    }
}
