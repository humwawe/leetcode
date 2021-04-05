package number.of.different.integers.in.a.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class NumberOfDifferentIntegersInAString {
    public int numDifferentIntegers(String word) {
        String[] words = word.split("[a-z]+");
        Set<String> set = new HashSet<>();
        for (String s : words) {
            if (s.length() == 0) {
                continue;
            }
            int j = 0;
            while (s.charAt(j) == '0' && j < s.length() - 1) {
                j++;
            }
            set.add(s.substring(j));
        }
        return set.size();
    }

}
