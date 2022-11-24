package programmingChallenge.medium.dynamicprogramming;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BestTimeToSellStockII {
    // Greedy
    public int maxProfit(int[] prices) {
        int minBuy = Integer.MAX_VALUE, profit = 0;
        for(int price: prices){
            if(price < minBuy) minBuy = price;

            if(price - minBuy > 0){
                profit += price - minBuy;
                minBuy = price;
            }
        }
        return profit;
    }
}
