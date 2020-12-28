package maximum.binary.string.after.change;

/**
 * @author hum
 */
public class MaximumBinaryStringAfterChange {
    public String maximumBinaryString(String binary) {
        int[] count = new int[2];
        for (char c : binary.toCharArray()) {
            count[c - '0']++;
        }
        if (count[0] <= 1) {
            return binary;
        }
        int c = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                c++;
            } else {
                break;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < c; i++) {
            res.append("1");
        }
        for (int i = 0; i < count[0] - 1; i++) {
            res.append("1");
        }
        res.append("0");
        for (int i = 0; i < count[1] - c; i++) {
            res.append("1");
        }
        return res.toString();
    }
}
