package count.good.triplets.in.an.array;

/**
 * @author hum
 */
public class CountGoodTripletsInAnArray {
  int N = (int) (1e5 + 5);
  int[] t = new int[N];

  public long goodTriplets(int[] nums1, int[] nums2) {
    int len = nums1.length;
    int[] idx = new int[len];
    for (int i = 0; i < len; i++) {
      idx[nums2[i]] = i;
    }
    int[] a = new int[len];
    for (int i = 0; i < len; i++) {
      a[i] = idx[nums1[i]] + 1;
    }
    long res = 0;
    for (int i = 0; i < len; i++) {
      long f = sum(a[i]);
      long e = len - a[i] - (sum(len) - sum(a[i]));
      res += f * e;
      add(a[i], 1);
    }
    return res;

  }

  int sum(int x) {
    int res = 0;
    for (int i = x; i > 0; i -= lowbit(i)) {
      res += t[i];
    }
    return res;
  }

  int lowbit(int x) {
    return x & -x;
  }

  void add(int x, int c) {
    for (int i = x; i < N; i += lowbit(i)) {
      t[i] += c;
    }
  }
}
