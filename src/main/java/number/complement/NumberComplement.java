package number.complement;

/**
 * @author hum
 */
public class NumberComplement {
    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '0') {
                stringBuilder.append(1);
            } else {
                stringBuilder.append(0);
            }
        }
        return Integer.valueOf(stringBuilder.toString(), 2);
    }
}
