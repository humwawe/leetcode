package minimum.remove.to.make.valid.parentheses;

/**
 * @author hum
 */
public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (count == 0) {
                    continue;
                } else {
                    count--;
                }
            }
            if (c == '(') {
                count++;
            }
            stringBuilder.append(c);
        }
        for (int i = stringBuilder.length() - 1; i >= 0 && count > 0; i--) {
            if (stringBuilder.charAt(i) == '(') {
                stringBuilder.deleteCharAt(i);
                count--;
            }
        }
        return stringBuilder.toString();
    }
}
