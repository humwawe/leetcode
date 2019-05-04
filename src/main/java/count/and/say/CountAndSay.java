package count.and.say;

/**
 * @author hum
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String str = countAndSay(n - 1);
        int count = 1, num = str.charAt(0) - '0';
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            int cur = str.charAt(i) - '0';
            if (cur == num) {
                count++;
            } else {
                result.append(String.valueOf(count)).append(String.valueOf(num));
                count = 1;
                num = cur;
            }
        }
        result.append(String.valueOf(count)).append(String.valueOf(num));
        return result.toString();
    }
}
