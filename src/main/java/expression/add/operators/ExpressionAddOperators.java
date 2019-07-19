package expression.add.operators;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        helper(result, num, "", 0, 0, 0, target);
        return result;
    }

    private void helper(List<String> result, String num, String path, int pos, long sum, long lastNum, int target) {
        int len = num.length();
        if (pos == len && sum == target) {
            result.add(path);
        }
        if (pos >= len) {
            return;
        }
        for (int i = pos; i < len; i++) {
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }
            long curNum = Long.parseLong(num.substring(pos, i + 1));

            if (pos == 0) {
                helper(result, num, path + "" + curNum, i + 1, curNum, curNum, target);
            } else {
                helper(result, num, path + "+" + curNum, i + 1, sum + curNum, curNum, target);
                helper(result, num, path + "-" + curNum, i + 1, sum - curNum, -curNum, target);
                helper(result, num, path + "*" + curNum, i + 1, sum - lastNum + lastNum * curNum, lastNum * curNum, target);
            }

        }
    }

}
