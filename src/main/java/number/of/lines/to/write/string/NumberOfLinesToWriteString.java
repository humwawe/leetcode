package number.of.lines.to.write.string;

/**
 * @author hum
 */
public class NumberOfLinesToWriteString {
    public int[] numberOfLines(int[] widths, String s) {
        int res = 0;
        int[] result = new int[2];
        result[0] = 1;
        for (char c : s.toCharArray()) {
            res += widths[c - 'a'];
            if (res > 100) {
                res = widths[c - 'a'];
                result[0]++;
            }
        }
        result[1] = res;
        return result;
    }
}
