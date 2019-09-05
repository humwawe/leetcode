package sum.of.two.integers;

/**
 * @author hum
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
