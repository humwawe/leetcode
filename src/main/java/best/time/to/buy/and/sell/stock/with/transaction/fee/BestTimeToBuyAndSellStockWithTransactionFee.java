package best.time.to.buy.and.sell.stock.with.transaction.fee;

/**
 * @author hum
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] result = new int[prices.length + 1][2];
        result[0][1] = -prices[0];
        for (int i = 1; i <= prices.length; i++) {
            result[i][0] = Math.max(result[i - 1][0], result[i - 1][1] + prices[i - 1] - fee);
            result[i][1] = Math.max(result[i - 1][1], result[i - 1][0] - prices[i - 1]);
        }
        return result[prices.length][0];
    }
}
