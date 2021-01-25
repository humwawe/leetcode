package latest.time.by.replacing.hidden.digits;

/**
 * @author hum
 */
public class LatestTimeByReplacingHiddenDigits {
    public String maximumTime(String time) {
        char[] t = time.toCharArray();
        for (int h = 23; h >= 0; --h) {
            for (int m = 59; m >= 0; --m) {
                t[0] = (char) (h / 10 + '0');
                t[1] = (char) (h % 10 + '0');
                t[3] = (char) (m / 10 + '0');
                t[4] = (char) (m % 10 + '0');

                boolean match = true;
                for (int i = 0; i < 5; ++i) {
                    char c = time.charAt(i);
                    if (c != '?' && c != t[i]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return new String(t);
                }
            }
        }
        return "";

    }
}
