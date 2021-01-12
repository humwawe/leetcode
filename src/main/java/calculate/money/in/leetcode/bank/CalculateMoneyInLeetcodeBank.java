package calculate.money.in.leetcode.bank;

/**
 * @author hum
 */
public class CalculateMoneyInLeetcodeBank {
    public int totalMoney(int n) {
        int res = 0;
        int tmp = 0;
        int tmp2 = 0;
        for (int i = 0; i < n; i++) {
            if (i % 7 == 0) {
                tmp += 1;
                tmp2 = tmp;
            }
            res += tmp2++;
        }
        return res;
    }
}
