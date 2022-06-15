package calculate.amount.paid.in.taxes;

/**
 * @author hum
 */
public class CalculateAmountPaidInTaxes {
  public double calculateTax(int[][] brackets, int income) {
    int last = 0;
    int len = brackets.length;
    double res = 0;
    for (int[] bracket : brackets) {
      if (income > bracket[0]) {
        res += (bracket[0] - last) * bracket[1];
        last = bracket[0];
      } else {
        res += (income - last) * bracket[1];
        break;
      }
    }
    return res / 100;
  }
}
