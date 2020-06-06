package remove.all.adjacent.duplicates.in.string.II;

import java.util.Stack;

/**
 * @author hum
 */
public class RemoveAllAdjacentDuplicatesInStringII {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty() || s.charAt(i) != stack.peek().ch) {
                stack.push(new Pair(s.charAt(i), 1));
            } else {
                if (++stack.peek().count == k) {
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Pair p : stack) {
            for (int j = 0; j < p.count; j++) {
                sb.append(p.ch);
            }
        }
        return sb.toString();
    }

    class Pair {
        char ch;
        int count;

        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

}
