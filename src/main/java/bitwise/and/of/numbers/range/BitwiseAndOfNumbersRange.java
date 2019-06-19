package bitwise.and.of.numbers.range;

/**
 * @author hum
 */
public class BitwiseAndOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        while (n > m) {
            n = n & (n - 1);
        }
        return n;
    }

}
