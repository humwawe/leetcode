package find.the.original.array.of.prefix.xor;

/**
 * @author hum
 */
public class FindTheOriginalArrayOfPrefixXor {
  public int[] findArray(int[] pref) {
    int n = pref.length;
    int[] res = new int[n];
    res[0] = pref[0];
    int sum = res[0];
    for (int i = 1; i < n; i++) {
      res[i] = sum ^ pref[i];
      sum ^= res[i];
    }
    return res;
  }
}
