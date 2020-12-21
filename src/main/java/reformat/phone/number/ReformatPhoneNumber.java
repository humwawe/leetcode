package reformat.phone.number;

/**
 * @author hum
 */
public class ReformatPhoneNumber {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        String str = number.replace(" ", "").replace("-", "");
        int len = str.length();
        int index = 0;
        while (len - index >= 5) {
            sb.append(str, index, index + 3);
            sb.append("-");
            index += 3;
        }
        if (len - index == 4) {
            sb.append(str, index, index + 2);
            sb.append("-");
            sb.append(str, index + 2, index + 4);
        } else {
            sb.append(str, index, len);
        }
        return sb.toString();
    }
}
