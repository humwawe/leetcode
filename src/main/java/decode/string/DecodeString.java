package decode.string;


import java.util.Stack;

/**
 * @author hum
 */
public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        StringBuilder result = new StringBuilder();
        char[] charArray = s.toCharArray();

        int num = 0;
        for (char c : charArray) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else {
                if (num > 0) {
                    stack1.push(num);
                    num = 0;
                }
                if (c != ']') {
                    stack2.push(c);
                }
            }
            if (c == ']') {
                int count = stack1.pop();
                StringBuilder tmp = new StringBuilder();
                while (stack2.peek() != '[') {
                    tmp.insert(0, stack2.pop());
                }
                stack2.pop();
                StringBuilder t = new StringBuilder();
                while (count-- > 0) {
                    t.append(tmp);
                }
                for (int i = 0; i < t.length(); i++) {
                    stack2.push(t.charAt(i));
                }

            }
        }
        while (!stack2.isEmpty()) {
            result.append(stack2.pop());
        }
        return result.reverse().toString();
    }
}
