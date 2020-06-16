package convert.integer.to.the.sum.of.two.no.zero.integers;

/**
 * @author hum
 */
public class ConvertIntegerToTheSumOfTwoNoZeroIntegers {
    public int[] getNoZeroIntegers(int n) {
        int[] result = new int[2];
        for (int i = 1; i < n / 2 + 1; i++) {
            if (!String.valueOf(i).contains("0") && !String.valueOf(n - i).contains("0")) {
                result[0] = i;
                result[1] = n - i;
            }
        }
        return result;
    }
}
