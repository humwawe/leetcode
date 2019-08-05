package maximum.product.of.word.lengths;

import java.util.*;

/**
 * @author hum
 */
public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());
        List<Set<Character>> sets = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            char[] w = words[i].toCharArray();
            Set<Character> set = new HashSet<>();
            for (char c : w) {
                set.add(c);
            }
            sets.add(set);
        }
        System.out.println(sets);
        int result = 0;
        for (int i = 0; i < sets.size() - 1; i++) {
            Set<Character> set = sets.get(i);
            for (int j = i + 1; j < sets.size(); j++) {
                int len = words[i].length() * words[j].length();
                if (len < result) {
                    break;
                }
                Set<Character> set2 = new HashSet<>(sets.get(j));
                set2.retainAll(set);
                if (0 == set2.size()) {
                    System.out.println(set);
                    result = len;
                    break;
                }
            }
        }
        return result;
    }

}
