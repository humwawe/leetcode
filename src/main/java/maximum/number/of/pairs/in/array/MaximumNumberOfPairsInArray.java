package maximum.number.of.pairs.in.array;

/**
 * @author hum
 */
public class MaximumNumberOfPairsInArray {
  public int[] numberOfPairs(int[] nums) {
    int[] cnt = new int[105];
    for (int num : nums) {
      cnt[num]++;
    }
    int res1 = 0;
    for (int i = 0; i < 105; i++) {
      res1 += cnt[i] / 2;
    }
    return new int[]{res1, nums.length - res1 * 2};
  }
}
