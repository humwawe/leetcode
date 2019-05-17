package add.binary;

/**
 * @author hum
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder result = new StringBuilder();
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;
        while (lenA >= 0 && lenB >= 0) {
            int tmp = a.charAt(lenA--) - '0' + b.charAt(lenB--) - '0' + carry;
            result.insert(0, tmp % 2);
            carry = tmp / 2;
        }
        while (lenA >= 0) {
            int tmp = a.charAt(lenA--) - '0' + carry;
            result.insert(0, tmp % 2);
            carry = tmp / 2;
        }
        while (lenB >= 0) {
            int tmp = b.charAt(lenB--) - '0' + carry;
            result.insert(0, tmp % 2);
            carry = tmp / 2;
        }
        if (carry == 1) {
            result.insert(0, 1);
        }
        return result.toString();
    }
}
