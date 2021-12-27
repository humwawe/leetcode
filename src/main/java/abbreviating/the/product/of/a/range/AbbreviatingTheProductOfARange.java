package abbreviating.the.product.of.a.range;

import java.math.BigInteger;

/**
 * @author hum
 */
public class AbbreviatingTheProductOfARange {
    public String abbreviateProduct(int left, int right) {
        long ll = 10000000000L;
        long num = 1;
        int c = 0;
        boolean ok = false;
        for (int i = left; i <= right; i++) {
            num *= i;
            while (num % 10 == 0) {
                num /= 10;
                c++;
            }
            if (num >= ll) {
                ok = true;
                num %= 10000000000L;
            }
        }
        if (!ok) {
            return num + "e" + c;
        }
        num = num % 100000;

        BigInteger pre = new BigInteger("1");
        BigInteger lim = new BigInteger("9999999999999999999999999");
        BigInteger div = new BigInteger("10");
        for (int i = left; i <= right; i++) {
            pre = pre.multiply(new BigInteger(String.valueOf(i)));
            while (pre.compareTo(lim) > 0) {
                pre = pre.divide(div);
            }
        }
        BigInteger mod = new BigInteger("100000");
        while (pre.compareTo(mod) > 0) {
            pre = pre.divide(div);
        }

        String s = String.valueOf(num);
        while (s.length() < 5) {
            s = "0" + s;
        }
        return pre.toString() + "..." + s + "e" + c;
    }
}
