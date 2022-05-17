package largest.combination.with.bitwise.and.greater.than.zero;

/**
 * @author hum
 */
public class LargestCombinationWithBitwiseAndGreaterThanZero {
  public int largestCombination(int[] candidates) {
    int[] cnt = new int[25];
    int ans = 0;
    for (int c : candidates) {
      int idx = 0;
      while (c > 0) {
        cnt[idx++] += (c & 1);
        ans = Math.max(ans, cnt[idx - 1]);
        c >>= 1;
      }
    }
    return ans;
  }
}
