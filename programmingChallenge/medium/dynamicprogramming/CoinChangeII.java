package programmingChallenge.medium.dynamicprogramming;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change-ii/
public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for(int i = 0; i < n; i++) dp[i][0] = 1;

        for(int i = n - 1; i >= 0; i--){
            for(int j = 1; j <= amount; j++){
                if(coins[i] > j){
                    dp[i][j] = dp[i+1][j];
                } else {
                    dp[i][j] = dp[i+1][j] + dp[i][j - coins[i]];
                }
            }
        }
        return dp[0][amount];
    }

    // stores number of ways to make amount using coins with beginning i
    // dp[i][amount]
    // O(n * amount)
    int[][] dp;
    int[] coins;
    public int change2(int amount, int[] coins) {
        this.coins = coins;
        dp = new int[coins.length][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        int res = numberOfWays(0, amount);
        return res;
    }

    public int numberOfWays(int i, int amount) {
        if (amount == 0) return 1;
        else if (i == coins.length) return 0;
        else if (dp[i][amount] != -1) return dp[i][amount];
        else if (coins[i] > amount) return numberOfWays(i + 1, amount);

        dp[i][amount] = numberOfWays(i, amount - coins[i]) + numberOfWays(i + 1, amount);
        return dp[i][amount];
    }
}
