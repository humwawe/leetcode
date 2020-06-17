package brk.a.palindrome;

/**
 * @author hum
 */
public class BreakAPalindrome {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }
        int len = palindrome.length();
        boolean f = false;
        for (int i = 0; i < len / 2; i++) {
            if (palindrome.charAt(i) != 'a') {
                palindrome = palindrome.replaceFirst(String.valueOf(palindrome.charAt(i)), "a");
                f = true;
                break;
            }
        }
        if (f) {
            return palindrome;
        }
        return palindrome.substring(0, len - 1) + "b";
    }
}
