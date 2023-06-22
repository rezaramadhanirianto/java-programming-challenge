package programmingChallenge.medium.dynamicprogramming;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
public class BestTimeToBuyAndSellStockWithFee {
    // I think main idea here just
    // in i day
    // hold previous stock or sell previous stock and buy current stock -> hold
    // same as yesterday or sell previous holding stock -> sold
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] hold = new int[n], sold = new int[n];
        hold[0] -= prices[0];
        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], sold[i - 1] - prices[i]);
            sold[i] = Math.max(sold[i - 1], hold[i - 1] + prices[i] - fee);
        }
        // Because in order to achieve maximum benefits, the final state must be sold out and will not be held in the hands.
        return sold[n - 1];
    }
}
