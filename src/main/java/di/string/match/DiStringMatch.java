package di.string.match;

/**
 * @author hum
 */
public class DiStringMatch {
    public int[] diStringMatch(String s) {
        int len = s.length();
        int i = 0;
        int j = len;
        int[] result = new int[len + 1];
        for (int k = 0; k < len; k++) {
            if (s.charAt(k) == 'I') {
                result[k] = i++;
            } else {
                result[k] = len--;
            }
        }
        result[len] = i;
        return result;
    }
}
