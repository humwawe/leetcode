package number.of.one.bits;

/**
 * @author hum
 */
public class NumberOfOneBits {
    public int hammingWeight(int n) {
        String str = Integer.toBinaryString(n);
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                result++;
            }
        }
        return result;
    }
}
