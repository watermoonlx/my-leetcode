/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
package 动态规划.买卖股票的最佳时机_121;

public class Solution_121 {
    public int maxProfit(int[] prices) {
        int accumulateProfit = 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            accumulateProfit += prices[i] - prices[i - 1];
            if (accumulateProfit > max) {
                max = accumulateProfit;
            }
            if (accumulateProfit < 0) {
                accumulateProfit = 0;
            }
        }

        return max;
    }
}
