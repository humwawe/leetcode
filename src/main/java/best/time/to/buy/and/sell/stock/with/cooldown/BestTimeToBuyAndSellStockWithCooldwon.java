package best.time.to.buy.and.sell.stock.with.cooldown;

/**
 * @author hum
 */
public class BestTimeToBuyAndSellStockWithCooldwon {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int result[][] = new int[len + 1][3];
        result[0][1] = -prices[0];

        for (int i = 1; i <= prices.length; i++) {
            result[i][0] = result[i - 1][1] + prices[i - 1];
            result[i][1] = Math.max(result[i - 1][1], result[i - 1][2] - prices[i - 1]);
            result[i][2] = Math.max(result[i - 1][2], result[i - 1][1]);
        }
        return Math.max(result[len][0], result[len][2]);
    }

}
