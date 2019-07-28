package additive.number;

/**
 * @author hum
 */
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        if (len < 3) {
            return false;
        }
        for (int i = 1; i < (len - 1) / 2; i++) {
            if (i > 1 && num.charAt(0) == '0') {
                break;
            }
            for (int j = i + 1; len - j >= i && len - j >= j - i; j++) {
                if (j > i + 1 && num.charAt(i) == '0') {
                    break;
                }
                long num1 = Long.parseLong(num.substring(0, i));
                long num2 = Long.parseLong(num.substring(i, j));
                if (helper(num.substring(j), num1, num2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(String remain, long num1, long num2) {
        if (remain.isEmpty()) {
            return true;
        }
        long sum = num1 + num2;
        String temp = String.valueOf(sum);
        if (!remain.startsWith(temp)) {
            return false;
        }
        return helper(remain.substring(temp.length()), num2, sum);
    }
}
