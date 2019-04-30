package valid.parentheses;

import java.util.Stack;

/**
 * @author hum
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> temp = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    temp.push(')');
                    break;
                case '{':
                    temp.push('}');
                    break;
                case '[':
                    temp.push(']');
                    break;
                case ')':
                case '}':
                case ']':
                    if (temp.isEmpty() || c != temp.pop()) {
                        return false;
                    }
                    break;
                default:
                    return false;

            }

        }
        return temp.isEmpty();
    }

}
