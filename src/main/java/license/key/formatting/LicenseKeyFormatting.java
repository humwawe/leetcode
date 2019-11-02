package license.key.formatting;

/**
 * @author hum
 */
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        s = s.replaceAll("-", "").toUpperCase();
        if (s.length() == 0) {
            return "";
        }
        int len = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        int tmp = len % k;
        int i;
        for (i = 0; i < tmp; i++) {
            stringBuilder.append(s.charAt(i));
        }
        while (i < len) {
            stringBuilder.append('-');
            int count = 0;
            while (count < k) {
                stringBuilder.append(s.charAt(i));
                count++;
                i++;
            }

        }
        if (tmp == 0) {
            return stringBuilder.substring(1);
        }
        return stringBuilder.toString();
    }
}
