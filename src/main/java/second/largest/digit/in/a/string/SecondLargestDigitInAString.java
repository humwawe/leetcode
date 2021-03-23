package second.largest.digit.in.a.string;

/**
 * @author hum
 */
public class SecondLargestDigitInAString {
    public int secondHighest(String s) {
        char[] chars = s.toCharArray();
        int max1 = -1, max2 = -1;
        for (char c : chars) {
            if (Character.isLetter(c)) {
                continue;
            }
            int num = c - '0';
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num < max1 && num > max2) {
                max2 = num;
            }
        }
        return max2;
    }
}
