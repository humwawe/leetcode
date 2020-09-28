package maximum.profit.of.operating.a.centennial.wheel;

/**
 * @author hum
 */
public class MaximumProfitOfOperatingACentennialWheel {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int profit = 0;
        int maxProfit = 0;
        int ans = -1;
        int waitCnt = 0;
        int turn = 0;
        while (waitCnt != 0 || turn < customers.length) {
            waitCnt += turn < customers.length ? customers[turn] : 0;
            int upCnt = Math.min(waitCnt, 4);
            waitCnt -= upCnt;
            profit += upCnt * boardingCost - runningCost;
            if (profit > maxProfit) {
                maxProfit = profit;
                ans = turn + 1;
            }
            turn++;
        }
        return ans;
    }

}
