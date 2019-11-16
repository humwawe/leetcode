package longest.word.in.dictionary.through.deleting;

import java.util.List;

/**
 * @author hum
 */
public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        d.sort((a, b) -> {
            if (a.length() > b.length()) {
                return -1;
            } else if (a.length() < b.length()) {
                return 1;
            } else {
                return a.compareTo(b);
            }
        });
        for (String res : d) {
            if (res.length() > s.length()) {
                continue;
            }
            if (helper(res, s)) {
                return res;
            }
        }
        return "";
    }

    private boolean helper(String str1, String str2) {
        int j = 0;
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == str1.charAt(j)) {
                j++;
                if (j == str1.length()) {
                    return true;
                }
            }
        }
        return false;
    }

}
