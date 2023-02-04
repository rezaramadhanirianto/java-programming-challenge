package programmingChallenge.medium.dynamicprogramming;

// https://leetcode.com/problems/ugly-number-ii/description/
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        if(n == 0) return 0;

        int[] dp = new int[n+1];
        dp[1] = 1;
        int fact1 = 1, fact2 = 1, fact3 = 1;
        for(int i = 2; i <= n; i++){
            int min = Math.min(dp[fact1]*2, Math.min(dp[fact2]*3, dp[fact3]*5));
            dp[i] = min;
            // to avoid same value
            if(dp[fact1]*2 == min) fact1++;
            if(dp[fact2]*3 == min) fact2++;
            if(dp[fact3]*5 == min) fact3++;
        }
        return dp[n];
    }
}
