package masking.personal.information;

/**
 * @author hum
 */
public class MaskingPersonalInformation {
    public String maskPII(String s) {
        int atIndex = s.indexOf('@');
        if (atIndex >= 0) {
            return (s.substring(0, 1) + "*****" + s.substring(atIndex - 1)).toLowerCase();
        } else {
            String digits = s.replaceAll("\\D+", "");
            String local = "***-***-" + digits.substring(digits.length() - 4);
            if (digits.length() == 10) {
                return local;
            }
            String ans = "+";
            for (int i = 0; i < digits.length() - 10; ++i) {
                ans += "*";
            }
            return ans + "-" + local;
        }
    }
}
