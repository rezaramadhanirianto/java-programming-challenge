package programmingChallenge.medium.dynamicprogramming;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToSellStock {
    public int maxProfit(int[] prices) {
        int profit = 0, lowest = Integer.MAX_VALUE;
        for(int price: prices){
            if(price < lowest) lowest = price;
            else{
                if(price - lowest > profit) profit = price-lowest;
            }
        }
        return profit;
    }
}
