package form.largest.integer.with.digits.that.add.up.to.target;

/**
 * @author hum
 */
public class FormLargestIntegerWithDigitsThatAddUpToTarget {
    String[] memo = new String[5005];

    public String largestNumber(int[] cost, int target) {
        return helper(cost, target);
    }

    private String helper(int[] cost, int target) {
        if (target == 0) {
            return "";
        }
        if (target < 0) {
            return "0";
        }
        if (memo[target] != null) {
            return memo[target];
        }
        String res = "0";
        for (int i = 0; i < 9; i++) {
            String next = helper(cost, target - cost[i]);
            if (!next.equals("0")) {
                if (res.length() <= next.length() + 1) {
                    res = (i + 1) + next;
                }
            }
        }

        return memo[target] = res;
    }
}
