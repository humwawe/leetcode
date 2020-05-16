package smallest.subsequence.of.distinct.characters;

import java.util.Stack;

/**
 * @author hum
 */
public class SmallestSubsequenceOfDistinctCharacters {
    public String smallestSubsequence(String text) {
        Stack<Integer> stack = new Stack<>();
        int[] m = new int[26];
        boolean[] vis = new boolean[26];
        for (char c : text.toCharArray()) {
            m[c - 'a']++;
        }
        for (char c : text.toCharArray()) {
            int i = c - 'a';
            m[i]--;
            if (vis[i]) {
                continue;
            }
            while (!stack.isEmpty() && i < stack.peek() && m[stack.peek()] > 0) {
                vis[stack.peek()] = false;
                stack.pop();

            }
            stack.push(i);
            vis[i] = true;
        }
        System.out.println(stack);
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer a : stack) {
            stringBuilder.append((char) ('a' + a));
        }
        return stringBuilder.toString();
    }

}
