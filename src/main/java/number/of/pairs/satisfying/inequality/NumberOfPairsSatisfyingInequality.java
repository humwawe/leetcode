package number.of.pairs.satisfying.inequality;

/**
 * @author hum
 */
public class NumberOfPairsSatisfyingInequality {
  int base = (int) 5e4;

  public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
    int len = nums1.length;
    int[] nums = new int[len * 2];
    for (int i = 0; i < len; i++) {
      nums[i] = nums1[i] - nums2[i];
    }
    long res = 0;
    for (int i = 0; i < len; i++) {
      int x = nums[i] + diff + base;
      res += sum(x);
      add(nums[i] + base, 1);
    }
    return res;
  }


  int N = (int) 1e5;
  int[] t = new int[N];

  int lowbit(int x) {
    return x & -x;
  }

  void add(int x, int c) {
    for (int i = x; i < N; i += lowbit(i)) {
      t[i] += c;
    }
  }

  int sum(int x) {
    int res = 0;
    for (int i = x; i > 0; i -= lowbit(i)) {
      res += t[i];
    }
    return res;
  }
}
