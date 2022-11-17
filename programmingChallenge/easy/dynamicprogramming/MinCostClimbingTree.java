package programmingChallenge.easy.dynamicprogramming;

// https://leetcode.com/problems/min-cost-climbing-stairs/
public class MinCostClimbingTree {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[cost.length+1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i <= n; i++){
            int temp = (i == n) ? 0: cost[i];
            dp[i] = Math.min(dp[i-1] + temp, dp[i-2] + temp);
        }
        return dp[n];
    }

    public int minCostClimbingStairs2(int[] cost) {
        int prevPrev = 0;
        int prev = 0;
        for(int i = 2; i <= cost.length; i++){
            int temp = Math.min(cost[i-1] + prev, cost[i-2] + prevPrev);
            prevPrev = prev;
            prev = temp;
        }
        return prev;
    }
}
