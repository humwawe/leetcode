package letter.cas.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class LetterCasePermutation {
    List<String> result = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        s = s.toLowerCase();
        helper(s, 0, "");
        return result;
    }

    private void helper(String s, int start, String res) {
        if (res.length() == s.length()) {
            result.add(res);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c)) {
                helper(s, i + 1, res + c);
                helper(s, i + 1, res + (char) (c - 'a' + 'A'));
            } else {
                helper(s, i + 1, res + c);
            }
        }
    }
}
