package remove.outermost.parentheses;

/**
 * @author hum
 */
public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
                if (count > 1) {
                    stringBuilder.append(c);
                }
            } else {
                count--;
                if (count > 0) {
                    stringBuilder.append(c);
                }
            }
        }
        return stringBuilder.toString();
    }
}
