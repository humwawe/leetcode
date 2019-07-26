package remove.invalid.parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class RemoveInvalidParentheses {
    List<String> result = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int len = s.length();
        int left = 0, right = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        helper(s, 0, left, right);

        return result;
    }

    private void helper(String s, int start, int left, int right) {
        if (left == 0 && right == 0) {
            if (check(s)) {
                result.add(s);
            }
            return;
        }
        Character lastUsed = null;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (lastUsed != null && lastUsed.equals(c)) {
                continue;
            }
            if (c == '(' && left > 0) {
                helper(s.substring(0, i) + s.substring(i + 1), i, left - 1, right);
            }
            if (c == ')' && right > 0) {
                helper(s.substring(0, i) + s.substring(i + 1), i, left, right - 1);
            }
            lastUsed = c;
        }
    }

    private boolean check(String s) {
        int cnt = 0;
        for (char i : s.toCharArray()) {
            if (i == '(') {
                cnt++;
            }
            if (i == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }
        return cnt == 0;
    }

}
