package maximum.six.nine.number;

/**
 * @author hum
 */
public class Maximum69Number {
    public int maximum69Number(int num) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(num));
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '6') {
                stringBuilder.setCharAt(i, '9');
                break;
            }
        }

        return Integer.valueOf(stringBuilder.toString());
    }
}
