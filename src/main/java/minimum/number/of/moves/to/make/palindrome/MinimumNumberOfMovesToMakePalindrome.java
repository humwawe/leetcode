package minimum.number.of.moves.to.make.palindrome;

/**
 * @author hum
 */
public class MinimumNumberOfMovesToMakePalindrome {
  public int minMovesToMakePalindrome(String s) {
    char[] chars = s.toCharArray();
    return countSwap(chars);
  }

  int countSwap(char[] s) {
    int n = s.length;
    int res = 0;
    for (int i = 0; i < n / 2; i++) {
      int left = i;
      int right = n - left - 1;
      while (left < right) {
        if (s[left] == s[right]) {
          break;
        } else {
          right--;
        }
      }
      if (left == right) {
        int j = left;
        char t = s[j];
        s[j] = s[j + 1];
        s[j + 1] = t;
        res++;
        i--;
        continue;
      }
      for (int j = right; j < n - left - 1; j++) {
        char t = s[j];
        s[j] = s[j + 1];
        s[j + 1] = t;
        res++;
      }
    }
    return res;
  }
}
