package reverse.bits;

/**
 * @author hum
 */
public class ReverseBits {
    public int reverseBits(int n) {
        long value = 1L << 32 | n;
        String str = Long.toBinaryString(value);
        StringBuilder tmp = new StringBuilder(str);
        String revStr = tmp.reverse().substring(0, 32);
        return Integer.parseUnsignedInt(revStr, 2);
    }

    public int helper(int n) {
        int a = 0;
        for (int i = 0; i <= 31; i++) {
            a = a + ((1 & (n >> i)) << (31 - i));
        }
        return a;
    }
}
