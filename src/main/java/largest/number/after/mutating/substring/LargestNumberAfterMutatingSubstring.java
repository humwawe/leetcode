package largest.number.after.mutating.substring;

/**
 * @author hum
 */
public class LargestNumberAfterMutatingSubstring {
    public String maximumNumber(String num, int[] change) {
        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - '0';
            if (change[index] > index) {
                while (i < chars.length && change[chars[i] - '0'] >= chars[i] - '0') {
                    chars[i] = (char) ('0' + change[chars[i] - '0']);
                    i++;
                }
                break;
            }
        }
        return new String(chars);
    }
}
