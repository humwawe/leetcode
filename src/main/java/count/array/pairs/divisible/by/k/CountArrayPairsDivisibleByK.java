package count.array.pairs.divisible.by.k;

/**
 * @author hum
 */
public class CountArrayPairsDivisibleByK {
  public long coutPairs(int[] nums, int k) {
    int max = 0;
    for (int num : nums) {
      max = Math.max(num, max);
    }
    int[] cnt = new int[max + 1];
    for (int num : nums) {
      cnt[num]++;
    }
    for (int i = 1; i <= max; i++) {
      for (int j = i + i; j <= max; j += i) {
        cnt[i] += cnt[j];
      }
    }
    long res = 0;
    for (int num : nums) {
      res += cnt[k / gcd(k, num)];
      if ((long) num * num % k == 0) {
        res--;
      }
    }
    return res / 2;
  }

  int gcd(int a, int b) {
    return b != 0 ? gcd(b, a % b) : a;
  }
}
