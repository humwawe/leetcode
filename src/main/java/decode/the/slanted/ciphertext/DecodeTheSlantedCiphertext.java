package decode.the.slanted.ciphertext;

/**
 * @author hum
 */
public class DecodeTheSlantedCiphertext {
    public String decodeCiphertext(String encodedText, int rows) {
        int len = encodedText.length();
        int col = len / rows;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < col; i++) {
            int x = 0;
            int y = i;
            while (x < rows && y < col) {
                int idx = x * col + y;
                stringBuilder.append(encodedText.charAt(idx));
                x++;
                y++;
            }
        }
        for (int i = stringBuilder.length() - 1; i >= 0; i--) {
            if (stringBuilder.charAt(i) == ' ') {
                stringBuilder.deleteCharAt(i);
            } else {
                return stringBuilder.toString();
            }
        }
        return "";
    }
}
