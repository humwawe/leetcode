package split.two.strings.to.make.palindrome;

/**
 * @author hum
 */
public class SplitTwoStringsToMakePalindrome {
    int len;

    public boolean checkPalindromeFormation(String a, String b) {
        len = a.length();
        return helper(a, b) || helper(b, a);
    }

    private boolean isH(String a, int i, int j) {
        while (i < j) {
            if (a.charAt(i) != a.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean helper(String a, String b) {
        int i = 0;
        int j = len - 1;
        while (i < j) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j--;
            } else {
                break;
            }
        }
        return isH(a, i, j) || isH(b, i, j);
    }
}
