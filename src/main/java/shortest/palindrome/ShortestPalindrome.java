package shortest.palindrome;

/**
 * @author hum
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int len1 = 0;
        int i = 0;
        int j = s.length();
        while (i < j) {
            if (isPalindrome(s.substring(i, j))) {
                len1 = j - i;
                break;
            }
            j--;
        }
        StringBuffer tmp = new StringBuffer(s.substring(len1)).reverse();
        return tmp + s;
    }

    private boolean isPalindrome(String s) {
        int middle = s.length() / 2;
        int l, r;
        if (s.length() % 2 == 0) {
            l = middle - 1;
            r = middle;
        } else {
            l = middle - 1;
            r = middle + 1;
        }
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l--) != s.charAt(r++)) {
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome2(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
