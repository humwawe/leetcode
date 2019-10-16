package string.compression;

/**
 * @author hum
 */
public class StringCompression {
    public int compress(char[] chars) {
        int count = 0;
        int result = 0;
        int j = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i + 1] == chars[i]) {
                count++;
            } else {
                if (count != 0) {
                    String value = String.valueOf(count + 1);
                    result += value.length() + 1;
                    chars[j++] = chars[i];
                    for (int k = 0; k < value.length(); k++) {
                        chars[j++] = value.charAt(k);
                    }
                } else {
                    chars[j++] = chars[i];
                    result += 1;
                }
                count = 0;
            }
        }
        if (count != 0) {
            String value = String.valueOf(count + 1);
            result += value.length() + 1;
            chars[j++] = chars[chars.length - 1];
            for (int k = 0; k < value.length(); k++) {
                chars[j++] = value.charAt(k);
            }
        } else {
            chars[j++] = chars[chars.length - 1];
            result += 1;
        }
        return result;
    }
}
