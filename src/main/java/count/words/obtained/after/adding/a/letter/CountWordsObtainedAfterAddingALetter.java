package count.words.obtained.after.adding.a.letter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class CountWordsObtainedAfterAddingALetter {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer> set = new HashSet<>();
        for (String startWord : startWords) {
            int tmp = 0;
            for (char c : startWord.toCharArray()) {
                tmp += 1 << (c - 'a');
            }
            set.add(tmp);
        }
        int res = 0;
        f:
        for (String targetWord : targetWords) {
            int sum = 0;
            for (char c : targetWord.toCharArray()) {
                sum += 1 << (c - 'a');
            }
            for (char c : targetWord.toCharArray()) {
                if (set.contains(sum - (1 << (c - 'a')))) {
                    res++;
                    continue f;
                }
            }
        }
        return res;
    }
}
