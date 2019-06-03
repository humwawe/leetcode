package best.time.to.buy.and.sell.stock.III;

/**
 * @author hum
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][][] result = new int[prices.length + 1][2][3];
        result[0][1][0] = -prices[0];
        result[0][1][1] = -prices[0];
        result[0][1][2] = -prices[0];

        for (int i = 1; i <= prices.length; i++) {
            result[i][0][0] = result[i - 1][0][0];
            result[i][0][1] = Math.max(result[i - 1][0][1], result[i - 1][1][0] + prices[i - 1]);
            result[i][0][2] = Math.max(result[i - 1][0][2], result[i - 1][1][1] + prices[i - 1]);
            result[i][1][0] = Math.max(result[i - 1][1][0], result[i - 1][0][0] - prices[i - 1]);
            result[i][1][1] = Math.max(result[i - 1][1][1], result[i - 1][0][1] - prices[i - 1]);
        }
        return Math.max(result[prices.length][0][2], result[prices.length][0][1]);
    }
}
