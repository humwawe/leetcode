package remove.all.adjacent.duplicates.in.string;

import java.util.Stack;

/**
 * @author hum
 */
public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            boolean f = false;
            while (!stack.isEmpty() && stack.peek() == c) {
                f = true;
                stack.pop();
            }
            if (f) {
                continue;
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        for (Character character : stack) {
            System.out.println(character);
        }
        return sb.toString();

    }
}
