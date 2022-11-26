package programmingChallenge.medium.dynamicprogramming;

import java.util.Arrays;

// https://leetcode.com/problems/perfect-squares/
public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; ++i) {
            // code down below to check dp with number after - largest square
            // ex:
            // 4 -> 4 - 4 -> dp[0] + 1 -> 1
            // 12 -> 13 - 9 -> dp[4] + 1 -> 3
            // 16 -> 17 - 16 -> dp[1] + 1 -> 2
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        return dp[n];
    }
}
