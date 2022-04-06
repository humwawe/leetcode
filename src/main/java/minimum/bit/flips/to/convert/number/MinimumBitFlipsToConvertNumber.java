package minimum.bit.flips.to.convert.number;

/**
 * @author hum
 */
public class MinimumBitFlipsToConvertNumber {
  public int minBitFlips(int start, int goal) {
    return Integer.bitCount(start ^ goal);
  }
}
