package maximum.swap;

/**
 * @author hum
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        StringBuilder s = new StringBuilder(String.valueOf(num));
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char tmp = s.charAt(i);
            int max = tmp;
            int index = i;
            for (int j = i + 1; j < len; j++) {
                if (i == 0 && s.charAt(j) == 0) {
                    continue;
                }
                if (s.charAt(j) >= max) {
                    max = s.charAt(j);
                    index = j;
                }
            }
            if (max != tmp) {
                StringBuilder t = new StringBuilder(s);
                t.setCharAt(i, (char) max);
                t.setCharAt(index, tmp);
                return Integer.valueOf(t.toString());
            }
        }
        return num;
    }
}
