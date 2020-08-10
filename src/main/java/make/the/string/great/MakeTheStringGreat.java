package make.the.string.great;

import java.util.Stack;

/**
 * @author hum
 */
public class MakeTheStringGreat {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && helper(c, stack.peek())) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : stack) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }

    private boolean helper(char a, char b) {
        if (Character.toLowerCase(a) != Character.toLowerCase(b)) {
            return false;
        }
        if (Character.isLowerCase(a) && Character.isUpperCase(b)) {
            return true;
        }
        return Character.isLowerCase(b) && Character.isUpperCase(a);
    }
}
