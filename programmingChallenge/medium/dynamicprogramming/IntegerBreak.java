package programmingChallenge.medium.dynamicprogramming;

// https://leetcode.com/problems/integer-break/
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i/2; j++){
                // code down below check like
                // 2 -> 1 1
                // 3 -> 1 1 -- 2 1
                // ...
                // 8 -> 1 7, 2 6, 3 5, 4 4

                // and for nested Math max is for make sure we got maximum number from n factor
                // ex:
                // 8 -> can be
                // dp[3] -> 2 && dp[5] 6
                // Math.max(j,dp[j]) -> 3 and Math.max(i - j, dp[i - j]) -> 6
                // 3  * 6 => 18
                dp[i] = Math.max(dp[i], (Math.max(j,dp[j])) * (Math.max(i - j, dp[i - j])));
            }
        }
        return dp[n];
    }

    public int integerBreak2(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        int sum = 1;
        while(n > 4){
            sum *= 3;
            n -= 3;
        }
        sum *= n;
        return sum;
    }
}
