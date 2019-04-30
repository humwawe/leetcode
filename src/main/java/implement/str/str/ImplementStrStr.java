package implement.str.str;

/**
 * @author hum
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = i;
            int index = 0;
            while (j < haystack.length() && index < needle.length() && haystack.charAt(j) == needle.charAt(index)) {
                j++;
                index++;
            }
            if (index == needle.length()) {
                return j - index;
            }
        }
        return -1;
    }

}
