package integer.to.roman;

/**
 * @author hum
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        int n = 0;
        String result = "";
        while (num > 0) {
            int unit = num % 10;
            num /= 10;
            result = numToRoman(unit, n) + result;
            n++;
        }
        return result;
    }

    private String numToRoman(int num, int n) {
        String[][] transferMap = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };
        return transferMap[n][num];
    }
}
