package programmingChallenge.medium.dynamicprogramming;

import java.util.Arrays;

// https://leetcode.com/problems/partition-string-into-minimum-beautiful-substrings/
public class PartitionStringIntoMinimumBeautifulString {
    public int minimumBeautifulSubstrings(String s) {
        int n = s.length();
        int curr = Integer.parseInt(s, 2);
        if(curr == 0) return -1;

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;
        for(int i = n-1; i >= 0; i--){
            if(s.charAt(i) == '0') continue;
            for(int j = i+1; j <= n; j++){
                curr = Integer.parseInt(s.substring(i, j), 2);
                if(isRankOf5(curr) && dp[j] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[j]+1);
            }
        }
        return (dp[0] == Integer.MAX_VALUE) ? -1 : dp[0];
    }

    boolean isRankOf5(int num){
        if(num == 1) return true;
        int curr = 5;
        while(num > curr) curr *= 5;
        return curr == num;
    }
}
