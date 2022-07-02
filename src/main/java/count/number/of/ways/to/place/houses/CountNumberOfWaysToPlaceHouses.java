package count.number.of.ways.to.place.houses;

/**
 * @author hum
 */
public class CountNumberOfWaysToPlaceHouses {
  public int countHousePlacements(int n) {
    int mod = 1000000007;
    long[] f = new long[n + 1];
    f[1] = 2;
    f[2] = 3;
    for (int i = 3; i <= n; i++) {
      f[i] = (f[i - 1] + f[i - 2]) % mod;
    }
    return (int) (f[n] * f[n] % mod);
  }
}
