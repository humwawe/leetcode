package minimum.number.of.swaps.to.make.the.binary.string.alternating;

/**
 * @author hum
 */
public class MinimumNumberOfSwapsToMakeTheBinaryStringAlternating {
    int len;

    public int minSwaps(String s) {
        len = s.length();
        int[] cnt = new int[2];
        for (char c : s.toCharArray()) {
            cnt[c - '0']++;
        }
        if (Math.abs(cnt[1] - cnt[0]) > 1) {
            return -1;
        }
        int res = (int) 1e8;
        if (cnt[1] > cnt[0]) {
            res = Math.min(res, helper(s, 1));
        } else if (cnt[1] < cnt[0]) {
            res = Math.min(res, helper(s, 0));
        } else {
            res = Math.min(res, helper(s, 0));
            res = Math.min(res, helper(s, 1));
        }
        return res;
    }

    private int helper(String s, int start) {
        int diff = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) - '0' != start) {
                diff++;
            }
            start = 1 - start;
        }
        return diff / 2;
    }
}
