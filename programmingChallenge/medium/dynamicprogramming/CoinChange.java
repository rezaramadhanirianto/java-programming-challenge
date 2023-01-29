package programmingChallenge.medium.dynamicprogramming;

// https://leetcode.com/problems/coin-change/description/
public class CoinChange {
    // key of dynamic programming is solve subproblem and use that subproblem to solve another problem
    // for this case we solve smallest amount that we can reach using coins that we have
    public int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;
        return helper(coins, amount, new int[amount+1]);
    }

    // basic concept similar to DFS in tree ex:
    // amount = 5, coins=[1,2]
    //                      count
    //         5             INF
    //        4 3           INF
    //       3             INF
    //      2             1+1(2)
    //     1             1
    //         5           INF
    //        4 3         INF
    //       3           INF
    //      2           Math.min(2, 1) -> 1
    //     1 0         1
    int helper(int[] coins, int sum, int[] dp){
        if(sum == 0) return 0;
        else if(sum < 0) return -1;
        else if(dp[sum] != 0) return dp[sum];

        int min = Integer.MAX_VALUE;
        for(int j = coins.length-1; j >= 0; j--){
            int res = helper(coins, sum-coins[j], dp);
            if(res == -1) continue;
            min = Math.min(min, res+1);
        }
        dp[sum] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[sum];
    }
}
