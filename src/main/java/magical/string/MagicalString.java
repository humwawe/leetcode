package magical.string;

/**
 * @author hum
 */
public class MagicalString {
    public int magicalString(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(122);
        int[] res = {0, 1, 1, 1};
        if (n <= 3) {
            return res[n];
        }
        int len = 2;
        int index = 2;
        int result = 0;
        while (len < n) {
            char prev = stringBuilder.charAt(len);
            char count = stringBuilder.charAt(index++);
            if (prev == '1') {
                if (count == '1') {
                    stringBuilder.append(2);
                    len += 1;
                } else {
                    stringBuilder.append(2);
                    stringBuilder.append(2);
                    len += 2;
                }
            } else {
                if (count == '1') {
                    stringBuilder.append(1);
                    len += 1;
                } else {
                    stringBuilder.append(1);
                    stringBuilder.append(1);
                    len += 2;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (stringBuilder.charAt(i) == '1') {
                result++;
            }
        }
        return result;
    }
}
