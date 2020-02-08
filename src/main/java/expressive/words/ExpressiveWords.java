package expressive.words;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class ExpressiveWords {
    public int expressiveWords(String s, String[] words) {
        List<Character> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        char c = s.charAt(0);
        int index = 0;
        while (index < s.length()) {
            int count = 0;
            while (index < s.length() && s.charAt(index) == c) {
                index++;
                count++;
            }
            list1.add(c);
            list2.add(count);
            if (index < s.length()) {
                c = s.charAt(index);
            }
        }

        int result = 0;

        for (String word : words) {
            c = word.charAt(0);
            int i = 0;
            int j = 0;
            boolean flag = true;
            while (i < word.length()) {
                int count = 0;
                while (i < word.length() && word.charAt(i) == c) {
                    i++;
                    count++;
                }
                if (list1.get(j) != c || list2.get(j) < count) {
                    flag = false;
                    break;
                }
                if (list2.get(j) > count && list2.get(j) < 3) {
                    flag = false;
                    break;
                }
                if (i < word.length()) {
                    c = word.charAt(i);
                }
                j++;
            }
            if (flag && j == list1.size()) {
                result++;
            }
        }
        return result;
    }
}
