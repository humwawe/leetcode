package minimum.money.required.before.transactions;

/**
 * @author hum
 */
public class MinimumMoneyRequiredBeforeTransactions {
  public long minimumMoney(int[][] transactions) {
    int n = transactions.length;
    long sum1 = 0;
    long sum2 = 0;
    long max1 = 0;
    long max2 = 0;
    for (int[] transaction : transactions) {
      if (transaction[0] <= transaction[1]) {
        max2 = Math.max(max2, transaction[0]);
        continue;
      }
      sum1 += transaction[0];
      sum2 += transaction[1];
      max1 = Math.max(max1, transaction[1]);
    }
    return sum1 - (sum2 - max1) + (Math.max(0, max2 - max1));
  }
}
