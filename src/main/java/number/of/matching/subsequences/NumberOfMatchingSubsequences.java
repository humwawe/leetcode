package number.of.matching.subsequences;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author hum
 */
public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String s, String[] words) {
        List<TreeSet<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add(new TreeSet<>());
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            list.get(c - 'a').add(i);
        }

        int result = 0;
        for (String word : words) {
            int count = -1;
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Integer higher = list.get(c - 'a').higher(count);
                if (higher == null) {
                    flag = false;
                    break;
                }
                count = higher;

            }
            if (flag) {
                result++;
            }
        }
        return result;
    }

}
