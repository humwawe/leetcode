package richest.customer.wealth;

/**
 * @author hum
 */
public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int res = 0;
        for (int[] account : accounts) {
            int tmp = 0;
            for (int i : account) {
                tmp += i;
            }
            res = Math.max(res, tmp);
        }
        return res;
    }
}
