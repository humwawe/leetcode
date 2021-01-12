package maximum.score.from.removing.substrings;

import java.util.Stack;

/**
 * @author hum
 */
public class MaximumScoreFromRemovingSubstrings {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> stack = new Stack<>();
        int res = 0;
        if (x >= y) {
            for (char c : s.toCharArray()) {
                if (c == 'b') {
                    if (!stack.isEmpty() && stack.peek() == 'a') {
                        stack.pop();
                        res += x;
                    } else {
                        stack.push(c);
                    }
                } else {
                    stack.push(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Character character : stack) {
                sb.append(character);
            }
            stack.clear();
            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                if (c == 'a') {
                    if (!stack.isEmpty() && stack.peek() == 'b') {
                        stack.pop();
                        res += y;
                    } else {
                        stack.push(c);
                    }
                } else {
                    stack.push(c);
                }
            }
        } else {
            for (char c : s.toCharArray()) {
                if (c == 'a') {
                    if (!stack.isEmpty() && stack.peek() == 'b') {
                        stack.pop();
                        res += y;
                    } else {
                        stack.push(c);
                    }
                } else {
                    stack.push(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Character character : stack) {
                sb.append(character);
            }
            stack.clear();
            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                if (c == 'b') {
                    if (!stack.isEmpty() && stack.peek() == 'a') {
                        stack.pop();
                        res += x;
                    } else {
                        stack.push(c);
                    }
                } else {
                    stack.push(c);
                }
            }
        }
        return res;
    }
}
