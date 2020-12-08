package multiply.strings;

/**
 * @author hum
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String result = "0";
        for (int i = 0; i < num2.length(); i++) {
            String tmp = helperMul(num1, num2.charAt(num2.length() - 1 - i), i);
            System.out.println(tmp);
            result = helperAdd(result, tmp);
        }
        return result;
    }

    private String helperAdd(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        String minNum, maxNum;

        if (num1.length() > num2.length()) {
            minNum = num2;
            maxNum = num1;
        } else {
            minNum = num1;
            maxNum = num2;
        }
        int digit = 0;
        for (int i = 0; i < minNum.length(); i++) {
            int tmp = minNum.charAt(minNum.length() - 1 - i) - '0' + maxNum.charAt(maxNum.length() - 1 - i) - '0' + digit;
            int unit = tmp % 10;
            digit = tmp / 10;
            result.insert(0, String.valueOf(unit));
        }

        for (int i = minNum.length(); i < maxNum.length(); i++) {
            int tmp = maxNum.charAt(maxNum.length() - 1 - i) - '0' + digit;
            int unit = tmp % 10;
            digit = tmp / 10;
            result.insert(0, String.valueOf(unit));
        }
        if (digit != 0) {
            result.insert(0, String.valueOf(digit));
        }
        return result.toString();
    }

    private String helperMul(String num1, char num2, int index) {
        StringBuilder result = new StringBuilder();
        int digit = 0;
        int multiplier = num2 - '0';
        for (int i = 0; i < num1.length(); i++) {
            int tmp = (num1.charAt(num1.length() - 1 - i) - '0') * multiplier + digit;
            int unit = tmp % 10;
            digit = tmp / 10;
            result.insert(0, String.valueOf(unit));
        }
        while (index-- > 0) {
            result.append("0");
        }
        if (digit != 0) {
            result.insert(0, String.valueOf(digit));
        }
        return result.toString();
    }
}
