package find.kth.bit.in.nth.binary.string;

/**
 * @author hum
 */
public class FindKthBitInNthBinaryString {
    public char findKthBit(int n, int k) {
        int len = (1 << n) - 1;
//        return (char) (helper(len, k) + '0');
        return helper(len, k, true);
    }

    private char helper(int len, int k, boolean f) {
        if (len == 1) {
            if (f) {
                return '0';
            }
            return '1';
        }
        int t = len / 2;
        if (k == t + 1) {
            if (f) {
                return '1';
            }
            return '0';
        }
        if (k > t + 1) {
            return helper(len / 2, t - (k - t - 1) + 1, !f);
        }
        return helper(len / 2, k, f);
    }

    private int helper(int len, int k) {
        if (len == 1) {
            return 0;
        }
        if (len / 2 + 1 == k) {
            return 1;
        } else if (k > len / 2 + 1) {
            int c = helper(len / 2, len - k + 1);
            return c ^ 1;
        } else {
            return helper(len / 2, k);
        }
    }

}
