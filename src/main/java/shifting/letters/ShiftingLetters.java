package shifting.letters;

/**
 * @author hum
 */
public class ShiftingLetters {
    public String shiftingLetters(String s, int[] shifts) {
        int len = shifts.length;
        shifts[len - 1] %= 26;
        for (int i = len - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stringBuilder.append((char) ((c - 'a' + shifts[i]) % 26 + 'a'));
        }
        return stringBuilder.toString();
    }

}
