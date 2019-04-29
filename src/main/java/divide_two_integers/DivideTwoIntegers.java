package divide_two_integers;

/**
 * @author hum
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == divisor) {
            return 1;
        }
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }

        boolean flag = (dividend ^ divisor) < 0;
        int absDividend = Math.abs(dividend);
        boolean lessOne = false;
        if (absDividend == Integer.MIN_VALUE) {
            absDividend = Integer.MAX_VALUE;
            lessOne = true;
        }

        int absDivisor = Math.abs(divisor);


        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if (absDividend >> i >= absDivisor) {
                result += 1 << i;
                absDividend -= absDivisor << i;
            }
        }
        if (lessOne && absDividend + 1 == absDivisor) {
            result += 1;
        }
        return flag ? -result : result;
    }

}
