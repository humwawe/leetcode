package convert.to.base.minus.two;

/**
 * @author hum
 */
public class ConvertToBaseM2 {
    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        boolean f = true;
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            if (n % 2 == 1) {
                stringBuilder.insert(0, '1');
                if (f) {
                    n--;
                } else {
                    n++;
                }
            } else {
                stringBuilder.insert(0, '0');
            }
            n /= 2;
            f = !f;
        }
        return stringBuilder.toString();
    }
}
