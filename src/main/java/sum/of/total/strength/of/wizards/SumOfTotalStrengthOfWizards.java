package sum.of.total.strength.of.wizards;

import java.util.Stack;

/**
 * @author hum
 */
public class SumOfTotalStrengthOfWizards {
  int mod = (int) (1e9 + 7);
  int len;

  public int totalStrength(int[] strength) {
    len = strength.length;
    long[] sum = new long[len + 1];
    long[] sum2 = new long[len + 2];
    for (int i = 1; i <= len; i++) {
      sum[i] = (sum[i - 1] + strength[i - 1]) % mod;
    }
    for (int i = 1; i <= len + 1; i++) {
      sum2[i] = (sum2[i - 1] + sum[i - 1]) % mod;
    }

    int[] left = new int[len];
    int[] right = new int[len];

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < len; i++) {
      while (!stack.isEmpty() && strength[i] <= strength[stack.peek()]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        left[i] = -1;
      } else {
        left[i] = stack.peek();
      }
      stack.push(i);
    }
    stack.clear();
    for (int i = len - 1; i >= 0; i--) {
      while (!stack.isEmpty() && strength[i] < strength[stack.peek()]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        right[i] = len;
      } else {
        right[i] = stack.peek();
      }
      stack.push(i);
    }
    long res = 0;
    for (int i = 0; i < len; i++) {

      int l = i - left[i];
      int r = right[i] - i;

      long s = 0;

      s += (long) l * r % mod * strength[i];
      s %= mod;
      s += (long) l * ((sum2[i + r + 1] - sum2[i + 2] + mod - sum[i + 1] * (r - 1) % mod + mod) % mod) % mod;
      s %= mod;
      s += (long) r * ((sum[i] * (l - 1) % mod - (sum2[i] - sum2[i - l + 1] + mod) % mod + mod) % mod) % mod;
      s %= mod;

      res = (res + strength[i] * s % mod) % mod;
    }

    return (int) (res % mod);

  }
}
