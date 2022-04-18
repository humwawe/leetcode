package design.an.atm.machine;

/**
 * @author hum
 */
public class DesignAnAtmMachine {
  long[] a = new long[5];
  long[] cnt = new long[5];

  public DesignAnAtmMachine() {
    a[0] = 20;
    a[1] = 50;
    a[2] = 100;
    a[3] = 200;
    a[4] = 500;
  }

  public void deposit(int[] banknotesCount) {
    for (int i = 0; i < banknotesCount.length; i++) {
      cnt[i] += banknotesCount[i];
    }
  }

  public int[] withdraw(int amount) {
    long x = amount;
    long[] tmp = new long[5];
    for (int i = 4; i >= 0; i--) {
      if (cnt[i] > 0) {
        tmp[i] = Math.min(cnt[i], x / a[i]);
        x -= tmp[i] * a[i];
      }
    }
    if (x != 0) {
      return new int[]{-1};
    }
    int[] res = new int[5];
    for (int i = 0; i < 5; i++) {
      cnt[i] -= tmp[i];
      res[i] = (int) tmp[i];
    }

    return res;
  }
}
