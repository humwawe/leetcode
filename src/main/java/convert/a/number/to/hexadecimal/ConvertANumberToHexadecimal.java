package convert.a.number.to.hexadecimal;

/**
 * @author hum
 */
public class ConvertANumberToHexadecimal {
    public String toHex(int num) {
        char[] hex = "0123456789abcdef".toCharArray();
        StringBuilder result = new StringBuilder();
        while (num != 0) {
            int end = num & 15;
            result.insert(0, hex[end]);
            num >>>= 4;
        }
        if (result.length() == 0) {
            result = new StringBuilder("0");
        }

        return result.toString();
    }
}
