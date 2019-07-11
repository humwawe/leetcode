package different.ways.to.add.parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (Integer l : left) {
                    for (Integer r : right) {
                        switch (c) {
                            case '+':
                                result.add(l + r);
                                break;
                            case '-':
                                result.add(l - r);
                                break;
                            case '*':
                                result.add(l * r);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        if (result.isEmpty()) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }
}
