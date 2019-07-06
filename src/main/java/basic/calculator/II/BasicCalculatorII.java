package basic.calculator.II;

import java.util.Stack;

/**
 * @author hum
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        s = s.replaceAll(" ", "");
        Stack<Character> stack = new Stack<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                stringBuilder.append(c);
            } else if (c == '+' || c == '-') {
                stringBuilder.append("#");
                while (!stack.isEmpty()) {
                    stringBuilder.append(stack.pop());
                    stringBuilder.append("#");
                }
                stack.push(c);
            } else {
                stringBuilder.append("#");
                if (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                    stringBuilder.append(stack.pop());
                    stringBuilder.append("#");
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            stringBuilder.append("#");
            stringBuilder.append(stack.pop());
        }
        System.out.println(stringBuilder);
        if (stringBuilder.indexOf("#") == -1) {
            return Integer.valueOf(String.valueOf(stringBuilder));
        }

        Stack<Integer> numStack = new Stack<>();
        int start = 0;
        while (true) {
            int index = stringBuilder.indexOf("#", start);
            if (index != -1) {
                String subString = stringBuilder.substring(start, index);
                start = index + 1;
                if ("+".equals(subString)) {
                    int num1 = numStack.pop();
                    int num2 = numStack.pop();
                    numStack.push(num2 + num1);
                } else if ("-".equals(subString)) {
                    int num1 = numStack.pop();
                    int num2 = numStack.pop();
                    numStack.push(num2 - num1);
                } else if ("*".equals(subString)) {
                    int num1 = numStack.pop();
                    int num2 = numStack.pop();
                    numStack.push(num2 * num1);
                } else if ("/".equals(subString)) {
                    int num1 = numStack.pop();
                    int num2 = numStack.pop();
                    numStack.push(num2 / num1);
                } else {
                    numStack.push(Integer.valueOf(subString));
                }
            } else {
                break;
            }
        }
        String subString = stringBuilder.substring(start);
        if ("+".equals(subString)) {
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            numStack.push(num2 + num1);
        } else if ("-".equals(subString)) {
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            numStack.push(num2 - num1);
        } else if ("*".equals(subString)) {
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            numStack.push(num2 * num1);
        } else if ("/".equals(subString)) {
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            numStack.push(num2 / num1);
        }
        return numStack.pop();
    }
}
