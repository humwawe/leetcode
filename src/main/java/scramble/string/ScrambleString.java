package scramble.string;

/**
 * @author hum
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        int len = s1.length();
        int[] count = new int[26];
        for (int i = 0; i < len; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int item : count) {
            if (item != 0) {
                return false;
            }
        }
        for (int i = 1; i < s1.length(); i++) {
            String leftS1 = s1.substring(0, i), rightS1 = s1.substring(i);
            String leftS2 = s2.substring(0, i), rightS2 = s2.substring(i);
            if (isScramble(leftS1, leftS2) && isScramble(rightS1, rightS2)) {
                return true;
            }
            leftS2 = s2.substring(s1.length() - i);
            rightS2 = s2.substring(0, s1.length() - i);
            if (isScramble(leftS1, leftS2) && isScramble(rightS1, rightS2)) {
                return true;
            }
        }
        return false;
    }
}
