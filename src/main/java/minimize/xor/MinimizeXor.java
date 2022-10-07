package minimize.xor;

/**
 * @author hum
 */
public class MinimizeXor {
  public int minimizeXor(int num1, int num2) {
    int c1 = Integer.bitCount(num1);
    int c2 = Integer.bitCount(num2);
    // 最低的 1 变成 0
    for (; c2 < c1; ++c2) {
      num1 &= num1 - 1;
    }
    // 最低的 0 变成 1
    for (; c2 > c1; --c2) {
      num1 |= num1 + 1;
    }
    return num1;
  }

}
