package number.of.good.ways.to.split.a.string;

/**
 * @author hum
 */
public class NumberOfGoodWaysToSplitAString {
    public int numSplits(String s) {
        int len = s.length();
        int[] cnt = new int[26];
        int count = 0;
        for (int i = 0; i < len; i++) {
            int idx = s.charAt(i) - 'a';
            cnt[idx]++;
            if (cnt[idx] == 1) {
                count++;
            }
        }
        int[] tmp = new int[26];
        int c = 0;
        int result = 0;
        for (int i = 0; i < len; i++) {
            int idx = s.charAt(i) - 'a';
            tmp[idx]++;
            if (tmp[idx] == 1) {
                c++;
            }
            if (tmp[idx] == cnt[idx]) {
                count--;
            }
            if (c == count) {
                result++;
            }
        }
        return result;
    }
}
