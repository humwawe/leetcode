package reverse.substrings.between.each.pair.of.parentheses;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author hum
 */
public class ReverseSubstringsBetweenEachPairOfParentheses {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        LinkedList<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    list.addLast(stack.pop());
                }
                stack.pop();
                while (list.size() > 0) {
                    stack.push(list.removeFirst());
                }
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
}
