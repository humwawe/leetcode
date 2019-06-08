package evaluate.reverse.polish.notation;

import java.util.Stack;

/**
 * @author hum
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            try {
                stack.push(Integer.valueOf(token));
            } catch (NumberFormatException e) {
                int second = stack.pop();
                int first = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(first + second);
                        break;
                    case "-":
                        stack.push(first - second);
                        break;
                    case "/":
                        stack.push(first / second);
                        break;
                    case "*":
                        stack.push(first * second);
                        break;
                    default:
                        break;
                }
            }
        }
        return stack.pop();
    }
}
