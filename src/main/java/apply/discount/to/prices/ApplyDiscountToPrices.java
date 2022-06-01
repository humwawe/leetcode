package apply.discount.to.prices;

/**
 * @author hum
 */
public class ApplyDiscountToPrices {
  public String discountPrices(String sentence, int discount) {
    discount = 100 - discount;
    String[] s = sentence.split(" ");
    for (int i = 0; i < s.length; i++) {
      if (s[i].charAt(0) == '$') {
        long x = check(s[i]);
        if (x == -1) {
          continue;
        }
        String t = String.valueOf(x * discount);
        StringBuilder sb = new StringBuilder(t);
        while (sb.length() < 3) {
          sb.insert(0, 0);
        }
        sb.insert(sb.length() - 2, '.');

        s[i] = "$" + sb.toString();
      }
    }
    return String.join(" ", s);
  }

  private long check(String s) {
    if (s.length() == 1) {
      return -1;
    }
    long res = 0;
    for (int i = 1; i < s.length(); i++) {
      if (!Character.isDigit(s.charAt(i))) {
        return -1;
      }
      res *= 10;
      res += s.charAt(i) - '0';
    }
    return res;
  }
}
