package remove.k.digits;

/**
 * @author hum
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        while (k > 0) {
            int i = 1;
            boolean flag = false;
            for (; i < num.length(); i++) {
                if (num.charAt(i) < num.charAt(i - 1)) {
                    num = num.substring(0, i - 1) + num.substring(i);
                    k--;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                k--;
                num = num.substring(0, num.length() - 1);
            }
        }
        num = num.replaceAll("^(0+)", "");
        return num.length() == 0 ? "0" : num;
    }
}
