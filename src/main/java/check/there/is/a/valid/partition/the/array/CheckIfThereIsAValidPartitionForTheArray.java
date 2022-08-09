package check.there.is.a.valid.partition.the.array;

/**
 * @author hum
 */
public class CheckIfThereIsAValidPartitionForTheArray {
  public boolean validPartition(int[] nums) {
    int len = nums.length;
    boolean[] dp = new boolean[len + 1];
    dp[0] = true;
    for (int i = 2; i <= len; i++) {
      if (nums[i - 1] == nums[i - 2]) {
        dp[i] |= dp[i - 2];
      }
      if (i - 3 >= 0 && nums[i - 1] == nums[i - 2] && nums[i - 1] == nums[i - 3]) {
        dp[i] |= dp[i - 3];
      }
      if (i - 3 >= 0 && nums[i - 1] == nums[i - 2] + 1 && nums[i - 1] == nums[i - 3] + 2) {
        dp[i] |= dp[i - 3];
      }
    }
    return dp[len];

  }
}
