package best.time.to.buy.and.sell.stock.IV;

/**
 * @author hum
 */
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        k = Math.min(prices.length / 2, k);
        int[][][] result = new int[prices.length + 1][2][k + 1];
        for (int i = 0; i <= k; i++) {
            result[0][1][i] = -prices[0];
        }
        for (int i = 1; i <= prices.length; i++) {
            result[i][0][0] = result[i - 1][0][0];
            for (int j = 1; j <= k; j++) {
                result[i][0][j] = Math.max(result[i - 1][0][j], result[i - 1][1][j - 1] + prices[i - 1]);
                result[i][1][j - 1] = Math.max(result[i - 1][1][j - 1], result[i - 1][0][j - 1] - prices[i - 1]);
            }
        }
        return result[prices.length][0][k];
    }
}
