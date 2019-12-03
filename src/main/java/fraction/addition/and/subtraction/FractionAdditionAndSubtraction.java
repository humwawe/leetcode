package fraction.addition.and.subtraction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class FractionAdditionAndSubtraction {
    public String fractionAddition(String expression) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '-' && i != 0) {
                stringBuilder.append('+');
            }
            stringBuilder.append(c);
        }
        String[] strings = stringBuilder.toString().split("\\+");
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (String string : strings) {
            int index = string.indexOf("/");
            list.add(Integer.valueOf(string.substring(0, index)));
            list2.add(Integer.valueOf(string.substring(index + 1)));
        }
        if (list.size() == 1) {
            return expression;
        }
        int tmp = helper(list2);
        int x = 0;
        for (int i = 0; i < list.size(); i++) {
            x += list.get(i) * tmp / list2.get(i);
        }
        int tmp2 = gcd(Math.abs(x), tmp);
        return String.valueOf(x / tmp2) + "/" + String.valueOf(tmp / tmp2);
    }

    private int helper(List<Integer> list2) {
        int ans = 1;
        for (Integer m : list2) {
            int temp = gcd(ans, m);
            ans = ans / temp * m;
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
