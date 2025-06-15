package programmingChallenge.hard.dp;

import java.util.Arrays;

// https://leetcode.com/problems/count-of-integers/
public class CountOfIntegers {
    int MOD = (int) 1e9 + 7;
    int[][][] dp = new int[23][401][2];
    public int count(String num1, String num2, int minSum, int maxSum) {
        int n1 = num1.length();
        int n2 = num2.length();

        for(int i=0;i<23;i++){
            for(int j=0;j<401;j++) Arrays.fill(dp[i][j],-1);
        }
        int ans = helper(num2, minSum,maxSum,0,0,1);
        for(int i=0;i<23;i++){
            for(int j=0;j<401;j++) Arrays.fill(dp[i][j],-1);
        }
        ans -= helper(num1, minSum,maxSum,0,0,1);
        int digitSum  = getDigitSum(num1);
        if(digitSum<=maxSum && digitSum>=minSum) ans++;
        ans %= MOD;
        return (ans + MOD) % MOD;
    }

    int helper(String num, int minSum, int maxSum, int index, int sum, int tight){
        if(index == num.length()) return (sum >= minSum && sum <= maxSum) ? 1 : 0;

        if(dp[index][sum][tight]!=-1) return dp[index][sum][tight];

        int res = 0;
        int end = (tight == 1) ? num.charAt(index) - '0' : 9;
        for(int i = 0; i <= end; i++){
            int newTight = (i == end && tight == 1) ? 1 : 0;
            res += helper(num, minSum, maxSum, index+1, sum + i, newTight);
            res %= MOD;
        }

        return dp[index][sum][tight] = res;
    }

    int getDigitSum(String str) {
        int sum = 0;
        for(int i=0;i<str.length();i++){
            sum += (str.charAt(i)-'0');
        }
        return sum;
    }
}
