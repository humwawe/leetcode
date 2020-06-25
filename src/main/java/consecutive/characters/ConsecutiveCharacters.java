package consecutive.characters;

/**
 * @author hum
 */
public class ConsecutiveCharacters {
    public int maxPower(String s) {
        int start = -1;
        char prev = '#';
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != prev) {
                result = Math.max(result, i - start);
                start = i;
                prev = s.charAt(i);
            }
        }
        result = Math.max(result, s.length() - 1 - start);
        return result;
    }
}
