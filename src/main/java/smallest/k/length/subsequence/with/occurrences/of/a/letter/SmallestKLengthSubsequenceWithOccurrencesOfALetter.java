package smallest.k.length.subsequence.with.occurrences.of.a.letter;

import java.util.Stack;

/**
 * @author hum
 */
public class SmallestKLengthSubsequenceWithOccurrencesOfALetter {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        int inStack = 0;
        int suf = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == letter) {
                suf++;
            }
        }
        int toErase = len - k;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            while (toErase > 0 && !stack.isEmpty() && c < stack.peek()) {
                if (stack.peek() == letter) {
                    // 不能删
                    if (repetition >= inStack + suf) {
                        break;
                    }
                    inStack--;
                }
                stack.pop();
                toErase--;
            }
            if (c == letter) {
                inStack++;
                suf--;
            }
            stack.push(c);
        }

        while (stack.size() > k) {
            if (stack.pop() == letter) {
                inStack--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (inStack < repetition && c != letter) {
                sb.insert(0, letter);
                inStack++;
            } else {
                sb.insert(0, c);
            }
        }
        return sb.toString();
    }
}
