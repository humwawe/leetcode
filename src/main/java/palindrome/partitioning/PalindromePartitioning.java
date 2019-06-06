package palindrome.partitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class PalindromePartitioning {
    List<List<String>> results = new ArrayList<>();

    public List<List<String>> partition(String s) {
        helper(s, new ArrayList<>());
        return results;
    }

    private void helper(String s, List<String> result) {
        if (s.isEmpty()) {
            results.add(new ArrayList<>(result));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String tmp = s.substring(0, i);
            if (isPalindrome(tmp)) {
                result.add(tmp);
                helper(s.substring(i), result);
                result.remove(result.size() - 1);
            }

        }
    }

    boolean isPalindrome(String s) {
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
