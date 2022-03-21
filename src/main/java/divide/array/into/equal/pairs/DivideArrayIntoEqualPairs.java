package divide.array.into.equal.pairs;

/**
 * @author hum
 */
public class DivideArrayIntoEqualPairs {
  public boolean divideArray(int[] nums) {
    int[] cnt = new int[505];
    for (int num : nums) {
      cnt[num]++;
    }
    for (int i = 1; i <= 500; i++) {
      if (cnt[i] % 2 == 1) {
        return false;
      }
    }
    return true;
  }
}
