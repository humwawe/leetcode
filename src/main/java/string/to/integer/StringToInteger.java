package string.to.integer;

/**
 * @author hum
 */
public class StringToInteger {
    public int myAtoi(String str) {
        long result = 0;
        int index = 0;
        int length = str.length();
        boolean sign = true;
        if (length == 0) {
            return 0;
        }
        while (str.charAt(index) == ' ' && index < length) {
            index++;
        }
        if (str.charAt(index) == '-' && index < length) {
            sign = false;
            index++;
        } else if (str.charAt(index) == '+') {
            index++;
        }
        for (int i = index; i < length; i++) {
            char temp = str.charAt(i);
            if (temp <= '9' && temp >= '0') {
                result = sign == false ? result * 10 - (temp - '0') : result * 10 + (temp - '0');
                if (result > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (result < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }
        return (int) result;
    }
}
