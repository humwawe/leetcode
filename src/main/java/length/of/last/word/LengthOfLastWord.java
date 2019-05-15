package length.of.last.word;

/**
 * @author hum
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }
        s = s.trim();
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                result++;
            } else {
                break;
            }
        }
        return result;
    }
}
