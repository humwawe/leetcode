package sum.of.square.numbers;

/**
 * @author hum
 */
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        for (int a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }
}
