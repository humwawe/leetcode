package repeated.string.match;

/**
 * @author hum
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {
        int i = 0, j = 0;
        int lenA = a.length();
        int lenB = b.length();
        while (i < lenA) {
            int index = i;
            int result = 1;
            while (j < lenB) {
                if (a.charAt(index) == b.charAt(j)) {
                    index++;
                    j++;
                    if (index == lenA) {
                        index = 0;
                        result++;
                    }
                } else {
                    i++;
                    j = 0;
                    break;
                }
            }
            if (j == lenB) {
                if (index == 0) {
                    return --result;
                }
                return result;
            }
        }
        return -1;
    }
}
