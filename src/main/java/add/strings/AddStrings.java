package add.strings;

/**
 * @author hum
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int tmp = num1.charAt(i) - '0' + num2.charAt(j) - '0' + carry;
            stringBuilder.insert(0, tmp % 10);
            carry = tmp / 10;
            i--;
            j--;
        }
        carry = getCarry(num1, carry, i, stringBuilder);
        carry = getCarry(num2, carry, j, stringBuilder);
        if (carry > 0) {
            stringBuilder.insert(0, carry);
        }
        return stringBuilder.toString();

    }

    private int getCarry(String num1, int carry, int i, StringBuilder stringBuilder) {
        while (i >= 0) {
            int tmp = num1.charAt(i) - '0' + carry;
            stringBuilder.insert(0, tmp % 10);
            carry = tmp / 10;
            i--;
        }
        return carry;
    }
}
