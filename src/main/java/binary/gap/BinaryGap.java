package binary.gap;

/**
 * @author hum
 */
public class BinaryGap {
    public int binaryGap(int n) {
        String s = Integer.toBinaryString(n);
        int start = 0;
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                result = Math.max(result, i - start);
                start = i;
            }
        }
        return result;
    }
}
