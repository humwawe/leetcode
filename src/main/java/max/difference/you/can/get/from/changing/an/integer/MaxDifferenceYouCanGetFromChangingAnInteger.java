package max.difference.you.can.get.from.changing.an.integer;

/**
 * @author hum
 */
public class MaxDifferenceYouCanGetFromChangingAnInteger {
    public int maxDiff(int num) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(num));
        int i = 0;
        while (i < stringBuilder.length()) {
            if (stringBuilder.charAt(i) != '9') {
                char c = stringBuilder.charAt(i);
                stringBuilder.setCharAt(i, '9');
                while (i < stringBuilder.length()) {
                    if (stringBuilder.charAt(i) == c) {
                        stringBuilder.setCharAt(i, '9');
                    }
                    i++;
                }
            }
            i++;
        }
        int a = Integer.valueOf(stringBuilder.toString());
        stringBuilder = new StringBuilder(String.valueOf(num));
        if (stringBuilder.charAt(0) != '1') {
            char c = stringBuilder.charAt(0);
            int b = Integer.valueOf(stringBuilder.toString().replaceAll(String.valueOf(c), "1"));
            return a - b;
        }
        i = 1;
        while (i < stringBuilder.length()) {
            if (stringBuilder.charAt(i) == '0' || stringBuilder.charAt(i) == '1') {
                i++;
            } else {
                char c = stringBuilder.charAt(i);
                stringBuilder.setCharAt(i, '0');
                while (i < stringBuilder.length()) {
                    if (stringBuilder.charAt(i) == c) {
                        stringBuilder.setCharAt(i, '0');
                    }
                    i++;
                }
            }
        }
        int b = Integer.valueOf(stringBuilder.toString());
        return a - b;
    }
}
